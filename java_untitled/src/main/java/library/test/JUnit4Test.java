package library.test;

import org.junit.*;

public class JUnit4Test {

    /* 只会运行一次，且第一个运行 */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    /* 测试方法前运行 */
    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test() {
        Log log = new Log();
        System.out.println(log.print());
    }

    @Test
    @Ignore /* 忽略 */
    public void test2() {
        System.out.println(Log.print2());
    }

    /* 测试方法后运行 */
    @After
    public void after() {
        System.out.println("after");
    }

    /* 只会运行一次，且最后一个运行 */
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

}
