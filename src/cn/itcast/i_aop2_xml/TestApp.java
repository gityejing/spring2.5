package cn.itcast.i_aop2_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());

	@Test
	public void test() throws Exception {
		// 从Spring的容器中获取对象
		UserService userService = (UserService) ac.getBean("userService");

		// 使用对象
		userService.saveUser();
		userService.deleteUser();
		userService.queryUsers();
	}

}
