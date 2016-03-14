package cn.itcast.k_tx_hibernate;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.itcast.l_basedao.BaseDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User, Integer>implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user); // ²Ù×÷
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public User get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, id); // ²Ù×÷
			tx.commit();
			return user;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

}
