package cn.itcast.h_proxy;

public class UserServiceProxy implements UserService {

	// Ŀ�����
	private UserService target;

	public UserServiceProxy(UserService target) {
		this.target = target;
	}

	@Override
	public void save() {
		System.out.println(">> ����ʼ <<");
		target.save();
		System.out.println(">> ������� <<");
	}

	@Override
	public void queryUsers() {
		System.out.println(">> ����ʼ <<");
		target.queryUsers();
		System.out.println(">> ������� <<");
	}

}
