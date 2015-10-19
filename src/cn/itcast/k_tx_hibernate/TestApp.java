package cn.itcast.k_tx_hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());
	private UserService userService = (UserService) ac.getBean("userService");

	@Test
	public void testSave() throws Exception {
		System.out.println(userService.getClass());
		userService.saveTwoUsers();
	}

}
