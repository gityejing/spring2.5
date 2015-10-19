package cn.itcast.h_proxy3_cglib;

import net.sf.cglib.proxy.Enhancer;

import org.junit.Test;

public class TestApp {

	@Test
	public void test() throws Exception {
		// 目标对象
		UserService userService = new UserService();
		// 生成代理对象
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(userService.getClass());
		enhancer.setCallback(new TxProxy(userService));
		UserService userServiceProxy = (UserService) enhancer.create();

		System.out.println(userServiceProxy.getClass());

		// 使用时应使用代理对象
		userServiceProxy.saveUser();
		userServiceProxy.deleteUser();
		userServiceProxy.queryUsers();
	}

}
