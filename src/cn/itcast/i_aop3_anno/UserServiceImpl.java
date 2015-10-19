package cn.itcast.i_aop3_anno;

import javax.annotation.Resource;

// service是xml配置的
public class UserServiceImpl implements UserService {
	
	// 这里可以通过注解的方式来注入dao
	@Resource
	private UserDao userDao; // dao也是xml配置的
	
	@Override
	public void deleteUser() {
		userDao.deleteUser();
	}

	@Override
	public void queryUsers() {
		userDao.queryUsers();
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
