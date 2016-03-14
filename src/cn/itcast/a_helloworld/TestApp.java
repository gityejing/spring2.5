package cn.itcast.a_helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	
	private ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml",getClass());
	
	@Test
	public void test1() throws Exception {
		UserDao userDao = (UserDao) factory.getBean("userDao");
		UserDao userDao2 = (UserDao) factory.getBean("userDao");
		userDao.save(new Object());
		
		System.out.println(userDao == userDao2);
	}
	
	// Ä£ÄâAction
	@Test
	public void test() throws Exception {
		UserService userService = (UserService) factory.getBean("userService"); // ?
		userService.register(new Object());
	}
}
