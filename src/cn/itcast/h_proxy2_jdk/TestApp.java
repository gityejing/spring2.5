package cn.itcast.h_proxy2_jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestApp {

	@Test
	public void test() throws Exception {
		// 目标对象
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		// 生成代理对象
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(getClass().getClassLoader(),//
				userServiceImpl.getClass().getInterfaces(),//
				new TxProxy(userServiceImpl));

		System.out.println(userServiceProxy.getClass());

		// 使用时应使用代理对象
		userServiceProxy.saveUser();
		userServiceProxy.deleteUser();
		userServiceProxy.queryUsers();
	}

	@Test
	public void test2() throws Exception {
		// 目标对象
		DepartmentService deptService = new DepartmentServiceImpl();
		// 生成代理对象
		DepartmentService deptServiceProxy = (DepartmentService) Proxy.newProxyInstance(getClass().getClassLoader(),//
				deptService.getClass().getInterfaces(),//
				new TxProxy(deptService));

		// 使用时应使用代理对象
		deptServiceProxy.save();
		deptServiceProxy.update();
	}
}
