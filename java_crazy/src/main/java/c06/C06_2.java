package c06;

public class C06_2 {

    /*
     * ①hashCode和equals
     * 哈希值相同不代表是同一个对象（哈希碰撞），不同肯定不是
     * 如果哈希值相同，再通过equals比较
     * ②==和equals
     * ==：基本类型比较的是值，引用类型比较的是内存地址
     * equals：没有重写equals方法（相当于==），自反性/对称性/传递性/一致性
     * */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
