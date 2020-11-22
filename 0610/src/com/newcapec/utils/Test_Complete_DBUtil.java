package com.newcapec.utils;

import java.util.List;
import java.util.Map;

/*
 * 测试完整版的DBUtils
 */
public class Test_Complete_DBUtil {
	public static void main(String[] args) {
		//完整版的DBUtils用法超级简单
		DBUtils db = new DBUtils();
		//不带参数的查询
		/*String sql = "select * from emp";
		Object obj[] = {}; //如果不需要参数,传递空数组即可
		List<Map<String, String>> list = db.query(sql, obj);
		for(Map<String, String> map:list) {
			System.out.println(map);
		}*/
		
		//带参数的查询
		/*String sql = "select * from emp where deptno = ? and sal > ?";
		Object obj[] = {10,3500.0};
		List<Map<String, String>> list = db.query(sql, obj);
		for(Map<String, String> map:list) {
			System.out.println(map);
		}*/
		
		//新增
		/*String sql = "insert into emp(empno,ename) values (?,?)";
		Object obj[] = {1111,"小黑黑"};
		int i = db.update(sql, obj);
		System.out.println(i);*/
		
		//删除
		String sql = "delete from emp where empno = ?";
		Object obj[] = {1111};
		int i = db.update(sql, obj);
		System.out.println(i);
	}
}
