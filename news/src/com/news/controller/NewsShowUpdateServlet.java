package com.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.ChannelDao;
import com.news.dao.NewsDao;
import com.news.pojo.Channel;
import com.news.pojo.News;

public class NewsShowUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("id");
		
		ChannelDao chnlDao = new ChannelDao();
		List<Channel> list = chnlDao.queryChannel();
		req.setAttribute("channelList", list);
		
		NewsDao dao = new NewsDao();
		News news = dao.getNews(Integer.parseInt(id));
		req.setAttribute("news", news);
		
		req.getRequestDispatcher("sys/NewsUpdate.jsp").forward(req, resp);
	}
	
	
}
