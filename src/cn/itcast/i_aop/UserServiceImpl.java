package cn.itcast.i_aop;

import org.springframework.stereotype.Component;

public class UserServiceImpl implements UserService {

	@Override
	public void saveUser() {
		System.out.println("== ����User ==");
	}

	@Override
	public void deleteUser() {
		System.out.println("== ɾ��User ==");
	}

	@Override
	public void queryUsers() {
		System.out.println("== ��ѯUser ==");
	}

}
