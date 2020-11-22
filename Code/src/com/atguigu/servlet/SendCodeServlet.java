package com.atguigu.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.utils.CodeConfig;

import redis.clients.jedis.Jedis;

/**
 * 发送验证码的Servlet
 */
@WebServlet("/SendCodeServlet")
public class SendCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户输入的手机号
		String phoneNo = request.getParameter("phone_no");
		//判断手机号是否为null
		if (phoneNo == null) {
			return;
		}
		//创建Jedis对象
		Jedis jedis = new Jedis(CodeConfig.HOST, CodeConfig.POST);
		//拼接Redis中保存计数器的key
		String countKey = CodeConfig.PHONE_PREFIX + phoneNo + CodeConfig.COUNT_SUFFIX;
		//根据计数器的key从Redis中获取发送验证码的次数
		String redisCount = jedis.get(countKey);
		//判断计数器的值
		if (redisCount == null) {
			//证明这是第一次发送验证码，此时向Redis中保存计数器的值是1，并设置有效时间为24小时
			jedis.setex(countKey, CodeConfig.SECONDS_PER_DAY, "1");
			//判断计数器的值是否是3
		}else if ("3".equals(redisCount)) {
			//单日已经发送3次，给浏览器响应一个字符串limit
			response.getWriter().write("limit");
			//关闭jedis
			jedis.close();
			return;
		}else {
			//将Redis中计数器的值加一
			jedis.incr(countKey);
		}
		//拼接向Redis中保存验证码时的key
		String codeKey = CodeConfig.PHONE_PREFIX + phoneNo + CodeConfig.PHONE_SUFFIX;
		//生成六位验证码
		String code = getCode(CodeConfig.CODE_LEN);
		//向手机号发送验证码
		System.out.println(code);
		//向Redis中保存验证码，并设置有效时间为120秒
		jedis.setex(codeKey, CodeConfig.CODE_TIMEOUT, code);
		//给浏览器响应一个字符串true
		response.getWriter().write("true");
		//关闭Jedis
		jedis.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//随机生成验证码的方法
	private String getCode(int len) {
		String code = "";
		for (int i = 0; i < len; i++) {
			int rand = new Random().nextInt(10);
			code += rand;
		}
		return code;
	}

}
