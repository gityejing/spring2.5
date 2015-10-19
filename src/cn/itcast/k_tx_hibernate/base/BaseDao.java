package cn.itcast.k_tx_hibernate.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sun.istack.internal.FinalArrayList;

public class BaseDao <E, PK extends Serializable> extends SqlCommonDao implements IBaseDao<E, PK>{

	@Resource
	protected HibernateTemplate hibernateTemplate;
	protected Class<E> type;
	
	@Resource(name="sessionFactory")
    public void setSessionFactory1(SessionFactory sessionFactory) {
        logger.debug(sessionFactory);
        super.setSessionFactory(sessionFactory);
    }
	
	@Override
	public HibernateTemplate getHibernateTemplate() {
		 return this.hibernateTemplate;
	}

	@Override
	public String getTableName() {
		 AbstractEntityPersister persister = (AbstractEntityPersister) getHibernateTemplate().getSessionFactory().getClassMetadata(type);
	     return persister.getTableName();
	}

	@Override
	public String getSimpleName() {
		return this.type.getSimpleName();
	}

	@Override
	public String getCanonicalName() {
		return this.type.getCanonicalName();
	}

	@Override
	public E get(PK id) {
		if(id==null) return null;
        return (E) this.hibernateTemplate.get(type, id);
	}

	@Override
	public void remove(E entity) {
		 this.hibernateTemplate.delete(entity);
	}

	@Override
	public List<E> findListByHql(final String hql, final Object[] params,
			final Integer firstResult, final Integer maxResult) {
			return this.hibernateTemplate.executeFind(new HibernateCallback() {
	            @Override
	            public List<E> doInHibernate(Session session) throws HibernateException, SQLException {
	                Query q = session.createQuery(hql);
	                if (null != params) {
	                    int size = params.length;
	                    for (int i = 0; i < size; i++) {
	                        q.setParameter(i, params[i]);
	                    }
	                }
	                q.setFirstResult(firstResult);
	                q.setMaxResults(maxResult);
	                return q.list();
	            }
	        });
	}

	@Override
	public List<E> findListByHql(String hql, Object[] params) {
		 return this.findListByHql(hql, params, null,null);
	}

	@Override
	public List<E> findListByHql(String hql) {
		return this.findListByHql(hql, null, null,null);
	}

	@Override
	public int findCountByHql(String hql, Object[] params) {
		if(params!=null && params.length>0){
    		return ((Long) this.hibernateTemplate.find(hql, params).get(0)).intValue();
    	}else{
    		return ((Long) this.hibernateTemplate.find(hql).get(0)).intValue();
    	}
	}

	public List<E> findListBySql(final String sql, final Object[] params, final Integer firstResult,final Integer maxResult) {
        return this.hibernateTemplate.executeFind(new HibernateCallback() {
            @Override
            public List<E> doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery q = session.createSQLQuery(sql);
                q.addEntity(type);
                if (null != params) {
                    for (int i = 0; i < params.length; i++) {
                        q.setParameter(i, params[i]);
                    }
                }
                if (firstResult != null && null != maxResult) {
                    q.setFirstResult(firstResult);
                    q.setMaxResults(maxResult);
                }
                return q.list();
            }
        });
    }
	
	@Override
	public List<E> findListBySql(String sql, Object[] params) {
		return this.findListBySql(sql, params, null,null);
	}

	@Override
	public List<E> findListBySql(String sql) {
		return this.findListBySql(sql, null,null, null);
	}

	@Override
	public E getUniqueBySql(final String sql, final Object[] params) {
        return (E) this.hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public E doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery q = session.createSQLQuery(sql);
                q.addEntity(type);
                if (null != params) {
                    for (int i = 0; i < params.length; i++) {
                        q.setParameter(i, params[i]);
                    }
                }
                return (E) q.uniqueResult();
            }
        });
    }
	@Override
	public E getUniqueBySql(String sql) {
		 return getUniqueBySql(sql, null);
	}
	
	
	@Override
	public <T> List<T> sqlFind(String sql, Class<T> c, Object... params) {
		return sqlFind(sql, c, null,null, params);
	}

	@Override
	 public <T> List<T> sqlFind(
	            final String sql,
	            final Class<T> c,
	            final Integer page,
	            final Integer pageSize,
	            final Object...params){
	        logger.debug("sql:"+sql);
	        logger.debug("page:"+page);
	        logger.debug("pageSize:"+pageSize);
	        logger.debug("params:"+params);
	        return getHibernateTemplate().executeFind(
	                new HibernateCallback() {
	                    @Override
	                    public Object doInHibernate(Session session)
	                            throws HibernateException, SQLException {
	                        SQLQuery query = session.createSQLQuery(sql);

	                        if (null != params) {
	                            for (int i = 0; i < params.length; i++) {
	                                query.setParameter(i, params[i]);
	                            }
	                        }
	                        if(page!=null&&pageSize!=null&&page>0&&pageSize>0){
	                            query.setFirstResult((page-1)*pageSize);
	                            query.setMaxResults(pageSize);
	                        }
	                        if(c!=null)
	                        {
	                            logger.debug(c);
	                            //Èç¹ûÊÇMap
	                            if(c.isAssignableFrom(Map.class)) {
	                                query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	                            }
	                            else {
	                                query.setResultTransformer(Transformers.aliasToBean(c));
	                            }
	                        }
	                        return query.list();
	                    }
	                });
	    }


}
