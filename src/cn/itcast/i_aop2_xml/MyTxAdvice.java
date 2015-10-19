package cn.itcast.i_aop2_xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 通知
 * 
 * @author tyg
 * 
 */
public class MyTxAdvice {

	// 前置通知
	public void before() {
		// System.out.println("事务开始");
		System.out.println("前置通知");
	}

	// 环绕通知
	public Object around22(ProceedingJoinPoint jp) {
		try {
			System.out.println("环绕通知（前）");
			Object result = jp.proceed(); // 执行原方法
			System.out.println("环绕通知（后）");
			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	// 返回后通知
	public void afterReturning() {
		System.out.println("返回后通知");
	}

	// 异常通知
	public void afterThrowing() {
		System.out.println("异常通知");
	}

	// 最终通知
	public void after() {
		// System.out.println("事务结束\n");
		System.out.println("最终通知\n");
	}

}
