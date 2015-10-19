package cn.itcast.h_proxy2_jdk;

import org.springframework.stereotype.Component;

public class UserServiceImpl implements UserService {

	@Override
	public void saveUser() {
		System.out.println("== ±£¥ÊUser ==");
	}

	@Override
	public void deleteUser() {
		System.out.println("== …æ≥˝User ==");
	}

	@Override
	public void queryUsers() {
		System.out.println("== ≤È—ØUser ==");
	}

}
