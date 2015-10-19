package cn.itcast.f_di;

public class UserDao {

	private String jdbcUrl; // jdbc:mysql:///test?username=root&password=root
	private String driverClass;

	public void printInfo() {
		System.out.println("jdbcUrl = " + jdbcUrl);
		System.out.println("driverClass = " + driverClass);
	}

	public UserDao() {
	}

	public UserDao(String jdbcUrl, String driverClass) {
		this.jdbcUrl = jdbcUrl;
		this.driverClass = driverClass;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

}
