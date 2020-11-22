package com.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.ChannelDao;
import com.news.pojo.Channel;

public class NewsShowInsertServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		ChannelDao chnlDao = new ChannelDao();
		List<Channel> list = chnlDao.queryChannel();
		req.setAttribute("channelList", list);
		
		req.getRequestDispatcher("sys/NewsInsert.jsp").forward(req, resp);
	}
	
	
}
