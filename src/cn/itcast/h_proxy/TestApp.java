package cn.itcast.h_proxy;

import org.junit.Test;

public class TestApp {

	@Test
	public void test() throws Exception {
		UserService userService = new UserServiceImpl();
		UserService userServiceProxy = new UserServiceProxy(userService);

		userServiceProxy.save();
		userServiceProxy.queryUsers();
	}
}
