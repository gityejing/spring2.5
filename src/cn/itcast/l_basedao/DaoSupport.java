package cn.itcast.l_basedao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSupport extends HibernateDaoSupport implements IDaoSupport{

	///////////////////////////////////////////////////
	// ��������������������
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
