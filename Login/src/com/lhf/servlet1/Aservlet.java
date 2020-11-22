package com.lhf.servlet1;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Aservlet")
public class Aservlet implements Servlet {

    public Aservlet() {
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init被调用，创建了Servlet");
	}

	public void destroy() {
		System.out.println("destroy被调用，销毁了Servlet");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet正在提供服务......");
	}

}
