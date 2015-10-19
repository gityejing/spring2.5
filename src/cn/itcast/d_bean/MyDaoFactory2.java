package cn.itcast.d_bean;

public class MyDaoFactory2 {

	/**
	 * 非静态的工厂方法
	 * 
	 * @return
	 */
	public UserDao getUserDaoInstance() {
		System.out.println("非static的MyDaoFactory.getUserDaoInstance()");
		return new UserDaoImpl();
	}
}
