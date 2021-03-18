package c06;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest {

    //    @Test
    public void test() {
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().id(1).name("name1").pwd("").build());
        userList.add(User.builder().id(2).name("name1").pwd("").build());
        userList.add(User.builder().id(3).name("name2").pwd("").build());
        userList.add(User.builder().id(4).name("name2").pwd("").build());

//        Map<String, List<User>> result = userList.stream().collect(Collectors.groupingBy(User::getName)); /* 分组（group by） */
//        result.forEach((key, value) -> System.out.println(key + ":" + value));

//        List<String> list = userList.stream().map(User::getName).collect(Collectors.toList()); /* 抽取List */
//        System.out.println(list);

        Map map = userList.stream().collect(Collectors.toMap(User::getId, User::getName)); /* 抽取Map */
        System.out.println(map);

//        /* 原子变量 */
//        AtomicReference<Integer> count = new AtomicReference<>(0);
//        userList.forEach(e -> count.updateAndGet(v -> v + e.getId()));
    }

    /* List交/并/差集 */
//    @Test
    public void list() {
        List<User> userList1 = new ArrayList<>();
        userList1.add(User.builder().id(1).name("name1").build());
        userList1.add(User.builder().id(2).name("name2").build());
        List<User> userList2 = new ArrayList<>();
        userList2.add(User.builder().id(1).name("name3").build());
        userList2.add(User.builder().id(3).name("name4").build());

        /* 交集 */
        List<User> userList3 = new ArrayList<>();
        userList1.forEach(user1 -> userList2.forEach(user2 -> {
            if (user1.getId().equals(user2.getId())) {
                userList3.add(user1);
            }
        }));
    }

    /* Map分组 */
//    @Test
    public void map() {
        List<Map<String, Object>> mapList = Arrays.asList(
                ImmutableMap.<String, Object>builder().put("name", Arrays.asList(1, 2, 3)).build(),
                ImmutableMap.<String, Object>builder().put("name", Arrays.asList(4, 5, 6)).build()
        );

        Map transfer = mapList.stream().collect(Collectors.groupingBy(e -> e.get("name")));
        transfer.forEach((key, value) -> {
//            System.out.println(key + ":" + value);
            Map<String, Object> val = new LinkedHashMap<>();
            val.put("val", value);
            transfer.put(key, val);
        });
        System.out.println(transfer);
    }

    /* Map排序 */
    @Test
    public void map2() {
        List<Map<String, Object>> tempList = Arrays.asList(
                ImmutableMap.<String, Object>builder().put("name", "name1").build(),
                ImmutableMap.<String, Object>builder().put("name", "name2").build(),
                ImmutableMap.<String, Object>builder().put("name", "name3").build()
        );

        List<Map<String, Object>> mapList = new ArrayList<>();
        int sort = 10;
        for (Map<String, Object> temp : tempList) {
            if ("name2".equals(temp.get("name"))) {
                Map<String, Object> map = new LinkedHashMap<>(temp);
                map.put("sort", 1);
                mapList.add(map);
            } else {
                Map<String, Object> map = new LinkedHashMap<>(temp);
                map.put("sort", sort);
                mapList.add(map);
                sort++;
            }
        }
        mapList.sort((map1, map2) -> (Integer) map1.get("sort") > (Integer) map2.get("sort") ? 0 : -1); /* 递增 */

        System.out.println(mapList);
    }

}
