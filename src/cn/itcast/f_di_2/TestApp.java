package cn.itcast.f_di_2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml", getClass());

	@Test
	public void test() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		System.out.println(userDao);
	}

	@Test
	public void test2() throws Exception {
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println(userService);
		System.out.println(userService.getUserDao());
	}

	@Test
	public void test3() throws Exception {
		UserService userService = new UserService();
		System.out.println(userService);
		System.out.println(userService.getUserDao());
	}
}
