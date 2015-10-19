package cn.itcast.h_proxy;

public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("== ±£¥ÊUser ==");
	}

	@Override
	public void queryUsers() {
		System.out.println("== ≤È—ØUser ==");
	}

}
