package com.houhong.connection;

import com.houhong.utils.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author AV_Hulk
 * @create 2022-03-08 23:02
 **/
public class ConnectionTest {
    public void getConnection1() {
        try {
            // 1.获取Driver实现类对象
            Driver driver = new com.mysql.cj.jdbc.Driver();

            // url:http://localhost:8080/gmall/keyboard.jpg
            // jdbc:mysql:协议
            // localhost:ip地址
            // 3306：默认mysql的端口号
            // test:test数据库
            String url = "jdbc:mysql://localhost:3306/hhong";
            // 2.将用户名和密码封装在Properties中
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "lxw880113");

            //3.Driver实现类对象方法获取Connection的连接
            Connection conn = driver.connect(url, info);

            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getConnection2() throws Exception {
        //1.读取配置文件中的4个基本信息
//        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    @Test
    public void getConnectionByDruid() throws Exception {
//        //造Properties对象用于储存外部的配置文件信息
//        Properties ps = new Properties();
//        //读取配置文件信息
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
//        //加载配置文件信息
//        ps.load(is);
//        //通过德鲁伊工厂造DataSource对象
//        DataSource source = DruidDataSourceFactory.createDataSource(ps);
//        //获取连接
//        Connection conn = source.getConnection();
//
//        System.out.println(conn);
        JDBCUtils.getConnectionByDruid();
    }



}
