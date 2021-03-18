package c10;

public class C10_4 {

    public static void test() throws Exception {
        try {
            /* 手动抛出异常必须处于try块中或带throws声明的方法中 */
            throw new Exception("Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        Integer i = null;
        System.out.println(i.toString());
    }

    public static void main(String[] args) throws Exception {
//        try {
//            test();
//            throw new RuntimeException("RuntimeException");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /*
         * 异常链
         * ①不应该将底层的原始异常直接抛给用户，应当抛出一个业务异常
         * ②责任链模式
         * */
        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
//            throw new Exception("NullPointerException");
        }
    }

}
