package cn.itcast.f_di_2;

import org.springframework.stereotype.Component;

@Component("userDao1")
public class UserDaoImpl implements UserDao {

	@Override
	public void save(Object user) {
		System.out.println("UserDaoImpl.save()");
	}

}
