package library.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.http.HttpUtil;
import library.bean.Parent;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class HutoolTest {

    interface Log {

        void test();

    }

    static class LogImpl implements Log {

        @Override
        public void test() {
            System.out.println("LogImpl");
        }

    }

    /* hutool-aop */
//    public static void main(String[] args) {
//        Log logImpl = ProxyUtil.proxy(new LogImpl(), TimeIntervalAspect.class);
//        logImpl.test();
//    }

    /************************************************************分割线************************************************************/

    /* hutool-core（核心） */
    @Test
    @SneakyThrows
    public void core() {
        /* （Base64）Base64 */
//        String str = "123456";
//        System.out.println(Base64.decodeStr(Base64.encode(str)));

        /* （BeanUtil）Map转对象 */
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1);
//        map.put("name", "name1");
//        map.put("password", "pwd1");
//        Parent parent = BeanUtil.fillBeanWithMapIgnoreCase(map, new Parent(), true);
//        parent = BeanUtil.mapToBeanIgnoreCase(map, Parent.class, true); /* Bean需要有构造方法 */
//        System.out.println(parent);

        /* （BeanUtil）对象转Map */
//        Parent parent = Parent.builder().id(1).name("name").password("pwd").build();
//        Map<String, Object> map = BeanUtil.beanToMap(parent, false, true);
//        System.out.println(map);

        /* （BeanUtil）对象转对象 */
        Parent parent1 = Parent.builder().id(1).build();
        Parent parent2 = Parent.builder().id(2).password("pwd2").build();
        BeanUtil.copyProperties(parent1, parent2, CopyOptions.create().setIgnoreNullValue(true)); /* 复制非null属性 */
        System.out.println(parent2);

        /* （BeanUtil）fastjson转对象（fastjson本身就是Map） */
//        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
//        jsonObject.put("id", 1);
//        jsonObject.put("name", "name1");
//        jsonObject.put("password", "pwd1");
//        Parent parent = BeanUtil.fillBeanWithMapIgnoreCase(jsonObject, new Parent(), true);
//        System.out.println(parent);

        /* （DateUtil） */
//        String str = "2019-01-01 01:00:00";
//        System.out.println(DateUtil.parse(str));

        /* （FileUtil） */
//        System.out.println(FileUtil.readString(new File("C:/Users/Administrator/Desktop/test.txt"), "UTF-8"));

        /* （FileReader） */
//        FileReader fileReader = new FileReader("C:/Users/Administrator/Desktop/test.txt");
//        List<String> lineList = fileReader.readLines();

        /* （IdUtil）UUID */
//        System.out.println(IdUtil.randomUUID());
//        System.out.println(IdUtil.simpleUUID());

        /* （JSONUtil） */
//        System.out.println(JSONUtil.toJsonStr(Arrays.asList(1, 2, 3)));

        /* （NetUtil） */
//        String ip = "127.0.0.1";
//        System.out.println(NetUtil.ipv4ToLong(ip)); /* ipv4转long */
//        System.out.println(NetUtil.longToIpv4(NetUtil.ipv4ToLong(ip))); /* long转ipv4*/

        /* （ObjectUtil）克隆（对象需实现Serializable接口） */
//        Parent parent1 = Parent.builder().id(1).password("pwd1").build();
//        Parent parent2 = ObjectUtil.clone(parent1);
//        parent2.setId(2);
//        System.out.println(parent1);
//        System.out.println(parent2);

        /* （ReUtil） */
//        String str = "123456@qq.com";
//        System.out.println(ReUtil.isMatch("^([A-Za-z0-9]*)@([A-Za-z0-9]*)\\.([A-Za-z]*)$", str)); /* 邮箱校验 */
//        System.out.println(ReUtil.replaceAll(str, "\\s", "")); /* 替换 */
//        System.out.println(ReUtil.getGroup0("(\\d)", str));

        /* （StrUtil） */
//        String str1 = null;
//        String str2 = " ";
//        System.out.println(StrUtil.isEmpty(str1)); /* 只判断null和"" */
//        System.out.println(StrUtil.isBlank(str2)); /* 不可见字符也算空（如空格） */

        /* （UnicodeUtil） */
//        System.out.println(UnicodeUtil.toUnicode("中　文", false));
//        System.out.println(UnicodeUtil.toString("\\u4e2d\\u3000\\u6587")); /* \u3000（全角空白符） */
        /*
         * ①将全角空白符（Unicode 12288）替换为空格
         * ②Java中用\s+而非\s*匹配任意空白符
         * */
//        System.out.println("中文　中文".replace((char) 12288, ' ').replaceAll("\\s+", ""));

        /* （XmlUtil） */
//        Parent parent = Parent.builder().id(1).name("name").password("pwd").build();
//        XmlUtil.writeObjectAsXml(new File("C:/Users/Administrator/Desktop/test.xml"), parent);
    }

    /* hutool-crypto（加密/解密） */
//    @Test
    public void crypto() {
        String str = "123456";

        /* 摘要加密（MD5） */
//        System.out.println(SecureUtil.md5(str));
//        System.out.println(DigestUtil.md5Hex(str)); /* 没有加盐 */

        /*
         * 对称加密（DES）
         * */
//        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
//        DES des = SecureUtil.des(key);
//        System.out.println(des.encryptHex(str)); /* 加密为16进制字符串 */
//        System.out.println(des.decryptStr(des.encryptHex(str)));

        /* 非对称加密（RSA） */
        RSA rsa = new RSA();
        /* 公钥加密，私钥解密（加密） */
        byte[] encrypt = rsa.encrypt(StrUtil.bytes(str, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        System.out.println(str.equals(StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8)));
        /* 私钥加密，公钥解密（签名） */
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes(str, CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
        System.out.println(str.equals(StrUtil.str(decrypt2, CharsetUtil.CHARSET_UTF_8)));

        /* 签名 */
//        KeyPair pair = SecureUtil.generateKeyPair("RSA");
//        PrivateKey privateKey = pair.getPrivate();
//        PublicKey publicKey = pair.getPublic();
//        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
//        sign.setPrivateKey(privateKey);
//        byte[] bytes = sign.sign(str.getBytes()); /* 用私钥签名 */
//        sign.setPublicKey(publicKey);
//        System.out.println(sign.verify(str.getBytes(), bytes)); /* 用公钥验签 */
    }

    /* hutool-extra（扩展） */
//    @Test
    public void test() {
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("", TemplateConfig.ResourceMode.FILE));
        Template template = engine.getTemplate("template.ftl");
        String str = template.render(Dict.create().set("user", "user1"));
        System.out.println(str);
    }

    /* hutool-http（HTTP客户端） */
//    @Test
    public void http() {
        String result = HttpUtil.get("http://httpbin.org/get", CharsetUtil.CHARSET_UTF_8);
        System.out.println(result);

//        Map<String, Object> param = new HashMap<>();
//        param.put("key", "value");
//        String result2 = HttpUtil.post("http://httpbin.org/post", param);
//        System.out.println(result2);
    }

}
