package library.util;

import cn.hutool.core.codec.Base64;
import javautil.nosql.REST;
import javautil.security.JWT;
import javautil.sql.JDBC;
import javautil.test.Consume;
import javautil.test.ConsumeExtension;
import javautil.untitled.Encode;
import lombok.SneakyThrows;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Map;

@ExtendWith(ConsumeExtension.class)
public class JavaUtilTest {

    //    @Test
    public void common() {
//        System.out.println(javautil.common.File.parse("C:/Users/Administrator/Desktop/test.jpg"));
//        System.out.println(javautil.common.File.parse(new File("C:/Users/Administrator/Desktop/test.jpg")));
    }

    //    @Test
    @Consume
    @SneakyThrows
    public void elasticsearch() {
        REST util = new REST("http", "127.0.0.1", 9200);
        String index = "untitled";
        String table = "product";

        /* 索引/映射 */
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
//                .startObject("product")
//                .startObject("properties")
//                .startObject("name").field("type", "text").field("analyzer", "")
//                .endObject().endObject().endObject()
                .endObject();
        if (util.indexExist(index)) {
            util.deleteIndex(index);
            util.createIndex(index, table, builder);
        } else {
            util.createIndex(index, table, builder);
        }

//        /* 文档 */
//        Map map = new HashMap();
//        util.insertDocument(index, "product", map);
//        util.updateDocument(index, "product", map, "name");
//        util.deleteDocument(index, "product", "");
//
//        GetResponse response = util.getDocument(index, "product", "");
//        System.out.println(response.getSourceAsString());

        /* 批量创建 */
        JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false&characterEncoding=utf-8", "root", "2468");
        List<Map<String, Object>> resultList = jdbc.select("SELECT * FROM `" + table + "`");
        util.batchInsert(index, table, resultList);
//        util.batchDelete(index, table, resultList);

        /* 查询/聚合 */
//        util.query(index, table, 1, 10); /* 精确/范围 */
//        util.aggregation(index, table, 1, 10); /* 聚合 */

        /* 全文检索 */
//        util.search(index, 1, 10, true);
    }

    //    @Test
    public void security() {
//        System.out.println(Security.HmacSHA256("key","message"));
//        System.out.println(Security.MD5("123456"));

//        System.out.println(JWT.getName(JWT.sign("name1", "123456", 5 * 60)));

        /*
         * JWT
         * ①JWT分为3段
         * ②第1段header（生成JWT的算法）
         * ③第2段payload（有效信息：name/exp）
         * ④第3段signature
         * */
        String jwt = JWT.sign("name1", "123456", 5 * 60);
        String[] jwtArray = jwt.split("\\.");
        System.out.println(Base64.decodeStr(jwtArray[0]));
        System.out.println(Base64.decodeStr(jwtArray[1]));
    }

    //    @Test
//    @Consume(unit = "ms")
    public void jdbc() {
        JDBC util = new JDBC("jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false&characterEncoding=utf-8", "root", "2468");
        List<Map<String, Object>> resultList = util.select("SELECT * FROM `user`");
    }

    //    @Test
//    @Consume
    @SneakyThrows
    public void test() {
        Thread.sleep(1000);
    }

    @Test
    public void untitled() {
//        System.out.println(Encode.getEncoding("中文"));
        System.out.println(Encode.convert2utf8("中文", "UTF-8"));

//        Image.formatConvert(new File("C:/Users/Administrator/Desktop/test.jpg"), "png");
//        Image.formatConvert(new File("C:\\Users\\Administrator\\Desktop\\test.jpg"), "png");
//        Image.textWatermark(new File("C:/Users/Administrator/Desktop/test.jpg"));
//        Image.imgWatermark("C:/Users/Administrator/Desktop/test.jpg", "C:/Users/Administrator/Desktop/render.jpg");
    }

}
