package library.datasource;

import lombok.SneakyThrows;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.jupiter.api.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class LuceneTest {

    @Test
    @SneakyThrows
    public void test() {
        /* 中文分词器 */
        IKAnalyzer analyzer = new IKAnalyzer();

        /* 准备数据 */
        List<String> productList = new ArrayList<>();
        productList.add("飞利浦led灯泡e27螺口暖白球泡灯家用照明超亮节能灯泡转色温灯泡");
        productList.add("飞利浦led灯泡e14螺口蜡烛灯泡3W尖泡拉尾节能灯泡暖黄光源Lamp");
        productList.add("雷士照明 LED灯泡 e27大螺口节能灯3W球泡灯 Lamp led节能灯泡");
        productList.add("飞利浦 led灯泡 e27螺口家用3w暖白球泡灯节能灯5W灯泡LED单灯7w");
        productList.add("飞利浦led小球泡e14螺口4.5w透明款led节能灯泡照明光源lamp单灯");
        productList.add("飞利浦蒲公英护眼台灯工作学习阅读节能灯具30508带光源");
        productList.add("欧普照明led灯泡蜡烛节能灯泡e14螺口球泡灯超亮照明单灯光源");
        productList.add("欧普照明led灯泡节能灯泡超亮光源e14e27螺旋螺口小球泡暖黄家用");
        productList.add("聚欧普照明led灯泡节能灯泡e27螺口球泡家用led照明单灯超亮光源");

        /* 创建索引 */
        Directory index = new RAMDirectory(); /* 内存索引 */
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(index, config);
        for (String name : productList) {
            Document doc = new Document();
            doc.add(new TextField("name", name, Field.Store.YES));
            writer.addDocument(doc);
        }
        writer.close();

        /* 搜索器 */
        String keyword = "护眼带光源"; /* 模糊搜索关键词 */
        Query query = new QueryParser("name", analyzer).parse(keyword); /* 根据关键词基于name字段搜索 */

        /* 搜索 */
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader); /* searcher读取索引 */
        int numberPerPage = 1000; /* 每页显示多少数据 */
        System.out.printf("当前一共有%d条数据%n", productList.size());
        System.out.printf("搜索关键字是：\"%s\"%n", keyword);
        ScoreDoc[] hits = searcher.search(query, numberPerPage).scoreDocs; /* 搜索核心方法 */

        /* 结果 */
        System.out.println("找到 " + hits.length + " 个命中");
        System.out.println("序号\t匹配度得分\t结果");
        for (int i = 0; i < hits.length; ++i) {
            ScoreDoc scoreDoc = hits[i]; /* 具体的搜索结果 */
            int docId = scoreDoc.doc; /* 搜索结果在索引中的主键 */
            Document d = searcher.doc(docId); /* productList的索引形式 */
            List<IndexableField> fields = d.getFields();
            System.out.print((i + 1)); /* 序号 */
            System.out.print("\t" + scoreDoc.score); /* scoreDoc.score越高，匹配度越大 */
            for (IndexableField f : fields) {
                System.out.print("\t" + d.get(f.name()));
            }
            System.out.println();
        }

        /* 关闭搜索 */
        reader.close();
    }

}
