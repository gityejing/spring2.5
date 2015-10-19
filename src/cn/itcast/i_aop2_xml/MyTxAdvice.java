package cn.itcast.i_aop2_xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ֪ͨ
 * 
 * @author tyg
 * 
 */
public class MyTxAdvice {

	// ǰ��֪ͨ
	public void before() {
		// System.out.println("����ʼ");
		System.out.println("ǰ��֪ͨ");
	}

	// ����֪ͨ
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
	public void afterReturning() {
		System.out.println("���غ�֪ͨ");
	}

	// �쳣֪ͨ
	public void afterThrowing() {
		System.out.println("�쳣֪ͨ");
	}

	// ����֪ͨ
	public void after() {
		// System.out.println("�������\n");
		System.out.println("����֪ͨ\n");
	}

}
