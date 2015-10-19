package cn.itcast.j_tx_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());
	private UserDao userDao = (UserDao) ac.getBean("springUserDao");

	@Test
	public void testSave() throws Exception {
		// �����û�
		User user = new User();
		user.setName("����");

		// ���浽DB
		userDao.save(user);
	}

	@Test
	public void testGet() throws Exception {
		User user = userDao.get(5);
		System.out.println(user);
		 System.out.println(user.getName());
	}
}
