package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener的生命周期监听器
 *
 */
public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("MyServletContextListener对象被销毁了");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	 System.out.println("MyServletContextListener对象被初始化了");
    }
	
}
