package cn.itcast.i_aop3_anno;

import javax.annotation.Resource;

// service��xml���õ�
public class UserServiceImpl implements UserService {
	
	// �������ͨ��ע��ķ�ʽ��ע��dao
	@Resource
	private UserDao userDao; // daoҲ��xml���õ�
	
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
