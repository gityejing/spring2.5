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
		// �����һ��
		User user = new User();
		user.setName("test1");
		userDao.save(user);

		// int a = 1 / 0; // ���л����쳣

		// ����ڶ���
		User user2 = new User();
		user2.setName("test2");
		userDao.save(user2);
	}

}
