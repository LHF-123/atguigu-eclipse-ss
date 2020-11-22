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

public class NewsAppQueryServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String chnl_code = req.getParameter("chnl_code")==null?"0":req.getParameter("chnl_code");
		
		ChannelDao chnlDao = new ChannelDao();
		List<Channel> channelList = chnlDao.queryChannel();
		req.setAttribute("channelList", channelList);
		
		NewsDao dao = new NewsDao();
		List<News> newsList = dao.queryNewsByChannel(Integer.parseInt(chnl_code));
		req.setAttribute("newsList", newsList);
		
		req.setAttribute("chnl_code", Integer.parseInt(chnl_code));
		
		req.getRequestDispatcher("ft/main.jsp").forward(req, resp);
	}
	
	
}
