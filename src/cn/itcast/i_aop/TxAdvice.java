package cn.itcast.i_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TxAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		try {
			// ǰ��֪ͨ
			// ����֪ͨ��ǰ��
			Object result = methodInvocation.proceed(); // ִ��ԭ����
			// ����֪ͨ����
			// ���غ�֪ͨ
			return result;
		} catch (Exception e) {
			// �쳣֪ͨ
			throw e;
		} finally {
			// ����֪ͨ
		}
	}

}
