package cn.itcast.l_basedao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Resource
	private UserDao userDao;

	@Transactional
	public void saveTwoUsers() {
		// 保存第一个
		User user = new User();
		user.setName("test1");
		userDao.save(user);

		// int a = 1 / 0; // 这行会抛异常

		// 保存第二个
		User user2 = new User();
		user2.setName("test2");
		userDao.save(user2);
	}

}
