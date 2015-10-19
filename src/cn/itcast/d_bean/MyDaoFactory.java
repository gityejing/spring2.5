package cn.itcast.d_bean;

public class MyDaoFactory {

	/**
	 * 静态的工厂方法
	 * 
	 * @return
	 */
	public static UserDao getUserDaoInstance() {
		System.out.println("MyDaoFactory.getUserDaoInstance()");
		return new UserDaoImpl();
	}
}
