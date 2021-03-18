package c15;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class C15_3 {

    /* File>FileInputStream>byte（读取字节） */
    @Test
    public void test() throws IOException {
        File file = new File("C:/Users/Administrator/Desktop/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int size = Math.toIntExact(file.length());
        byte[] bytes = new byte[size];
        int length = fileInputStream.read(bytes);
//        System.out.println(Arrays.toString(bytes)); /* 输出字节 */
        System.out.println(new String(bytes, 0, length)); /* 输出字节编码后的字符 */
    }

    /* File>FileInputStream>InputStreamReader>BufferedReader（逐行读取字符） */
//    @Test
    public void test2() throws IOException {
        File file = new File("C:/Users/Administrator/Desktop/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        /* Windows记事本使用GBK编码/VSCode使用UTF-8 */
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK"); /* 字符输入流 */
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        List<String> list = new ArrayList<>();
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            list.add(line);
            line = bufferedReader.readLine();
        }
        for (String str : list) {
            System.out.println(str); /* 输出字节编码后的字符 */
        }
    }

    /* File>InputStream>byte>FileOutputStream（输入流另存为文件） */
//    @Test
    public void test3() throws IOException {
        File file = new File("C:/Users/Administrator/Desktop/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);

        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Administrator/Desktop/test2.txt");
        fileOutputStream.write(bytes);
    }

    /* File>FileWriter>BufferedWriter（修改字符文件） */
//    @Test
    public void test4() throws IOException {
        File file = new File("C:/Users/Administrator/Desktop/test.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("写入中文");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* OutputStream>InputStream */
    @Test
    public void test5() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
    }

}
