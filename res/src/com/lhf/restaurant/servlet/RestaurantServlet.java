package com.lhf.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhf.restaurant.entity.Order;
import com.lhf.restaurant.service.RestaurantService;

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action == null) {//根据表单提交时传递的名字叫action参数判断执行哪一项功能
			queryAllOrder(request, response);
		}else if(action.equals("addOrder")) {//添加后查询所有，跳转到index.jsp
			addOrder(request, response);
			queryAllOrder(request, response);
		}else if(action.equals("delOrder")) {//删除后查询所有，跳转到index.jsp
			delOrder(request, response);
			queryAllOrder(request, response);
		}else if(action.equals("updateOrder")) {//更改后查询所有，跳转到index.jsp
			updateOrder(request, response);
			queryAllOrder(request, response);
		}else if(action.equals("queryOrder")) {//查询单个
			queryOrder(request, response);
		}else if(action.equals("queryAllOrder")) {//查询所有后跳转到index.jsp
			queryAllOrder(request, response);
		}
	}

	private void queryOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oId = Integer.parseInt(request.getParameter("oId"));
		RestaurantService rService = new RestaurantService();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("uname");
		Order order = rService.queryOrder(user, oId);
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("orderInfo.jsp").forward(request, response);
	}

	private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int oId = Integer.parseInt(request.getParameter("oId"));
		int count = Integer.parseInt(request.getParameter("count"));
		String address = request.getParameter("address");
		Order order = new Order(count, address);
		RestaurantService rService = new RestaurantService();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("uname");
		boolean result = rService.updateOrder(user, oId, order);
		PrintWriter out = response.getWriter(); 
		if(result == true) {
			out.print("修改成功！");
		}else {
			out.print("修改失败！");
		}
	}

	private void delOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int oId = Integer.parseInt(request.getParameter("oId"));
		RestaurantService rService = new RestaurantService();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("uname");
		boolean result = rService.delOrder(user, oId);
		PrintWriter out = response.getWriter(); 
		if(result == true) {
			out.print("删除成功！");
		}else {
			out.print("删除失败！");
		}
	}

	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean fid1 = request.getParameter("fid1") != null;
		boolean fid2 = request.getParameter("fid2") != null;
		boolean fid3 = request.getParameter("fid3") != null;
		boolean fid4 = request.getParameter("fid4") != null;
		boolean fid5 = request.getParameter("fid5") != null;
		boolean fid6 = request.getParameter("fid6") != null;
		boolean fid7 = request.getParameter("fid7") != null;
		boolean fid8 = request.getParameter("fid8") != null;
		boolean fid9 = request.getParameter("fid9") != null;
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("uname");
		if(fid1 == true) {
			String menu = request.getParameter("menu1");
			int count = Integer.parseInt(request.getParameter("count1"));
			String address = request.getParameter("address1");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid2 == true) {
			String menu = request.getParameter("menu2");
			int count = Integer.parseInt(request.getParameter("count2"));
			String address = request.getParameter("address2");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid3 == true) {
			String menu = request.getParameter("menu3");
			int count = Integer.parseInt(request.getParameter("count3"));
			String address = request.getParameter("address3");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid4 == true) {
			String menu = request.getParameter("menu4");
			int count = Integer.parseInt(request.getParameter("count4"));
			String address = request.getParameter("address4");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid5 == true) {
			String menu = request.getParameter("menu5");
			int count = Integer.parseInt(request.getParameter("count5"));
			String address = request.getParameter("address5");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid6 == true) {
			String menu = request.getParameter("menu6");
			int count = Integer.parseInt(request.getParameter("count6"));
			String address = request.getParameter("address6");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid7 == true) {
			String menu = request.getParameter("menu7");
			int count = Integer.parseInt(request.getParameter("count7"));
			String address = request.getParameter("address7");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid8 == true) {
			String menu = request.getParameter("menu8");
			int count = Integer.parseInt(request.getParameter("count8"));
			String address = request.getParameter("address8");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
		if(fid9 == true) {
			String menu = request.getParameter("menu9");
			int count = Integer.parseInt(request.getParameter("count9"));
			String address = request.getParameter("address9");
			Order order = new Order(menu, count, address );
			RestaurantService rService = new RestaurantService();
			boolean result = rService.addOrder(user, order);
			PrintWriter out = response.getWriter(); 
			if(result == true) {
				out.print("添加成功！");
			}else {
				out.print("添加失败！");
			}
		}
	}

	private void queryAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestaurantService rService = new RestaurantService();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("uname");
		List<Order> orders = rService.queryAllOrders(user);
		request.setAttribute("orders", orders);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
