package cn.itcast.j_tx_jdbc_3;


public interface UserDao {

	void save(User user);

	User get(Integer id);

}
