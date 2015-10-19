package cn.itcast.h_proxy3_cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TxProxy implements MethodInterceptor {

	private Object target;

	public TxProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println(">> ����ʼ2 <<");
		Object result = method.invoke(target, args); // ִ��ԭ����
		System.out.println(">> �������2 <<\n");
		return result;
	}

}
