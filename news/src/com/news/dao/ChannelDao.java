package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.pojo.Channel;
import com.news.util.DBUtil;

public class ChannelDao {

	public void insertChannel(Channel chnl){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into news_chnl(NAME,SORT,CRTIME,UPTIME) values(?,?,now(),now())");
			stmt.setString(1, chnl.getName());
			stmt.setInt(2, chnl.getSort());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public void updateChannel(Channel chnl){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update news_chnl set NAME=?,SORT=?,UPTIME=now() where ID=?");
			stmt.setString(1, chnl.getName());
			stmt.setInt(2, chnl.getSort());
			stmt.setInt(3, chnl.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public void deleteChannel(int id){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from news_chnl where ID=?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public List<Channel> queryChannel(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Channel> list = new ArrayList<Channel>();
		try {
			stmt = conn.prepareStatement("select ID,NAME,SORT,CRTIME,UPTIME from news_chnl order by ID");
			
			rs = stmt.executeQuery();
			while(rs.next()){
				Channel chnl = new Channel();
				chnl.setId(rs.getInt(1));
				chnl.setName(rs.getString(2));
				chnl.setSort(rs.getInt(3));
				chnl.setCrtime(rs.getTimestamp(4));
				chnl.setUptime(rs.getTimestamp(5));
				list.add(chnl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return list;
	}
	
	public Channel getChannel(int id){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select ID,NAME,SORT,CRTIME,UPTIME from sys_chnl where ID=?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			if(rs.next()){
				Channel chnl = new Channel();
				chnl.setId(rs.getInt(1));
				chnl.setName(rs.getString(2));
				chnl.setSort(rs.getInt(3));
				chnl.setCrtime(rs.getTimestamp(4));
				chnl.setUptime(rs.getTimestamp(5));
				return chnl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return null;
	}
}
