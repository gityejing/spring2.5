package cn.itcast.c_resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class ResourceTest {

	// 1����ClassPath��Ŀ¼�в�����Դ
	@Test
	public void testClassPathResource() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		System.out.println(resource.getFile());
	}

	// 2�� FileSystemResource�� ���ļ�ϵͳ�ж�ȡ
	@Test
	public void testFileSystemResource() throws Exception {
		Resource resource = new FileSystemResource("c:/applicationContext.xml");
		System.out.println(resource.getFile());
	}

	// 3�� UrlResource�� ��ָ��URL�ж�ȡ
	@Test
	public void testUrlResource() throws Exception {
		Resource resource = new UrlResource("http://gz.itcast.cn/applicationContext.xml");
		System.out.println(resource.getFile());
	}

	// 4�� ServletContextResource ����Ҫ��web������ʹ��
	@Test
	public void testServletContextResource() throws Exception {
		// ��Web���̵ĸ�Ŀ¼�в�����Դ
		// Resource resource = new ServletContextResource(servletContext, "/WEB-INF/applicationContext.xml");
	}

	// ����ʹ�ò�ͬ��ǰ׺��ʾʹ�ò�ͬ�ķ�ʽ��ȡ��Դ��
	// ���û��ǰ׺����Ĭ�ϲ��ҵķ�ʽ������ApplicationContext�ľ������;����ġ�
	@Test
	public void testApplicationContext() throws Exception {
		// ApplicationContext factory = new ClassPathXmlApplicationContext("http://gz.itcast.cn/applicationContext.xml");
		// ApplicationContext factory = new ClassPathXmlApplicationContext("file:c:/applicationContext.xml");
		// ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlWebApplicationContext factory2 = new XmlWebApplicationContext();
		factory2.setConfigLocation("/WEB-INF/applicationContext.xml");
		
		System.out.println(factory.getBeanDefinitionCount());
	}

}
