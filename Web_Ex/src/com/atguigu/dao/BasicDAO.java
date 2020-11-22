package com.atguigu.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.atguigu.utils.JDBCUtils;

public class BasicDAO {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
	
	
	//查询一个JavaBean，一般跟着主键，唯一键
    public <T> T getById(Class<T> clazz, String sql, Object... param) throws Exception{
        return qr.query(sql, new BeanHandler<T>(clazz), param);
    }
    
    //查询多个Javaean
    public <T> List<T> getAll(Connection conn, Class<T> clazz, String sql, Object... param) throws Exception{
        return qr.query(sql, new BeanListHandler<T>(clazz), param);
    }
}
