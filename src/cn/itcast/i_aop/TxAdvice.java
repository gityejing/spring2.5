package cn.itcast.i_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TxAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		try {
			// 前置通知
			// 环绕通知（前）
			Object result = methodInvocation.proceed(); // 执行原方法
			// 环绕通知（后）
			// 返回后通知
			return result;
		} catch (Exception e) {
			// 异常通知
			throw e;
		} finally {
			// 最终通知
		}
	}

}
