package c18.proxy;

public class LogProxy implements Log {

    private LogImpl logImpl;

    public LogProxy(LogImpl logImpl) {
        this.logImpl = logImpl;
    }

    @Override
    public void test() {
        System.out.println("LogImpl执行前");
        logImpl.test();
        System.out.println("LogImpl执行后");
    }

}
