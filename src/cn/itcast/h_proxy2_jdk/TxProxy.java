package cn.itcast.h_proxy2_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TxProxy implements InvocationHandler {

	private Object target;

	public TxProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("query")) {
			return  method.invoke(target, args); // 执行原方法
		} else {
			System.out.println(">> 事务开始 <<");
			Object result = method.invoke(target, args); // 执行原方法
			System.out.println(">> 事务结束 <<\n");
			return result;
		}
	}

}
