package cn.itcast.d_bean;

public class MyDaoFactory {

	/**
	 * ��̬�Ĺ�������
	 * 
	 * @return
	 */
	public static UserDao getUserDaoInstance() {
		System.out.println("MyDaoFactory.getUserDaoInstance()");
		return new UserDaoImpl();
	}
}
