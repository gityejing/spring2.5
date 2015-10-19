package cn.itcast.k_tx_hibernate.base;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class SqlCommonDao extends HibernateTemplate implements ISqlCommonDao {

	@Resource
	protected HibernateTemplate hibernateTemplate;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory1(SessionFactory sessionFactory) {
		logger.debug(sessionFactory);
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public <T> T getEntity(Class<T> entityClass, Serializable id){
		if(id==null) return null;
		return (T) this.hibernateTemplate.get(entityClass, id);
	}

	@Override
	public <T> T mergeEntity(T entity){
		return (T) this.hibernateTemplate.merge(entity);
	}
	
	@Override
	public <T> void persistEntity(T entity){
		this.hibernateTemplate.persist(entity);
	}
	
	@Override
	public <T> void removeEntity(T entity){
		this.hibernateTemplate.delete(entity);
	}
	

}
