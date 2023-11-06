package javautil.sql;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class JDBC {

    private static Connection connection;

    /* 初始化（传参） */
    @SneakyThrows
    public JDBC(String url, String username, String password) {
        /* 加载MySQL8/5的驱动 */
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    /* 初始化（读取配置） */
    @SneakyThrows
    public JDBC() {
        /* 打包成jar包后，会寻找引入项目resources目录下的application.properties */
        InputStream inputStream = JDBC.class.getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    /* 查询返回通用结果集 */
    @SneakyThrows
    public List<Map<String, Object>> select(String sql) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            Map<String, Object> map = new HashMap<>();
            /* 下标从1开始 */
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                map.put(metaData.getColumnName(i), resultSet.getObject(metaData.getColumnName(i)));
            }
            resultList.add(map);
        }
        resultSet.close();
        statement.close();
        return resultList;
    }

}
