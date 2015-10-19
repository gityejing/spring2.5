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
		// ʹ�ö���
		User user = new User(1L,"hello");
		new TestApp().getUserService().saveUser(user);
	}
	
	@Test
	public void test() throws Exception {
		// ��Spring�������л�ȡ����
		UserService userService = (UserService) ac.getBean("userService");
		// ʹ�ö���
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
