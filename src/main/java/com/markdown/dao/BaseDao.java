package com.markdown.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * BaseDao工具类
 * @author YuChen
 *
 */
public class BaseDao {
    //1、执行静态方法,加载数据库驱动
    static {
        try {
            System.out.println("正在加载数据库驱动...");
            System.out.println("Class.forName('oracle.jdbc.driver.OracleDriver');");

            Class.forName("oracle.jdbc.driver.OracleDriver");//这边参数的意义，url:jdbc数据库网址 user:用户名（String类型） password:密码（String类型）[这边的数据库密码和用户名填写自己的]。同样由于getConnection方法会抛出SQLException，要使用try-catch

            System.out.println("已加载数据库驱动！！！\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //2、创建数据库连接的方法
    public Connection getConnection() {
        Connection connection;
        try {
            System.out.println("正在连接到数据库...");
            System.out.println("connection = DriverManager.getConnection('jdbc:oracle:thin:@127.0.0.1:1521:orcl', 'c##diting', 'diting123');");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "c##diting", "diting123");///这边参数的意义，url:jdbc数据库网址 user:用户名 password:密码。同样由于getConnection方法会抛出SQLException，要使用try-catch

            System.out.println("已连接到scott数据库！！！\n");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //3、关闭数据库连接，释放JDBC资源的方法
    public void closeConnection(Connection connection) {
        if (connection != null) {
            System.out.println("准备释放jdbc资源，断开数据库连接...");
			System.out.println("connection.close();");
			try {
				 connection.close();//立即释放jdbc资源，而不是等自动释放
			} catch (SQLException e) { /* ignored */}
            

			System.out.println("已断开数据库连接并且释放了jdbc资源\n");
        }

    }
}

