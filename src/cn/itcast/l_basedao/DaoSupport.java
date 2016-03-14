package cn.itcast.l_basedao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSupport extends HibernateDaoSupport implements IDaoSupport{

	///////////////////////////////////////////////////
	// 以下这两个都能起到作用
//	@Resource
//	public void setSessionFactory1(SessionFactory sessionFactory) {
//		super.setSessionFactory(sessionFactory);
//	}
	
	@Resource
	public void setHibernateTemplate1(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	///////////////////////////////////////////////////////////////
	
}
