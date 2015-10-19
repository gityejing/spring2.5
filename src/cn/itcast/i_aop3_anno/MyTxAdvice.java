package cn.itcast.i_aop3_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// 切面
@Aspect
public class MyTxAdvice {

	// 声明一个切入点，名称为方法名
	@Pointcut("execution(* *(..))")
	public void myPointcut() {
		
	}

	// 通过args(user)可以获取到被代理的方法中的参数
	@Before("myPointcut()&&args(user)")
	public void before(User user) {
		System.out.println("==>调用前置通知");
		System.out.println("==>打印被拦截的方法中的参数信息:"+user);
		System.out.println("前置通知");
	}

	@Around("myPointcut()")
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
	@AfterReturning(pointcut = "myPointcut()")
	public void afterReturning() {
		System.out.println("返回后通知");
	}

	// 异常通知
	@AfterThrowing(pointcut = "myPointcut()")
	public void afterThrowing() {
		System.out.println("异常通知");
	}

	// 最终通知
	@After("myPointcut()")
	public void after() {
		System.out.println("最终通知\n");
	}
}
