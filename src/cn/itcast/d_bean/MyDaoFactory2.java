package cn.itcast.d_bean;

public class MyDaoFactory2 {

	/**
	 * �Ǿ�̬�Ĺ�������
	 * 
	 * @return
	 */
	public UserDao getUserDaoInstance() {
		System.out.println("��static��MyDaoFactory.getUserDaoInstance()");
		return new UserDaoImpl();
	}
}
