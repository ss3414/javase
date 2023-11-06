package library.util;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

public class GuavaTest {

    /* 1.1 使用和避免null */
//    @Test
    public void test11() {
        Optional<Integer> optional = Optional.of(1); /* Java8的Optional来自Guava */
        System.out.println(optional.isPresent());
    }

    /* 2.1 不可变集合 */
    @Test
    public void test21() {
        Map map = ImmutableMap.builder()
                .put("key", "value")
                .build();
        Map<String, Object> map2 = ImmutableMap.<String, Object>builder()
                .put("key", "value")
                .build();
    }

    /* 6 字符串 */
//    @Test
    public void test61() {
        Joiner joiner = Joiner.on("").skipNulls();
        System.out.println(joiner.join("str", null, "123"));
    }

}
