package cn.itcast.l_basedao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	@Test
	public void testSave() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());
		UserService userService = (UserService) ac.getBean("userService");
		System.out.println(userService.getClass());
		userService.saveTwoUsers();
	}

}
