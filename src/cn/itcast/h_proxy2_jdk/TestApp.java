package cn.itcast.h_proxy2_jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestApp {

	@Test
	public void test() throws Exception {
		// Ŀ�����
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		// ���ɴ������
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(getClass().getClassLoader(),//
				userServiceImpl.getClass().getInterfaces(),//
				new TxProxy(userServiceImpl));

		System.out.println(userServiceProxy.getClass());

		// ʹ��ʱӦʹ�ô������
		userServiceProxy.saveUser();
		userServiceProxy.deleteUser();
		userServiceProxy.queryUsers();
	}

	@Test
	public void test2() throws Exception {
		// Ŀ�����
		DepartmentService deptService = new DepartmentServiceImpl();
		// ���ɴ������
		DepartmentService deptServiceProxy = (DepartmentService) Proxy.newProxyInstance(getClass().getClassLoader(),//
				deptService.getClass().getInterfaces(),//
				new TxProxy(deptService));

		// ʹ��ʱӦʹ�ô������
		deptServiceProxy.save();
		deptServiceProxy.update();
	}
}
