package com.biezhi.c08;

import com.biezhi.common.dao.GithubDao;
import com.biezhi.common.model.Github;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C08 {

    @Autowired
    private GithubDao githubDao;

    /* Java7筛选排序 */
//    @Test
    public void test() {
        List<Github> resultList = new ArrayList<>();
        /* 筛选 */
        List<Github> githubList = githubDao.findAll();
        for (Github github : githubList) {
            if (github.getStars() >= 1000) {
                resultList.add(github);
            }
        }
        /* 排序（匿名内部类） */
        resultList.sort(new Comparator<Github>() {
            @Override
            public int compare(Github x, Github y) {
                return x.getStars().compareTo(y.getStars());
            }
        });
        System.out.println(resultList.size());
    }

    /* Java8筛选排序 */
    @Test
    public void test2() {
        List<Github> githubList = githubDao.findAll();
        List<Github> resultList = githubList.stream()
                .filter(github -> github.getStars() >= 1000) /* 过滤 */
                .sorted(Comparator.comparing(Github::getStars)) /* 排序 */
                .collect(Collectors.toList());
        System.out.println(resultList.size());
    }

    /*
     * ①集合与流
     * ②java.util.stream
     * ③在调用collect之前，filter/sorted均处于排队状态
     * ④外部迭代/内部迭代
     * */

    /*
     * stream操作
     * ①中间操作：filter()/sorted()，返回的是一个流
     * ②终端操作：collect()
     * */

}
