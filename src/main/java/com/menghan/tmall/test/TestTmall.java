package com.menghan.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 刚开始用的时候，数据库里是没有数据的。 这里使用 简单的 jdbc 代码插入10条数据。
 */
public class TestTmall {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection c = DriverManager
                    .getConnection("jdbc:mysql://47.111.169.133:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8", "root", "123456");
            Statement s = c.createStatement();
            for (int i=1;i<=10;i++){
                String sqlFormat = "insert into category values(null,'测试分类%d')";
                String sql = String.format(sqlFormat,i);
                s.execute(sql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
