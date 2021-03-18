package c04;

import org.junit.jupiter.api.Test;

public class C04_2 {

    /* switch */
    @Test
    public void test() {
        String flag = "2";
        int result = 0;
        /* switch的原理是跳转到case X的位置执行接下来的语句，直到遇见break */
        switch (flag) {
            case "1":
                result = 1;
                break;
            case "2":
                result = 2;
                break;
            case "3":
                result = 3;
                break;
            default:
                result = 0;
        }
        System.out.println(result);
    }

}
