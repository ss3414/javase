package library.untitled;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Log4JDemo {

    /* 直接使用Log4J */
    private static final Logger logger = Logger.getLogger(Log4JDemo.class);

    @Test
    public void test() {
        /*
         * ①读取默认log4j配置文件
         * ②配置文件日志级别为ERROR级，只会输出ERROR级日志
         * */
        BasicConfigurator.configure();
        logger.debug("debug");
        logger.error("error");
    }

}
