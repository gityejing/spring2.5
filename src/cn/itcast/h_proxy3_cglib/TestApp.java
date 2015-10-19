package cn.itcast.h_proxy3_cglib;

import net.sf.cglib.proxy.Enhancer;

import org.junit.Test;

public class TestApp {

	@Test
	public void test() throws Exception {
		// Ŀ�����
		UserService userService = new UserService();
		// ���ɴ������
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(userService.getClass());
		enhancer.setCallback(new TxProxy(userService));
		UserService userServiceProxy = (UserService) enhancer.create();

		System.out.println(userServiceProxy.getClass());

		// ʹ��ʱӦʹ�ô������
		userServiceProxy.saveUser();
		userServiceProxy.deleteUser();
		userServiceProxy.queryUsers();
	}

}
