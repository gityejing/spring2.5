package cn.itcast.b_beanfactory;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import cn.itcast.a_helloworld.UserDao;

public class FactoryTest {

	@Test
	public void test() throws Exception {
		// ʹ��BeanFactory
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		// ʹ��ApplicationContext
		// ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserDao userDao = (UserDao) factory.getBean("userDao");
		userDao.save(new Object());
	}

	@Test
	public void testApplicationContext() throws Exception {
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");

		ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext("c:/applicationContext.xml");

		XmlWebApplicationContext applicationContext3 = new XmlWebApplicationContext();
		// applicationContext3.setServletContext(servletContext);
		// applicationContext3.setConfigLocation("/WEB-INF/applicationContext.xml");

		// ==============================

		// // �Ƿ����ָ�����Ƶ�bean
		// applicationContext1.containsBean("userDao");
		// // ��ȡָ�����Ƶ�bean����������ڣ������쳣
		// applicationContext1.getBean("userDao");
		// // ��ȡ�����˶��ٸ�bean
		// applicationContext1.getBeanDefinitionCount();
		// // ��ȡ���ж����bean����������
		// applicationContext1.getBeanDefinitionNames();
		// // ��ȡ��������ָ�����͵�bean����������
		// applicationContext1.getBeanNamesForType(type);
		// // �������ͻ�ȡ��Ӧ��bean�����ص���һ��Map���ϣ�key�����ƣ�value��beanʵ����
		// applicationContext1.getBeansOfType(type);
	}

	@Test
	public void testClassPathXmlApplicationContext() throws Exception {
		// ָ��һ�������ļ�����classpath�ĸ�Ŀ¼�в���
		// ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// ָ����������ļ�
		// ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "beans_service.xml", "beans_dao.xml" });

		// ָ��һ�������ļ�����ָ�������ڵİ��в��ҡ�
		// ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", FactoryTest.class);

		// ָ����������ļ�����ָ�������ڵİ��в��ҡ�
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "beans_service.xml", "beans_dao.xml" }, FactoryTest.class);

		System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
	}
}
