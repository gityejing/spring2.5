package cn.itcast.f_di_2;

import org.springframework.stereotype.Component;

//@Component("userDao")
public class UserDaoImpl2 implements UserDao {

	@Override
	public void save(Object user) {
		System.out.println("UserDaoImpl.save()");
	}

}
