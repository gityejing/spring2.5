package cn.itcast.j_tx_jdbc_2;

import java.util.List;

public interface UserDao {

	void save(User user);

	void delete(Integer id);

	void update(User user);

	User get(Integer id);

	/**
	 * ��ѯ������
	 * 
	 * @return
	 */
	int getCount();

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	List<User> findAll();

}
