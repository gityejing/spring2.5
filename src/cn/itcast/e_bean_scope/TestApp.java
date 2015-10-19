package cn.itcast.e_bean_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml", getClass());

	@Test
	public void test2() throws Exception {
		System.out.println("---");

		UserDao userDao1 = (UserDao) applicationContext.getBean("userDao1");
		UserDao userDao2 = (UserDao) applicationContext.getBean("userDao1");
		System.out.println(userDao1 == userDao2);
		
		// 调用close()方法关闭容器对象
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
