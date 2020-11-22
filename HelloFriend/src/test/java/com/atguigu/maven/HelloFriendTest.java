package com.atguigu.maven;	
	import static junit.framework.Assert.assertEquals;
	import org.junit.Test;
	
	public class HelloFriendTest {
		@Test
		public void testHelloFriend(){
			HelloFriend helloFriend = new HelloFriend();
			String results = helloFriend.sayHelloToFriend("张三");
			assertEquals("Hello 张三! I am John",results);	
		}
	}
