package com.houhong.com.houhong.test;

import com.houhong.bean.Fruit;
import com.houhong.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author AV_Hulk
 * @create 2022-03-09 16:33
 **/
public class Test1 {

    public int i ;




    @Test
    public void testUpdate() throws Exception {
        Connection conn = JDBCUtils.getConnectionByDruid();

        String sql = "insert into fruits(name, price, number, subtotal) values(?,?,?,?)";

        QueryRunner runner = new QueryRunner();

        int count = runner.update(conn,sql,"火龙果",3.2,20,3.2*20);

        System.out.println("hello git!");
        System.out.println("hello git3");
        System.out.println("master git4");
        System.out.println("master test");
        System.out.println("hot-fix test");


        if (count > 0) {

            System.out.println("成功修改了：" + count + "记录；");
        }else{
            System.out.println("修改失败！");


        }

    }

    @Test
    public void testQueryOne() throws Exception {
        Connection conn = JDBCUtils.getConnectionByDruid();

        String sql = "select id, name, price, number, subtotal from fruits where id = ?";

        QueryRunner runner = new QueryRunner();

        BeanHandler<Fruit> rsh = new BeanHandler<>(Fruit.class);

        Fruit fruit = runner.query(conn,sql,rsh , 3);

        if (fruit != null) {

            System.out.println(fruit);
        }else{
            System.out.println("查询失败！");
        }
    }

    @Test
    public void testQueryMore() throws Exception {
        Connection conn = JDBCUtils.getConnectionByDruid();
        String sql = "select id, name, price, number, subtotal from fruits where id <= ?";

        QueryRunner runner = new QueryRunner();

        BeanListHandler<Fruit> rsh = new BeanListHandler<>(Fruit.class);

        List<Fruit> list = runner.query(conn,sql,rsh , 3);


        if (list != null) {

            list.forEach(System.out::println);

        }else{
            System.out.println("查询失败！");
        }
    }

    @Test
    public void getValue() throws Exception {
        Connection conn = JDBCUtils.getConnectionByDruid();
        String sql = "select count(*) from fruits";

        QueryRunner runner = new QueryRunner();

        ScalarHandler rsh = new ScalarHandler();

        long count = (long) runner.query(conn, sql, rsh);

        if (count > 0) {

            System.out.println("查询水果品数：" + count + "；");

        }else{
            System.out.println("没有水果");
        }

    }




}
