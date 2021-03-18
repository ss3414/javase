package c15;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.*;

public class C15_8 {

    /*
     * 序列化/反序列化
     * ①序列化：用二进制表示对象（将对象保存在二进制文件中），类必须实现Serializable/Externalizable接口
     * ②持久化（ORM）：把对象储存到数据库中
     * ③现状：用JSON/XML/byte数组代替，但是依然起标记作用（这个对象能否序列化）
     * */
    @Test
    public void test() throws IOException, ClassNotFoundException {
        Github github = Github.builder()
                .id(1L)
                .title("title1")
                .build();

        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Administrator/Desktop/test");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(github); /* 序列化 */

        File file = new File("C:/Users/Administrator/Desktop/test");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Github github2 = (Github) objectInputStream.readObject(); /* 反序列化 */
        System.out.println(github2);
    }

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Github implements Serializable {

    private static final long serialVersionUID = 1L; /* 标记序列化版本 */

    private Long id;

    /* static/transient修饰的字段不会被序列化 */
    private transient String title;

}
