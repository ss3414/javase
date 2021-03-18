package c03;

public class C03_4 {

    /* 基本类型 */
    public void test() {
        int i = 1; /* 整型：32位，-2^31~2^31-1 */
        short j = (short) 1; /* 短整型：16位，-2^15~2^15-1 */
        long k = 1L; /* 长整型：64位，-2^63~2^63-1 */
        byte l = (byte) 1; /* 比特型：8位，-2^7~2^7-1 */

        /*
         * ①ASCII，2^8=256
         * ②Unicode，2^16=65536（前256个与ASCII相同）
         * */
        char m = 'm'; /* 字符型：16位无符号，0~2^16-1 */
        char n = '\n'; /* 转义符 */
        char o = '\u0000'; /* 十六进制Unicode值 */

        float f = 1.0F; /* 32位 */
        double d = 1.0; /* 64位 */

        boolean flag = true; /* 8位 */
    }

    /* 字面量 */
    public void test2() {
        int i = 1;
        long j = 1L;

        char k = 'm';

        float f = 1.0F;
        double d = 1.0;

        boolean flag = true;

        String str1 = "str1";

        String str2 = null; /* null可以赋值给任何引用类型 */
    }

}
