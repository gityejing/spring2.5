package cn.itcast.l_basedao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface IBaseDao<E, PK extends Serializable> {
	HibernateTemplate getHibernateTemplate();
	/**
	 * 获取该接口实现类操作的数据库表
	 * 
	 * @return
	 */
	String getTableName();

	/**
	 * 获取该接口实现类Dao操作的实体类的simpleName;
	 * 
	 * @return
	 */
	String getSimpleName();

	/**
	 * 获取该接口实现类操作的实体类的canonicalName;
	 * 
	 * @return
	 */
	String getCanonicalName();

	/**
	 * 通过Id获取实体类对象。
	 * 
	 * @param id
	 * @return
	 */
	E get(PK id);

	/**
	 * 对不同状态下的实例A，remove会产生以下操作：
	 * 1.如果A是一个new状态的实例，A的状态不会发生任何改变，但系统仍会在数据库中执行DELETE语句；
	 * 2.如果A是一个managed状态的实例，它的状态会转换为removed； 3.如果A是一个removed状态的实例，不会发生任何操作；
	 * 4.如果A是一个detached状态的实体，该方法将会抛出异常。
	 * 
	 * @param entity
	 */
	void remove(E entity);

	/**
	 * 根据HQL查询语句、参数列表、分页信息，将数据封装为dao实现类泛型指定的实体类型
	 * 
	 * @param hql
	 * @param params
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	List<E> findListByHql(String hql, Object[] params, Integer firstResult,
			Integer maxResult);

	/**
	 * 根据HQL查询语句、参数列表、分页信息，将数据封装为dao实现类泛型指定的实体类型
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	List<E> findListByHql(String hql, Object[] params);

	/**
	 * 根据HQL查询语句，将数据封装为dao实现类泛型指定的实体类型
	 * 
	 * @param hql
	 * @return
	 */
	List<E> findListByHql(String hql);

	/**
	 * 根据以count为结果的HQL语句进行查询。
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	int findCountByHql(final String hql, final Object[] params);
	

	/**
	 * 根据SQL查询语句、参数列表查询数据，将数据封装为dao实现类泛型指定的实体类型。
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	List<E> findListBySql(String sql, Object[] params);

	/**
	 * 根据sql查询数据，将数据封装为dao实现类泛型指定的实体类型。
	 * 
	 * @param sql
	 * @return
	 */
	List<E> findListBySql(String sql);

	
	/**
	 * 根据SQL查询语句、参数列表、分页信息，将数据封装为dao实现类泛型指定的实体类型
	 * 
	 * @param hql
	 * @param params
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	List<E> findListBySql(String sql, Object[] params, Integer firstResult,
			Integer maxResult);
	
	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	E getUniqueBySql(String sql, Object[] params);

	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	E getUniqueBySql(String sql);

	public <T> List<T> sqlFind(final String sql, final Class<T> c,
			final Object... params);

	public <T> List<T> sqlFind(final String sql, final Class<T> c,
			final Integer page, final Integer pageSize, final Object... params);

}
