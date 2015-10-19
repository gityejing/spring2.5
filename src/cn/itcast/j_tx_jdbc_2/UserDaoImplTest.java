package cn.itcast.j_tx_jdbc_2;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml", getClass());
	private UserDao userDao = (UserDao) ac.getBean("userDao");

	@Test
	public void testSave() {
		User user = new User();
		user.setName("大明");
		userDao.save(user);
	}

	@Test
	public void testDelete() {
		userDao.delete(1);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(2);
		user.setName("小兰");

		userDao.update(user);
	}

	@Test
	public void testGet() {
		User user = userDao.get(2);
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		List<User> list = userDao.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testGetCount() {
		int count = userDao.getCount();
		System.out.println("总数量：" + count);
	}

}
