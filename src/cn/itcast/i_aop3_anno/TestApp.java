package cn.itcast.i_aop3_anno;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());

	@Resource
	private UserService userService;
	
	public static void main(String[] args) {
		// 使用对象
		User user = new User(1L,"hello");
		new TestApp().getUserService().saveUser(user);
	}
	
	@Test
	public void test() throws Exception {
		// 从Spring的容器中获取对象
		UserService userService = (UserService) ac.getBean("userService");
		// 使用对象
		User user = new User(1L,"hello");
		userService.saveUser(user);
//		userService.deleteUser();
//		userService.queryUsers();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
