package javautil.test;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConsumeExtension implements BeforeAllCallback, AfterEachCallback {

    private List<Time> timeList = new ArrayList<>();

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Class clazz = extensionContext.getRequiredTestClass();
        extensionContext.getElement();
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Consume.class)) {
                Time time = new Time(); /* fixme 无法使用Lombok */
                time.setMethod(method.getName());
                time.setBegin(LocalDateTime.now());
                timeList.add(time);
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        Method method = extensionContext.getTestMethod().get();
        Consume consume = method.getAnnotation(Consume.class);
        if (consume != null) {
            String unit = consume.unit();
            String name = extensionContext.getTestMethod().get().getName();
            timeList.forEach(time -> {
                if (time.getMethod().equals(name)) {
                    LocalDateTime begin = time.getBegin();
                    LocalDateTime end = LocalDateTime.now();
                    Duration duration = Duration.between(begin, end);
                    time.setEnd(end);
                    time.setDuration(duration);
                    String str = "";
                    if ("s".equals(unit)) {
                        str = String.format("%s %s~%s 耗时：%s秒", name,
                                begin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                duration.getSeconds());
                    } else if ("ms".equals(unit)) {
                        str = String.format("%s %s~%s 耗时：%s毫秒", name,
                                begin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                duration.getSeconds());
                    }
                    System.out.println(str);
                }
            });
        }
    }

}
