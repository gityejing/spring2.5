package cn.itcast.d_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateBeanTest {

	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml", getClass());

	@Test
	public void test() throws Exception {
		UserDao userDao1 = (UserDao) applicationContext.getBean("userDao1");
		System.out.println(userDao1);

		UserDao userDao2 = (UserDao) applicationContext.getBean("userDao2");
		System.out.println(userDao2);

		UserDao userDao3 = (UserDao) applicationContext.getBean("userDao3");
		System.out.println(userDao3);

		UserDao userDao123 = (UserDao) applicationContext.getBean("123");
		System.out.println(userDao123);
	}

	@Test
	public void test2() throws Exception {
		UserDao userDao1 = (UserDao) applicationContext.getBean("userDao1");
		UserDao userDao2 = (UserDao) applicationContext.getBean("userDao1");
		System.out.println(userDao1 == userDao2);
	}
}
