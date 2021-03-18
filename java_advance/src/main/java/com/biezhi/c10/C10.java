package com.biezhi.c10;

import com.biezhi.common.dao.GithubDao;
import com.biezhi.common.model.Github;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C10 {

    @Autowired
    private GithubDao githubDao;

    /* Collector */
//    @Test
    public void test() {
        List<Github> githubList = githubDao.findAll();
        /* 计数 */
        githubList.stream().count(); /* count()等价于collect(Collectors.counting()) */
        /* 最值 */
        githubList.stream().max(Comparator.comparing(Github::getStars)); /* max()等价于collect(Collectors.maxBy()) */
        /* 平均值 */
        githubList.stream().collect(Collectors.averagingInt(Github::getStars));
        /* 求和 */
        githubList.stream().collect(Collectors.summarizingInt(Github::getStars));
        /* 连接字符串 */
        githubList.stream()
                .map(Github::getTitle)
                .collect(Collectors.joining("+"));
        /* 一般归约 */
        githubList.stream()
                .map(Github::getStars)
                .reduce((x, y) -> x + y); /* reduce()等价于collect(Collectors.reducing()) */
    }

    /* 将结果收集到Map中 */
//    @Test
    public void test2() {
        List<Github> githubList = githubDao.findAll();
        Map<String, Integer> map = githubList.stream()
                .collect(Collectors.toMap(Github::getTitle, Github::getStars));
        Map<String, Github> map2 = githubList.stream()
                .collect(Collectors.toMap(Github::getTitle, Function.identity()));
    }

    /* 分组 */
//    @Test
    public void test3() {
        List<Github> githubList = githubDao.findAll();
        /* 左边是语言，右边是语言对应的项目 */
        Map<String, List<Github>> map = githubList.stream()
                .collect(Collectors.groupingBy(Github::getLanguage));

        /* 左边是语言，右边是不同日期下的项目数 */
        Map<String, Map<String, Long>> map2 = githubList.stream()
                .collect(Collectors.groupingBy(Github::getLanguage, Collectors.groupingBy(Github::getCreateTime, Collectors.counting())));
        System.out.println(map2);
    }

    /* 分区 */
//    @Test
    public void test4() {
        List<Github> githubList = githubDao.findAll();
        /* 返回语言是否为Java的项目 */
        Map<Boolean, List<Github>> map = githubList.stream()
                .collect(Collectors.partitioningBy(github -> "Java".equalsIgnoreCase(github.getLanguage())));
        System.out.println(map);
    }

    /* 转换类型 */
//    @Test
    public void test5() {
        List<Github> githubList = githubDao.findAll();
        Collection<Github> collection = new HashSet<>(githubList); /* 等价于collect(Collectors.toCollection(HashSet::new)) */
        System.out.println(collection);

        /*
         * ①获取每种语言stars数最高的项目
         * ②等价于collect(Collectors.groupingBy(Github::getLanguage, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Github::getStars)), Optional::get)))
         * */
        Map<String, Github> map = githubList.stream()
                .collect(Collectors.toMap(Github::getLanguage, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Github::getStars))));
        System.out.println(map);
    }

    /* 并行流 */
    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long begin = System.nanoTime();
        list.stream().sorted();
        long times = System.nanoTime() - begin;
        System.out.println("耗时：" + times / 1000000.0 + "毫秒");

        begin = System.nanoTime();
        list.parallelStream().sorted();
        times = System.nanoTime() - begin;
        System.out.println("耗时：" + times / 1000000.0 + "毫秒");
    }

}
