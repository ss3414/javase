package javautil.nosql;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class REST {

    private static RestHighLevelClient client;

    public REST(String scheme, String host, Integer port) {
        /* 超时设置 */
        RestClientBuilder.RequestConfigCallback callback = builder -> {
            builder.setConnectTimeout(60 * 1000).setSocketTimeout(60 * 1000);
            return builder;
        };
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port, scheme)).setRequestConfigCallback(callback)
        );
    }

    /* 判断索引是否存在 */
    public boolean indexExist(String index) {
        boolean result = true;
        try {
            OpenIndexRequest request = new OpenIndexRequest(index);
            client.indices().open(request, RequestOptions.DEFAULT).isAcknowledged();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    /* 创建索引 */
    public void createIndex(String index, String type, XContentBuilder builder) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(index).mapping(type, builder);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /* 删除索引 */
    public void deleteIndex(String index) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        client.indices().delete(request, RequestOptions.DEFAULT);
    }

    /************************************************************分割线************************************************************/

    /* 插入文档 */
    public void insertDocument(String index, String type, Map map) throws IOException {
        IndexRequest request = new IndexRequest(index, type, String.valueOf(map.get("uuid"))).source(map); /* 用uuid作为id */
        client.index(request, RequestOptions.DEFAULT);
    }

    /* 修改文档 */
    public void updateDocument(String index, String type, Map map, String field) throws IOException {
        UpdateRequest request = new UpdateRequest(index, type, String.valueOf(map.get("uuid"))).doc(field, map.get(field));
        client.update(request, RequestOptions.DEFAULT);
    }

    /* 获取文档 */
    public GetResponse getDocument(String index, String type, String id) throws IOException {
        GetRequest request = new GetRequest(index, type, id);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        return response;
    }

    /* 删除文档 */
    public void deleteDocument(String index, String type, String id) throws IOException {
        DeleteRequest request = new DeleteRequest(index, type, id);
        client.delete(request, RequestOptions.DEFAULT);
    }

    /* 批量插入（uuid） */
    public void batchInsert(String index, String type, List<Map<String, Object>> mapList) throws IOException {
        if (!indexExist(index)) {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject().endObject();
            createIndex(index, type, builder);
        }
        BulkRequest request = new BulkRequest();
        mapList.forEach(e -> {
            IndexRequest indexRequest = new IndexRequest(index, type, String.valueOf(e.get("uuid"))).source(e);
            request.add(indexRequest);
        });
        client.bulk(request, RequestOptions.DEFAULT);
    }

    /* 批量删除 */
    public void batchDelete(String index, String type, List<Map<String, Object>> mapList) throws IOException {
        BulkRequest request = new BulkRequest();
        mapList.forEach(e -> {
            DeleteRequest deleteRequest = new DeleteRequest(index, type, String.valueOf(e.get("uuid")));
            request.add(deleteRequest);
        });
        client.bulk(request, RequestOptions.DEFAULT);
    }

    /************************************************************分割线************************************************************/

    /* 查询 */
    public void query(String index, String type, Integer currentPage, Integer pageSize) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        /* 分页 */
        searchSourceBuilder.from((currentPage - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        /* 排序 */
//        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC)); /* _score字段 */
//        searchSourceBuilder.sort("", SortOrder.DESC); /* 指定字段 */

        /* 精确 */
//        searchSourceBuilder.query(QueryBuilders.termQuery(".keyword", "")); /* 查询字符串统一使用.keyword */
//        searchSourceBuilder.query(QueryBuilders.termsQuery(".keyword", "")); /* terms（term多值） */
        /* 范围 */
//        searchSourceBuilder.query(QueryBuilders.rangeQuery("").gte("").lt("")); /* 大于等于/小于 */
        /* 多条件 */
//        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
//                .must(QueryBuilders.termQuery("category.keyword", "手机会场"))
//                .must(QueryBuilders.termQuery("area.keyword", "北京"));
//        searchSourceBuilder.query(queryBuilder);

        /* SearchRequest */
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        request.source(searchSourceBuilder);
        System.out.println(searchSourceBuilder.toString()); /* ES Java转DSL */
        /* SearchResponse */
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits searchHits = response.getHits();
        for (SearchHit hit : searchHits) {
            System.out.println(hit.getSourceAsString());
        }
        System.out.println(searchHits.getTotalHits());
    }

    /* 聚合 */
    public void aggregation(String index, String type, Integer currentPage, Integer pageSize) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from((currentPage - 1) * pageSize);
        searchSourceBuilder.size(pageSize);

        /*
         * 聚合
         * ①聚合的字段类型只能是keyword/number
         * fixme 无法查询所有聚类，查询前10000条
         * */
        searchSourceBuilder.aggregation(AggregationBuilders.terms("group by").field("category.keyword").size(10000));
//        /* 查询多个字段的聚合 */
//        searchSourceBuilder.aggregation(AggregationBuilders.terms("category").field("category.keyword"))
//                .aggregation(AggregationBuilders.terms("area").field("area.keyword"));
//        /* 聚合+函数 */
//        searchSourceBuilder.aggregation(AggregationBuilders.terms("group by").field("")
//                .subAggregation(AggregationBuilders.count("count").field("id"))); /* 相当于SELECT field,COUNT(id) FROM index GROUP BY field */

        SearchRequest request = new SearchRequest(index);
        request.types(type);
        request.source(searchSourceBuilder);
        System.out.println(searchSourceBuilder.toString()); /* ES Java转DSL */
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        /* 聚合结果 */
        ParsedStringTerms parsedStringTerms = response.getAggregations().get("group by");
        List<? extends Bucket> bucketList = parsedStringTerms.getBuckets();
        Map map = bucketList.stream().collect(Collectors.toMap(Bucket::getKey, Bucket::getDocCount));
        System.out.println(map);
    }

    /* 全文检索 */
    public void search(String index, Integer currentPage, Integer pageSize, Boolean highlight) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from((currentPage - 1) * pageSize);
        searchSourceBuilder.size(pageSize);

        /* 模糊检索 */
//        MatchQueryBuilder queryBuilder = new MatchQueryBuilder("name", "瓷砖").fuzziness(Fuzziness.AUTO);

        /* 权重（默认1.0） */
        Map<String, Float> fields = new LinkedHashMap<>();
        fields.put("name", 1.0F);
//        fields.put("area", 2.0F);

        /* 多字段检索 */
        MultiMatchQueryBuilder queryBuilder = new MultiMatchQueryBuilder("").fields(fields).fuzziness(Fuzziness.AUTO);

//        /* 查询+检索 */
//        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
//                .must(QueryBuilders.termQuery("category.keyword", "品质建材"))
//                .must(new MultiMatchQueryBuilder("瓷砖").fields(fields).fuzziness(Fuzziness.AUTO));

        /* 高亮 */
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span style='color: red'>");
        highlightBuilder.postTags("</span>");
        highlightBuilder.field("name");
        highlightBuilder.field("area");

        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC)); /* 匹配度从高到低 */

        SearchRequest request = new SearchRequest(index);
        request.source(searchSourceBuilder);
        System.out.println(searchSourceBuilder.toString()); /* ES Java转DSL */
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            if (highlight) {
                /* 高亮 */
                Map<String, Object> sourceMap = hit.getSourceAsMap();
                Map<String, Object> tempMap = new LinkedHashMap<>(sourceMap);
                Map<String, HighlightField> highlightMap = hit.getHighlightFields();
                /* 高亮替换（高亮字段替换原有字段） */
                highlightMap.forEach((highlightKey, highlightValue) -> {
                    tempMap.forEach((sourceKey, sourceValue) -> {
                        if (highlightKey.equals(sourceKey)) {
                            sourceMap.put(sourceKey, highlightValue.getFragments()[0].string());
                        }
                    });
                });
                System.out.println(sourceMap);
            } else {
                System.out.println(hit.getSourceAsString());
            }
        }
    }

    public static void main(String[] args) {
        try {
            REST util = new REST("http", "127.0.0.1", 9200);
            util.search("untitled", 1, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
