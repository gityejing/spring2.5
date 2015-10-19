package cn.itcast.i_aop2_xml;

public class UserServiceImpl implements UserService {

	@Override
	public void saveUser() {
		System.out.println("== ±£¥ÊUser ==");
//		int a = 1 / 0;
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
