package com.biezhi.c07;

import com.biezhi.common.model.Github;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C07_1 {

    /* Java8之前的解决方法 */
    public void test(Github github) {
        if (github != null) {
            if (github.getTitle() != null) {
                System.out.println(github);
            }
        }
    }

    public void test2(Github github) {
        if (github != null) {
            return;
        }
        if (github.getTitle() != null) {
            return;
        }
    }

    @Test
    public void test() {
        /* 创建Optional */
        Optional<Github> github = Optional.empty();
        Optional<Github> github2 = Optional.of(new Github());
        Optional<Github> github3 = Optional.ofNullable(new Github());

        /* 使用map()从Optional对象中提取和转换值 */
        Optional<Github> github4 = Optional.ofNullable(new Github(1L));
        Optional<Long> id = github4.map(Github::getId);

        /* 使用flatMap()（解决Optional嵌套问题） */
        Optional<Github> github5 = Optional.ofNullable(new Github());
        Optional<Long> id2 = github5.flatMap(Github::getGithub).map(Github::getId);

        /* 默认值 */
        Optional<Github> github6 = Optional.ofNullable(null);
        Long id3 = github6.map(Github::getId).orElse(2L);
    }

}
