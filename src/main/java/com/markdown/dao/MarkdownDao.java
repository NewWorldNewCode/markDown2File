package com.markdown.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.markdown.entity.*;

/**
 * dao层的UsersDao类，用来实现增删改查的SQL语句
 * @author YuChen
 *
 */
public class MarkdownDao {
    BaseDao db = new BaseDao();//初始化工具类
    String sql = "select * from MARK";//封装sql语句，这边的‘Users’要和数据库中的表 同名

    /**
     * 查询方法
     * @return Lisr<Users> 一个list（相当于一个大数组）
     * @return
     */
    public List<Markdown> findUsers() {
        List<Markdown> users = new ArrayList<Markdown>();//初始化list
        //1、连接到数据库
        Connection connection = db.getConnection();
        
        try {
            //2、执行SQL查询
            PreparedStatement pst = connection.prepareStatement(sql);
            //3、把查询结果放到结果集
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	Markdown user = new Markdown(rs.getString(1), rs.getString(2));
                users.add(user);
            }//循环将结果保存到list中。 使用rs.get***()获取到结果集里面的相应类型的每一列的值，然后通过构造方法赋值给user，进而通过add()保存到list
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4、断开数据库连接
            db.closeConnection(connection);//放到finally中，无论是否抛出异常，最后都会执行该语句
        }
        return users;
    }
}
