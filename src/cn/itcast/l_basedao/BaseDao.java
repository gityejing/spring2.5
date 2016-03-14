package cn.itcast.l_basedao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sun.istack.internal.FinalArrayList;

/**
 * @param <E>
 * @param <PK>
 */
@Repository
public class BaseDao<E, PK extends Serializable> implements IBaseDao<E, PK> {

	@Resource
	public IDaoSupport daoSupport;
	public Class<E> type;

	public BaseDao() {
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.type = (Class<E>) p[0];
		}
	}

	public void save(E e) {
		daoSupport.getHibernateTemplate().save(e);
	}

	public void update(E e) {
		daoSupport.getHibernateTemplate().update(e);
	}

	public void delete(E e) {
		daoSupport.getHibernateTemplate().delete(e);
	}

	public E get(PK id) {
		return (E) daoSupport.getHibernateTemplate().get(type, id);
	}

	public IDaoSupport getDaoSupport() {
		return daoSupport;
	}

	public void setDaoSupport(IDaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public HibernateTemplate getHibernateTemplate() {
		return daoSupport.getHibernateTemplate();
	}

	@Override
	public String getTableName() {
		AbstractEntityPersister persister = (AbstractEntityPersister) getHibernateTemplate()
				.getSessionFactory().getClassMetadata(type);
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
	public void remove(E entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public List findListByHql(final String hql, final Object[] params,
			final Integer firstResult, final Integer maxResult) {
		return daoSupport.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public List<E> doInHibernate(Session session)
							throws HibernateException, SQLException {
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
	public List findListByHql(String hql, Object[] params) {
		return this.findListByHql(hql, params, null, null);
	}

	@Override
	public List findListByHql(String hql) {
		return this.findListByHql(hql, null, null, null);
	}

	@Override
	public int findCountByHql(String hql, Object[] params) {
		if (params != null && params.length > 0) {
			return ((Long) daoSupport.getHibernateTemplate().find(hql, params)
					.get(0)).intValue();
		} else {
			return ((Long) daoSupport.getHibernateTemplate().find(hql).get(0))
					.intValue();
		}
	}

	@Override
	public List findListBySql(String sql, Object[] params) {
		return this.findListBySql(sql, params, null, null);
	}

	@Override
	public List findListBySql(String sql) {
		return this.findListBySql(sql, null, null, null);
	}

	@Override
	public List findListBySql(final String sql, final Object[] params,
			final Integer firstResult, final Integer maxResult) {
		return daoSupport.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public List<E> doInHibernate(Session session)
							throws HibernateException, SQLException {
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
	public E getUniqueBySql(final String sql, final Object[] params) {
		return (E) daoSupport.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public E doInHibernate(Session session)
							throws HibernateException, SQLException {
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
	public List sqlFind(String sql, Class c, Object... params) {
		return sqlFind(sql, c, null,null, params);
	}

	@Override
	public List sqlFind(final String sql, final Class c, final Integer page,
			final Integer pageSize, final Object... params) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				SQLQuery query = session.createSQLQuery(sql);

				if (null != params) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				if (page != null && pageSize != null && page > 0
						&& pageSize > 0) {
					query.setFirstResult((page - 1) * pageSize);
					query.setMaxResults(pageSize);
				}
				if (c != null) {
					// Èç¹ûÊÇMap
					if (c.isAssignableFrom(Map.class)) {
						query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
					} else {
						query.setResultTransformer(Transformers.aliasToBean(c));
					}
				}
				return query.list();
			}
		});
	}
}
