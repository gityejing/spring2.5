package cn.itcast.j_tx_jdbc_2;

import java.util.List;

public interface UserDao {

	void save(User user);

	void delete(Integer id);

	void update(User user);

	User get(Integer id);

	/**
	 * 查询总数量
	 * 
	 * @return
	 */
	int getCount();

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<User> findAll();

}
