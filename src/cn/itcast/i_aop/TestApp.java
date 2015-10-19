package cn.itcast.i_aop;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class TestApp {

	@Test
	public void test() throws Exception {
		// Ŀ�����
		UserService userServiceImpl = new UserServiceImpl();

		// >> ����㣺������Щ����
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("save*");
		pointcut.addMethodName("delete*");
		pointcut.addMethodName("update*");

		// >> ֪ͨ��Ҫ��ʲô��
		TxAdvice txAdvice = new TxAdvice();

		// >> ���� = ����� + ֪ͨ
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, txAdvice);

		// >> ���ɴ������
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor); // ���һ������
		proxyFactory.setTarget(userServiceImpl); // ָ��Ŀ�����
		UserService userServiceProxy = (UserService) proxyFactory.getProxy(); // ��ȡ�������

		// ʹ��ʱӦʹ�ô������
		userServiceProxy.saveUser();
		userServiceProxy.deleteUser();
		userServiceProxy.queryUsers();
	}

}
