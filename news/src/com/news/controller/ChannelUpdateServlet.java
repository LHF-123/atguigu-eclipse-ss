package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.ChannelDao;
import com.news.pojo.Channel;

public class ChannelUpdateServlet extends HttpServlet{

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
		String name = req.getParameter("name");
		String sort = req.getParameter("sort");
		
		Channel chnl = new Channel();
		chnl.setId(Integer.parseInt(id));
		chnl.setName(name);
		chnl.setSort(Integer.parseInt(sort));
		
		ChannelDao dao = new ChannelDao();
		dao.updateChannel(chnl);
		
		resp.sendRedirect("queryChannel");
	}
	
	
}
