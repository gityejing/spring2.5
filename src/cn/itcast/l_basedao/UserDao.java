package cn.itcast.l_basedao;

import cn.itcast.k_tx_hibernate.base.IBaseDao;


public interface UserDao{
	void save(User user);
	User get(Integer id);
}
