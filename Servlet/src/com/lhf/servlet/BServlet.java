package com.lhf.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		application.setAttribute("name", "刘");
		System.out.println("BServlet:" + application);
		
		String path = application.getRealPath("note.txt");
		System.out.println(path);
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("note.txt");
//		传统JDK方式
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		String content = new String(bytes);
		System.out.println(content);
		
//		使用第三方jar包
//		String string = IOUtils.toString(inputStream);这个需要commons-io的jar包，但我没有
//		System.out.println("jar读取的内容" + string);
		//想用jar包读取内容，需要把上面的JDK读取的注释掉，不然JDK读取后格式会乱，jar包读取不成功
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
