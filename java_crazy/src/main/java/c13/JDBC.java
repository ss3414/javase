package c13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    /*
     * java命令运行含第三方依赖的class文件
     * ①编译：javac -cp C:\Users\Administrator\.m2\repository\mysql\mysql-connector-java\8.0.19\mysql-connector-java-8.0.19.jar -encoding UTF-8 -d . JDBC.java
     * （-cp/-classpath 引入第三方依赖）
     * ②编译时只需要引入第三方依赖，运行时需要引入所有依赖（见JDBC.ps1）
     * */
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false&characterEncoding=utf-8";
        String username = "root";
        String password = "2468";

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); /* 需要引入MySQL Lib */
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getObject("id"));
                System.out.println("name:" + resultSet.getObject("name"));
                System.out.println("pwd:" + resultSet.getObject("password"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
