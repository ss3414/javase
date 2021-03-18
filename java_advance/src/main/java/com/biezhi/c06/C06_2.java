package com.biezhi.c06;

import com.biezhi.c06.service.Interface1;
import com.biezhi.c06.service.Interface2;
import com.biezhi.c06.service.impl.Interface1Impl;
import com.biezhi.c06.service.impl.Interface2Impl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C06_2 {

    /*
     * 多实现冲突
     * ①类（实现类）中方法>接口默认方法
     * ②子接口>父接口
     * ③显式选择默认方法
     * */
    @Test
    public void main() {
        Interface1 interface1 = new Interface1Impl();
        interface1.test(); /* 实现类重写了接口默认方法 */

        Interface2 interface2 = new Interface2Impl();
        interface2.test(); /* 实现类实现了2个接口，子接口继承自父接口 */
    }

}
