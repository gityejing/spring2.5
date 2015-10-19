package cn.itcast.k_tx_hibernate;


public interface UserDao {

	void save(User user);

	User get(Integer id);

}
