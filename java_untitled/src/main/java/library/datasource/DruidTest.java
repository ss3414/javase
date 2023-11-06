package library.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DruidTest {

    @Test
    @SneakyThrows
    public void test() {
        Properties properties = new Properties();
        properties.load(DruidTest.class.getResourceAsStream("/application.properties"));

        /* 初始化数据源（Spring项目中数据源交由Spring管理） */
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        System.out.println(resultSet);
    }

}
