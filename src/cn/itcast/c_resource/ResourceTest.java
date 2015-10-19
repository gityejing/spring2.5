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

	// 1，从ClassPath根目录中查找资源
	@Test
	public void testClassPathResource() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		System.out.println(resource.getFile());
	}

	// 2， FileSystemResource　 从文件系统中读取
	@Test
	public void testFileSystemResource() throws Exception {
		Resource resource = new FileSystemResource("c:/applicationContext.xml");
		System.out.println(resource.getFile());
	}

	// 3， UrlResource　 从指定URL中读取
	@Test
	public void testUrlResource() throws Exception {
		Resource resource = new UrlResource("http://gz.itcast.cn/applicationContext.xml");
		System.out.println(resource.getFile());
	}

	// 4， ServletContextResource 必须要在web环境下使用
	@Test
	public void testServletContextResource() throws Exception {
		// 从Web工程的根目录中查找资源
		// Resource resource = new ServletContextResource(servletContext, "/WEB-INF/applicationContext.xml");
	}

	// 可以使用不同的前缀表示使用不同的方式获取资源。
	// 如果没有前缀，则默认查找的方式是依赖ApplicationContext的具体类型决定的。
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
