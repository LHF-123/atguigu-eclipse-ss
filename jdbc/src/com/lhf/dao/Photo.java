package com.lhf.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Photo {

	public static void main(String[] args) throws Exception {
		 //1、读取照片
        FileInputStream fis = new FileInputStream("E:/photo/素材/1.jpg");

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //4、编写sql
        String sql = "UPDATE t_user SET photo = ? WHERE username = 'liu';";

        //5、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);
        
        //6、设置？的值
        pst.setObject(1, fis);

        //7、执行sql
        int len = pst.executeUpdate();
        System.out.println(len>0?"添加成功":"添加失败");

        //8、关闭
        pst.close();
        conn.close();

	}

}
