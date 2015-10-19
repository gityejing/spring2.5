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
		// 目标对象
		UserService userServiceImpl = new UserServiceImpl();

		// >> 切入点：拦截哪些方法
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("save*");
		pointcut.addMethodName("delete*");
		pointcut.addMethodName("update*");

		// >> 通知：要做什么事
		TxAdvice txAdvice = new TxAdvice();

		// >> 切面 = 切入点 + 通知
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, txAdvice);

		// >> 生成代理对象
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor); // 添加一个切面
		proxyFactory.setTarget(userServiceImpl); // 指定目标对象
		UserService userServiceProxy = (UserService) proxyFactory.getProxy(); // 获取代理对象

		// 使用时应使用代理对象
		userServiceProxy.saveUser();
		userServiceProxy.deleteUser();
		userServiceProxy.queryUsers();
	}

}
