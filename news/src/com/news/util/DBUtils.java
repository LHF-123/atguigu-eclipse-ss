package com.news.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*
 * JDBC工具类,通过该类,我们可以实现对各种表数据的增删改查操作
 * 	操作数据表,无非就两种情况
 * 		查询数据		executeQuery()
 * 		增删改数据	executeUpdate()
 * 	也就是说工具类里面可以定义两套方法,来实现数据的增删改查
 * 
 * 	对于工具类,维护性越好越重要
 */
public class DBUtils {
	//把要修改的字段值都给提到上面来,方便后续修改
	//既然我们可以提取到类的顶部,方便后续修改,那么我们能不能想到其他的策略,对于配置内容,我们就不让修改源码
	//我们可以使用XML,但是XML需要我们进行解析,稍微有点麻烦;
	/*	private static final String driver = "com.mysql.jdbc.Driver";
		private static final String url = "jdbc:mysql://localhost:3307/test_db?useUnicode=true&characterEncoding=utf8";
		private static final String userName = "root";
		private static final String password = "root";*/
	//采用properties配置文件来配置驱动、url、userName、password
	//我们的配置文件一般放在src目录下面
	private static Properties props;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	//1、加载驱动,仅仅执行一次即可
	static {
		//读取db.properties文件
		props = new Properties();
		//getContextClassLoader() 返回该线程的上下文 ClassLoader。
		//InputStream getResourceAsStream(String name) 返回读取指定资源的输入流。 
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("读取配置文件失败!");
		}
		try {
			Class.forName(props.getProperty("mysqlDriver")); //从db.properties文件中读取属性mysqlDriver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败,请检查驱动包!");
		}
	}
	
	//2、定义获取连接的方法
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(props.getProperty("mysqlURL"),props.getProperty("mysqlUserName"),props.getProperty("mysqlPassword"));
		} catch (SQLException e) {
			System.out.println("获取连接失败,请检查URL、用户名和密码!");
		}
	}
	
	//3、定义关闭资源的方法
	public void close() {
		//释放资源：如果我们在中途的某个过程里面报错了,那么后续的资源就没有创建出来
		//如果是Null来调用close,那么会报空指针异常
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * DBUtils的查询方法
	 * 	query()	只要是进行的查询,全部通过该方法来实现
	 *  我们是针对于各种表的查询,那么sql语句肯定是不固定的,既然sql不固定,那么sql所用的参数都是不固定的
	 *  	那么我们可以把sql和sql所需参数作为query()的参数传递进来
	 *  参数: String sql,Object obj[]
	 *  	那么我们传递sql的时候,肯定知道所用参数是什么,那么我们定义数组或集合来存储参数
	 *  	因为sql所需的参数可能是任意一种类型
	 *  返回值: 
	 *  	把ResultSet 转换为List<Map<String,String>>
	 *  	
	 */
	public List<Map<String, String>> query(String sql,Object obj[])  {
		//用来存储从ResultSet里面转换出来的数据
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		getConnection(); //调用获取连接的方法
		
		try {
			ps = conn.prepareStatement(sql);
			
			//把数组里面的参数给对应的占位符设置进来
			for(int i = 0;i < obj.length;i++) {
				ps.setObject(i+1, obj[i]); //第一个参数是占位符,占位符顺序从1开始
			}
		
			//处理结果集,把结果集的每一行用Map来存储,然后把每一个Map存储到List里面
			rs = ps.executeQuery(); 
			//ResultSetMetaData getMetaData() 获取此 ResultSet 对象的列的编号、类型和属性。 
			ResultSetMetaData rsmd = rs.getMetaData(); 
			/*
			 * ResultSetMetaData相关方法:
			 * 	getColumnCount() 返回此 ResultSet 对象中的列数。 这个很重要,因为我们查询不同的表,得到的列数肯定是不一致的,那么像Map里面存储的次数也不一样
			 * 	String getColumnName(int column)  获取指定列的名称。 
			 */
			//遍历ResultSet,每次遍历都要创建一个Map,因为一个Map代表一行数据
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				//查询到多少列,那么就需要向map存储多少对数据
				for(int j = 1;j <= columnCount;j++) { 
					//key就是列名,value就是每一行列对应的值
					map.put(rsmd.getColumnName(j), rs.getString(j));
				}
				//把map存储到List里面
				list.add(map);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(); //无论是否有异常,我们都执行释放资源行为
		}
		
		return list;
	}
	
	/*
	 * DBUtils的更新方法
	 * 	update(),所有的增删改操作都是基于这个方法来实现
	 * 	
	 * 执行增删改操作,也不要在里面自己进行判定了,因为我们不确定到底是增加、删除、修改
	 * 所以我们把反馈值给调用者,他们自己去判断
	 */
	
	public int update(String sql,Object obj[]) {
		int j = 0;	
		getConnection();
	
		try {
			ps = conn.prepareStatement(sql);
			//把数组里面的参数给对应的占位符设置进来
			for(int i = 0;i < obj.length;i++) {
				ps.setObject(i+1, obj[i]); //第一个参数是占位符,占位符顺序从1开始
			}
			//执行增删改操作
			j = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return j;
	}
}
