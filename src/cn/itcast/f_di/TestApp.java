package cn.itcast.f_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml", getClass());

	@Test
	public void test() throws Exception {
		// UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// userDao.printInfo();

		UserDao userDao2 = (UserDao) applicationContext.getBean("userDao2");
		userDao2.printInfo();
	}

	@Test
	public void testUserBean() throws Exception {
		User user = (User) applicationContext.getBean("user");
		user.printInfo();

		// UserDao myUserDao = (UserDao) applicationContext.getBean("myUserDao");
		// myUserDao.printInfo();
	}
}
