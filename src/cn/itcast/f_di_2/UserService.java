package cn.itcast.f_di_2;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
// @Controller("userService")
// @Service("userService")
// @Repository("userService")
public class UserService {

	@Resource
	private UserDao userDao;

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
