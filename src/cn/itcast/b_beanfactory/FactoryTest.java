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
		// 使用BeanFactory
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		// 使用ApplicationContext
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

		// // 是否包含指定名称的bean
		// applicationContext1.containsBean("userDao");
		// // 获取指定名称的bean，如果不存在，就抛异常
		// applicationContext1.getBean("userDao");
		// // 获取定义了多少个bean
		// applicationContext1.getBeanDefinitionCount();
		// // 获取所有定义的bean的名称数组
		// applicationContext1.getBeanDefinitionNames();
		// // 获取所有属于指定类型的bean的名称数组
		// applicationContext1.getBeanNamesForType(type);
		// // 根据类型获取相应的bean，返回的是一个Map集合，key是名称，value是bean实例。
		// applicationContext1.getBeansOfType(type);
	}

	@Test
	public void testClassPathXmlApplicationContext() throws Exception {
		// 指定一个配置文件，从classpath的根目录中查找
		// ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 指定多个配置文件
		// ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "beans_service.xml", "beans_dao.xml" });

		// 指定一个配置文件，从指定类所在的包中查找。
		// ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", FactoryTest.class);

		// 指定多个配置文件，从指定类所在的包中查找。
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "beans_service.xml", "beans_dao.xml" }, FactoryTest.class);

		System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
	}
}
