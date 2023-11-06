package com.biezhi.c03;

import com.biezhi.c03.service.GithubPredicate;
import com.biezhi.c03.service.impl.GithubLanguagePredicate;
import com.biezhi.c03.service.impl.GithubStarsPredicate;
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
import java.util.function.Predicate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C03 {

    /* 过滤Java项目（条件写在代码中） */
    public List<Github> test(List<Github> githubList) {
        List<Github> resultList = new ArrayList<>();
        for (Github github : githubList) {
            if ("Java".equals(github.getLanguage())) {
                resultList.add(github);
            }
        }
        return resultList;
    }

    /* 按语言过滤（传一个参数） */
    public List<Github> test2(List<Github> githubList, String language) {
        List<Github> resultList = new ArrayList<>();
        for (Github github : githubList) {
            if (language.equals(github.getLanguage())) {
                resultList.add(github);
            }
        }
        return resultList;
    }

    /* 按语言和stars数过滤（传两个个参数） */
    public List<Github> test3(List<Github> githubList, String language, Integer stars) {
        List<Github> resultList = new ArrayList<>();
        for (Github github : githubList) {
            if (language.equals(github.getLanguage()) && github.getStars() >= stars) {
                resultList.add(github);
            }
        }
        return resultList;
    }

    /* 按断言条件过滤（策略模式） */
    public List<Github> test4(List<Github> githubList, GithubPredicate githubPredicate) {
        List<Github> resultList = new ArrayList<>();
        for (Github github : githubList) {
            if (githubPredicate.condition(github)) {
                resultList.add(github);
            }
        }
        return resultList;
    }

    /* 按断言条件过滤（泛型） */
    public <T> List<T> test5(List<T> githubList, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>();
        for (T github : githubList) {
            if (predicate.test(github)) {
                resultList.add(github);
            }
        }
        return resultList;
    }

    /************************************************************分割线************************************************************/

    @Autowired
    private GithubDao githubDao;

    /*
     * ①值参数化
     * ②行为参数化
     * */
    @Test
    public void test() {
        List<Github> testList = test(githubDao.findAll());
        List<Github> testList2 = test2(githubDao.findAll(), "Java");
        List<Github> testList3 = test3(githubDao.findAll(), "Java", 1000);

        List<Github> testList4 = test4(githubDao.findAll(), new GithubLanguagePredicate("Java"));
        testList4 = test4(testList4, new GithubStarsPredicate(1000));

        /* 匿名内部类 */
        List<Github> testList5 = test5(githubDao.findAll(), new Predicate<Github>() {
            @Override
            public boolean test(Github github) {
                return "Java".equals(github.getLanguage());
            }
        });

        /* Lambda表达式 */
        List<Github> testList6 = test5(githubDao.findAll(), github -> "Java".equals(github.getLanguage()));
        /* 按stars数排序 */
        testList6.sort(Comparator.comparing(Github::getStars));
        System.out.println();
    }

}
