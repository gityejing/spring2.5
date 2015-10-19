package cn.itcast.g_perperties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	static {
		// System.getProperties().list(System.out);
		System.setProperty("jdbcUrl", "aaa");
		System.setProperty("driverClass", "bbb");
		System.setProperty("username", "ccc");
		System.setProperty("passwd", "ddd");
	}

	private ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml", getClass());

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
