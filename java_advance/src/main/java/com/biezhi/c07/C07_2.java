package com.biezhi.c07;

import com.biezhi.common.model.Github;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C07_2 {

    @Test
    public void test() {
        Github github = new Github();
        github.setId(1L);
        github.setGithub(Optional.of(new Github(2L)));

        /*
         * ①先过滤，github中的Optional<Github>的id值是否为2L（断言）
         * ②如果存在则输出（消费者）
         * */
        github.getGithub()
                .filter(github2 -> github2.getId().equals(2L))
                .ifPresent(github2 -> System.out.println(github2.getId()));
    }

}
