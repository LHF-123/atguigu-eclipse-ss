package com.atguigu.springmvc.helloworld;

import java.util.Map;

import javax.print.attribute.standard.MediaSize.NA;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.entities.Employee;

/*
 * 在类上添加了@ResponseBody注解之后，Handler的方法的返回值将直接响应给浏览器，
 * 但是前提是在SpringMVC的配置文件中配置了<mvc:annotation-driven/>标签
 */
//@ResponseBody
@Controller
public class SpringMVCHandler {
	
	/*
	 * 	@RequestMapping注解中的属性：
	 * 	1.value：用来设置要映射的请求地址，值的类型是String类型的数组
	 * 		如果只映射一个请求地址，那么value的值不需要添加大括号{ }，value属性名可以省略不写
	 * 	2.method：用来设置要映射的请求方式
	 * 		如果没有设置该属性，那么只看映射的请求地址，不管请求方式
	 */
	@RequestMapping({"/testValue", "/testValue2"})
	public String testValue() {
		System.out.println("测试@RequestMapping注解的value属性");
		return "success";
	}
	
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("测试@RequestMapping注解的method属性");
		return "success";
	}
	
	/*
	 * @RequestParam注解
	 * -用来映射请求参数
	 * 		如果Handler的方法的入参中的参数名与请求参数的参数名一致，那么该注解可以省略不写（不建议）
	 * -该注解的属性：
	 * 	1.value：设置请求参数的参数名
	 * 	2.required
	 * 		设置该请求参数是否是必须的，默认是true
	 * 	3.defaultValue
	 * 		设置请求参数的默认值，如果没有传入该请求参数将使用该值
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username") String user,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("用户名是：" + user);
		System.out.println("年龄是：" + age);
		return "success";
	}
	
	/*
	 * SpringMVC会按照请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值。支持级联属性
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(Employee employee) {
		System.out.println("员工信息是：" + employee);
		return "success";
	}
	
	/*
	 * SpringMVC的Handler方法可以接受哪些ServletAPI类型的参数
	 * ★1.HttpServletRequest
	 * ★2.HttpServletResponse
	 * ★3.HttpSession
	 * 4.java.security.Principal
	 * 5.Locale
	 * 6.InputStream
	 * 7.OutputStream
	 * 8.Reader
	 * 9.Write
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
		//获取请求参数
		String username = request.getParameter("username");
		System.out.println(username);
		return "success";
	}
	
	/*
	 * 处理响应的数据方式一：将Handler的方法的返回值设置为ModelAndView
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		//1.创建ModelAndView对象
		ModelAndView mv = new ModelAndView();
		//假设从数据库中查询出了一个Employee对象
		Employee employee = new Employee(1, "张三丰", "zsf@atguigu.com", null);
		//2.将模型数据设置到ModelAndView对象中
		mv.addObject("emp", employee);
		//3.设置视图名
		mv.setViewName("success");
		//返回ModelAndView对象
		return mv;
	}
	
	/*
	 * ★处理相应数据的方式二：在Handler的方法的入参中传入Map、Model、ModelMap
	 * 		不管将Handler的方法的返回值设置为ModelAndView还是在Handler的方法入参中传入Map、Model、ModelMap
	 * 		SpringMVC都会转换为一个ModelAndView对象
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		//假设从数据库中查询出来了一个Employee对象
		Employee employee = new Employee(2, "张无忌", "zwj@zzr.com", null);
		//将employee对象放到map中，最后会放到request域中
		map.put("emp", employee);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/testResponseBody")
	public String testResponseBody() {
		System.out.println("测试@ResponseBody注解");
		return "success";
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("测试重定向");
		return "redirect:/redirect.jsp";
	}
}
