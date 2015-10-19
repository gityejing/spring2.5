package cn.itcast.h_proxy;

public class UserServiceProxy implements UserService {

	// 目标对象
	private UserService target;

	public UserServiceProxy(UserService target) {
		this.target = target;
	}

	@Override
	public void save() {
		System.out.println(">> 事务开始 <<");
		target.save();
		System.out.println(">> 事务结束 <<");
	}

	@Override
	public void queryUsers() {
		System.out.println(">> 事务开始 <<");
		target.queryUsers();
		System.out.println(">> 事务结束 <<");
	}

}
