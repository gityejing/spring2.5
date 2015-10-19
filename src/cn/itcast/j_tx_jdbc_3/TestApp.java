package cn.itcast.j_tx_jdbc_3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());
	private UserService userService = (UserService) ac.getBean("userService");

	@Test
	public void testSave() throws Exception {
		System.out.println(ac.getBean("logDao").getClass());

		System.out.println(userService.getClass());
		userService.saveTwoUsers();
	}

}
