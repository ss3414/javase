package com.biezhi.c09;

import com.biezhi.common.dao.GithubDao;
import com.biezhi.common.model.Github;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C09 {

    @Autowired
    private GithubDao githubDao;

    /*
     * Stream API（上）
     * ①创建
     * ②筛选
     * ③映射
     * ④匹配
     * ⑤归约
     * ⑥数值
     * */

    /*
     * 创建
     * ①java.nio.file的Files/Paths
     * */
//    @Test
    @SneakyThrows
    public void test() {
        /* 值 */
        Stream<String> stream = Stream.of("1", "2", "3");

        /* 数组 */
        String[] array = {"1", "2", "3"};
        Stream<String> stream2 = Arrays.stream(array);

        /* 集合 */
        List<String> list = new ArrayList<>();
        Stream<String> stream3 = list.stream();

        /* 文件 */
        Stream stream4 = Files.lines(Paths.get("src/main/resources/application.properties"));
        System.out.println(stream4);

        /* iterator无限流 */
        Stream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    /* 筛选 */
//    @Test
    public void test2() {
        /* 筛选 */
        List<Github> githubList = githubDao.findAll();
        githubList.stream()
                .filter(github -> github.getStars() >= 1000)
                .collect(Collectors.toList());

        /* 去重 */
        githubList = githubDao.findAll();
        githubList.stream()
                .distinct() /* 不能自定义去重条件 */
                .collect(Collectors.toList());

        /* 截取/跳过 */
        githubList = githubDao.findAll();
        githubList.stream()
                .limit(10)
                .skip(5)
                .collect(Collectors.toList());
    }

    /* 映射 */
//    @Test
    public void test3() {
        /* map() */
        List<Github> githubList = githubDao.findAll();
        List<String> resultList = githubList.stream()
                .map(Github::getTitle)
                .collect(Collectors.toList());

        /* flatMap()合并多个流 */
        githubList = githubDao.findAll();
        resultList = githubList.stream()
                .map(github -> github.getTitle().split(" ")) /* 将title分割为数组并合并为一个流 */
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    /* 匹配 */
//    @Test
    public void test4() {
        /* anyMatch（任意一个） */
        List<Github> githubList = githubDao.findAll();
        boolean flag = githubList.stream()
                .anyMatch(github -> github.getStars() >= 1000);

        /* allMatch（所有） */
        githubList = githubDao.findAll();
        flag = githubList.stream()
                .allMatch(github -> github.getStars() >= 30);

        /* noneMatch（反向所有） */
        githubList = githubDao.findAll();
        flag = githubList.stream()
                .noneMatch(github -> github.getStars() <= 30); /* 是否所有元素stars都不小于30 */

        /* 获取第一个 */
        githubList = githubDao.findAll();
        Optional<Github> github = githubList.stream().findFirst();
    }

    /* 归约（求最值/平均值等） */
//    @Test
    public void test5() {
        /* 自定义Lambda表达式求和 */
        List<Github> githubList = githubDao.findAll();
        Integer result = githubList.stream()
                .map(Github::getStars)
                .reduce(0, (x, y) -> x + y); /* 两两相加 */

        /* Integer.sum()求和 */
        githubList = githubDao.findAll();
        result = githubList.stream()
                .map(Github::getStars)
                .reduce(0, Integer::sum);
    }

    /* 数值 */
    @Test
    public void test6() {
        List<Github> githubList = githubDao.findAll();
        IntStream stream = githubList.stream()
                .mapToInt(Github::getStars);
    }

}
