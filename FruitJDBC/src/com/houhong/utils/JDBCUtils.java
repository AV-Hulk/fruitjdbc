package com.houhong.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author AV_Hulk
 * @create 2022-03-09 16:17
 **/
public class JDBCUtils {

    //1、把数据库连接池声明为Utils下的静态内部属性
    private static DataSource source;
    //2、让类在加载时自动执行静态代码块赋值静态属性；这样才能是Druid数据库连接池的唯一性，而不是每获取一个连接就造一个池
    static{		//注意这里要声明是静态代码块
        try {
            Properties ps = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
//			FileInputStream is = new FileInputStream(new File("src/druid.properties"));

            ps.load(is);
            source = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3、通过工具类的静态方法，获取Druid数据库连接池free状态下的Connection连接
    public static Connection getConnectionByDruid() throws Exception{

        Connection conn = source.getConnection();
        if(conn != null)
            System.out.println("通过Druid获取conn的sql连接");
        return conn;

    }


    public static void closeResourceByDbutils(Connection conn, Statement ps, ResultSet resultSet) {
        //方式一：通过DbUtils工具类的close方法关闭，但此方式会抛异常
//		try {
//			DbUtils.close(conn);
//			DbUtils.close(ps);
//			DbUtils.close(resultSet);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        //方式二：通过DbUtils工具类的closeQuietly方法（悄悄）关闭，方式不会抛异常
        DbUtils.closeQuietly(conn, ps, resultSet);
    }

}
