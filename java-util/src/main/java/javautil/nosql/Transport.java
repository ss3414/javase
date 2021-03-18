package javautil.nosql;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

public class Transport {

    private static TransportClient client;

    /* 类初始化块 */
    static {
        InputStream inputStream = Transport.class.getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String host = properties.getProperty("es.host");
            Integer port = Integer.valueOf(properties.getProperty("es.transport.port"));
            Settings settings = Settings.builder().put("cluster.name", "docker-cluster").build();
            client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void query(String index, String type, String field) {
        SearchResponse searchResponse = client.prepareSearch(index)
                .setTypes(type)
                .addSort(field, SortOrder.DESC) /* 排序字段 */
                .get();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit hit : searchHits.getHits()) {
            System.out.println(hit.getSourceAsString());
        }
    }

    public static void main(String[] args) {
        Transport.query("untitled", "product", "score");
    }

}
