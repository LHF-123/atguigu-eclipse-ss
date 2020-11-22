package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.pojo.News;
import com.news.util.DBUtil;

public class NewsDao {

	public void insertNews(News news){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into news(TITLE,CHNL_CODE,DETAIL,OPTOR,CRTIME,UPTIME) values(?,?,?,?,now(),now())");
			stmt.setString(1, news.getTitle());
			stmt.setInt(2, news.getChnl_code());
			stmt.setString(3, news.getDetail());
			stmt.setString(4, news.getOptor());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public void updateNews(News news){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update news set TITLE=?,CHNL_CODE=?,DETAIL=?,UPTIME=now() where ID=?");
			stmt.setString(1, news.getTitle());
			stmt.setInt(2, news.getChnl_code());
			stmt.setString(3, news.getDetail());
			stmt.setInt(4, news.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public void deleteNews(int id){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from news where ID=?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public List<News> queryNews(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		try {
			String sql = "select n.ID,TITLE,CHNL_CODE,NAME CHNL_NAME,DETAIL,OPTOR,n.CRTIME,n.UPTIME "
					+ "from news n,news_chnl c where n.CHNL_CODE=c.ID";
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setChnl_code(rs.getInt(3));
				news.setChnl_name(rs.getString(4));
				news.setDetail(rs.getString(5));
				news.setOptor(rs.getString(6));
				news.setCrtime(rs.getTimestamp(7));
				news.setUptime(rs.getTimestamp(8));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return list;
	}
	
	public News getNews(int id){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select n.ID,TITLE,CHNL_CODE,NAME CHNL_NAME,DETAIL,OPTOR,n.CRTIME,n.UPTIME "
					+ "from news n,news_chnl c where n.CHNL_CODE=c.ID and n.ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			if(rs.next()){
				News news = new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setChnl_code(rs.getInt(3));
				news.setChnl_name(rs.getString(4));
				news.setDetail(rs.getString(5));
				news.setOptor(rs.getString(6));
				news.setCrtime(rs.getTimestamp(7));
				news.setUptime(rs.getTimestamp(8));
				return news;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return null;
	}
	
	public List<News> queryNewsByChannel(int chnl_code){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		try {
			String sql = "select ID,TITLE,CHNL_CODE,MAIN_IMG,DETAIL,OPTOR,CRTIME,UPTIME from news where CHNL_CODE=?";
			if(chnl_code==0){
				sql = "select ID,TITLE,CHNL_CODE,MAIN_IMG,DETAIL,OPTOR,CRTIME,UPTIME from news where CHNL_CODE=(select min(ID) from news_chnl)";
			}
			stmt = conn.prepareStatement(sql);
			if(chnl_code!=0)
				stmt.setInt(1, chnl_code);
			
			rs = stmt.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setChnl_code(rs.getInt(3));
				news.setMain_img(rs.getString(4));
				news.setDetail(rs.getString(5));
				news.setOptor(rs.getString(6));
				news.setCrtime(rs.getTimestamp(7));
				news.setUptime(rs.getTimestamp(8));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return list;
	}
}
