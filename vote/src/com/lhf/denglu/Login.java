package com.lhf.denglu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lhf.util.DBUtil;

public class Login {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pStatement;
	
	public int query(String uname,String upwd) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "SELECT * FROM user WHERE uname= ? and upwd = ? ";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, uname);//1代表带一个问号，把uname赋给第一个?
			pStatement.setString(2, upwd);//2代表带二个问号，把upwd赋给第一个?
			rs = pStatement.executeQuery();
			int count = 0;//假设没有找到
			while(rs.next()) {//正常情况下用户名和密码是唯一的
				count = rs.getInt(1);
				}
			return count;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return -1;
	}
	 public ArrayList<Vote> getAllVotes() throws Exception{
         ArrayList<Vote> al = new ArrayList<Vote>();
         String sql = "select * from vote";
         Statement stat = conn.createStatement();
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next())
         {
             Vote vote = new Vote();
             vote.setdwname(rs.getString("dwname"));
             vote.setdwid(rs.getString("dwid"));
             vote.setdvote(rs.getInt("dvote"));
             al.add(vote);
         }
        return al;
        
     }
    public void updateVotes(String [] dwid) throws Exception{
        String sql = "update vote set dvote = dvote+1 where dwid = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
           for(int i = 0;i < dwid.length; i++){
               ps.setString(1, dwid[i]);
               ps.executeUpdate();
           }
				
    }
    public void close() {
    	DBUtil.closeConnection(conn, pStatement, rs);
	}
}
