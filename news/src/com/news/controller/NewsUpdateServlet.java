package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.NewsDao;
import com.news.pojo.News;

public class NewsUpdateServlet extends HttpServlet{

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
		String title = req.getParameter("title");
		String chnl_code = req.getParameter("chnl_code");
		String detail = req.getParameter("detail");
		
		News news = new News();
		news.setId(Integer.parseInt(id));
		news.setTitle(title);
		news.setChnl_code(Integer.parseInt(chnl_code));
		news.setDetail(detail);
		
		NewsDao dao = new NewsDao();
		dao.updateNews(news);
		
		resp.sendRedirect("queryNews");
	}
	
	
}
