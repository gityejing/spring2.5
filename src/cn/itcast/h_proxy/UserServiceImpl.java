package cn.itcast.h_proxy;

public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("== ����User ==");
	}

	@Override
	public void queryUsers() {
		System.out.println("== ��ѯUser ==");
	}

}
