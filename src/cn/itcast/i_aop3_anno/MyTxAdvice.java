package cn.itcast.i_aop3_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// ����
@Aspect
public class MyTxAdvice {

	// ����һ������㣬����Ϊ������
	@Pointcut("execution(* *(..))")
	public void myPointcut() {
		
	}

	// ͨ��args(user)���Ի�ȡ��������ķ����еĲ���
	@Before("myPointcut()&&args(user)")
	public void before(User user) {
		System.out.println("==>����ǰ��֪ͨ");
		System.out.println("==>��ӡ�����صķ����еĲ�����Ϣ:"+user);
		System.out.println("ǰ��֪ͨ");
	}

	@Around("myPointcut()")
	public Object around22(ProceedingJoinPoint jp) {
		try {
			System.out.println("����֪ͨ��ǰ��");
			Object result = jp.proceed(); // ִ��ԭ����
			System.out.println("����֪ͨ����");
			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	// ���غ�֪ͨ
	@AfterReturning(pointcut = "myPointcut()")
	public void afterReturning() {
		System.out.println("���غ�֪ͨ");
	}

	// �쳣֪ͨ
	@AfterThrowing(pointcut = "myPointcut()")
	public void afterThrowing() {
		System.out.println("�쳣֪ͨ");
	}

	// ����֪ͨ
	@After("myPointcut()")
	public void after() {
		System.out.println("����֪ͨ\n");
	}
}
