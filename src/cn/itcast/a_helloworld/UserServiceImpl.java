package cn.itcast.a_helloworld;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public void register(Object user) {
		System.out.println("UserServiceImpl.register()");
		userDao.save(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
