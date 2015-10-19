package cn.itcast.j_tx_jdbc;

public interface UserDao {

	void save(User user);

	User get(Integer id);
}
