package com.biezhi.c05;

import com.biezhi.common.dao.GithubDao;
import com.biezhi.common.model.Github;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C05_3 {

    public List<String> test(List<Github> githubList) {
        List<String> resultList = new ArrayList<>();
        for (Github github : githubList) {
            resultList.add(github.getTitle());
        }
        return resultList;
    }

    public List<String> test2(List<Github> githubList, Predicate<Github> predicate) {
        List<String> resultList = new ArrayList<>();
        for (Github github : githubList) {
            if (predicate.test(github)) {
                resultList.add(github.getTitle());
            }
        }
        return resultList;
    }

    public <R> List<R> test3(List<Github> githubList, Predicate<Github> predicate, Function<Github, R> function) {
        List<R> resultList = new ArrayList<>();
        for (Github github : githubList) {
            if (predicate.test(github)) {
                resultList.add(function.apply(github));
            }
        }
        return resultList;
    }

    /************************************************************分割线************************************************************/

    @Autowired
    private GithubDao githubDao;

    /* 类型推断 */
    @Test
    public void test() {
        List<String> resultList = test(githubDao.findAll());

        /* ①forEach()+Lambda取代for循环 */
////        for (String title : resultList) {
////            System.out.println(title);
////        }
//        resultList.forEach(title -> System.out.println(title));

//        /* ②加上筛选条件 */
//        resultList = test2(githubDao.findAll(), github -> github.getStars() >= 1000);

//        /* ③加上类型转换 */
//        resultList = test3(githubDao.findAll(), github -> github.getStars() >= 1000, github -> github.getHref());

        /* ④自定义函数式接口 */
        resultList = test3(githubDao.findAll(), github -> github.getStars() >= 1000, MyFunction.test4());
        System.out.println(resultList.size());
    }

}

interface MyFunction<R> extends Function<Github, R> {

    /* 方法必须用static修饰 */
    static MyFunction<String> test4() {
        return Github::getHref;
    }

}
