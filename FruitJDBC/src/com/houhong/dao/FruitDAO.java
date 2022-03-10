package com.houhong.dao;

import com.houhong.bean.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @author AV_Hulk
 * @create 2022-03-10 11:42
 **/
public interface FruitDAO {

    /**
     * 添加水果明细
     * @param conn
     * @param fruit
     */
    int insert(Connection conn, Fruit fruit);

    /**
     * 通过ID删除水果
     * @param conn
     * @param id
     * @return
     */
    int deleteByID(Connection conn, int id);

    /**
     * 更新水果信息
     * @param conn
     * @param fruit
     */
    void update(Connection conn, Fruit fruit);

    /**
     * 通过ID查询一个水果
     * @param conn
     * @param id
     * @return
     */
    Fruit selectByID(Connection conn, int id);

    /**
     * 查询所有水果信息
     * @param conn
     * @return
     */
    List<Fruit> selectAll(Connection conn);

    /**
     * 获取水果数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

}
