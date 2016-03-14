package cn.itcast.k_tx_hibernate;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository(value="springUserDao")
public class SpringUserDaoImpl implements UserDao {

	// @Resource
	// private HibernateTemplate hibernateTemplate;

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		// System.out.println("SpringUserDaoImpl.save()");
		// hibernateTemplate.save(user);

		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User get(Integer id) {
		// System.out.println("SpringUserDaoImpl.get()");
		// return (User) hibernateTemplate.get(User.class, id);

		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

}
