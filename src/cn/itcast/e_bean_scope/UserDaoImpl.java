package cn.itcast.e_bean_scope;

public class UserDaoImpl implements UserDao {

	private String jdbcUrl;
	private String driverClass;
	private String username;
	private String password;

	public UserDaoImpl() {
		System.out.println(">>UserDaoImpl.UserDaoImpl()");
	}

	public void init() {
		System.out.println("��һЩ��ʼ��dao�Ĺ���...");
	}

	public void destroy() {
		System.out.println("��һЩ�ƺ���...");
	}

	@Override
	public void save(Object user) {
		System.out.println("UserDaoImpl.save()");
		System.out.println(">> jdbcUrl = " + jdbcUrl);
		System.out.println(">> driverClass = " + driverClass);
		System.out.println(">> username = " + username);
		System.out.println(">> password = " + password);
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
