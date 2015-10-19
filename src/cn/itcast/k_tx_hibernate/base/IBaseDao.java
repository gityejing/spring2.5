package cn.itcast.k_tx_hibernate.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;



public interface IBaseDao<E, PK extends Serializable> extends ISqlCommonDao{
HibernateTemplate getHibernateTemplate();
	
	/**
	 * ��ȡ�ýӿ�ʵ������������ݿ��
	 * @return
	 */
	String getTableName();
	
	/**
	 * ��ȡ�ýӿ�ʵ����Dao������ʵ�����simpleName;
	 * @return
	 */
	String getSimpleName();
	
	/**
	 * ��ȡ�ýӿ�ʵ���������ʵ�����canonicalName;
	 * @return
	 */
	String getCanonicalName();
	
	/**
	 * ͨ��Id��ȡʵ�������
	 * @param id
	 * @return
	 */
	E get(PK id);
	
	/**
	 * �Բ�ͬ״̬�µ�ʵ��A��remove��������²�����
	 * 1.���A��һ��new״̬��ʵ����A��״̬���ᷢ���κθı䣬��ϵͳ�Ի������ݿ���ִ��DELETE��䣻
	 * 2.���A��һ��managed״̬��ʵ��������״̬��ת��Ϊremoved��
	 * 3.���A��һ��removed״̬��ʵ�������ᷢ���κβ�����
	 * 4.���A��һ��detached״̬��ʵ�壬�÷��������׳��쳣��
	 * @param entity
	 */
	void remove(E entity);
	
	/**
	 * ����HQL��ѯ��䡢�����б���ҳ��Ϣ�������ݷ�װΪdaoʵ���෺��ָ����ʵ������
	 * @param hql
	 * @param params
	 * @param page
	 * @return
	 */
//	List<E> findListByHql(String hql, Object[] params, PageInfo page);
	
	/**
	 * ����HQL��ѯ��䡢�����б���ҳ��Ϣ�������ݷ�װΪdaoʵ���෺��ָ����ʵ������
	 * @param hql
	 * @param params
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	List<E> findListByHql(String hql, Object[] params, Integer firstResult, Integer maxResult);
	
	/**
	 * ����HQL��ѯ��䡢�����б���ҳ��Ϣ�������ݷ�װΪdaoʵ���෺��ָ����ʵ������
	 * @param hql
	 * @param params
	 * @return
	 */
	List<E> findListByHql(String hql, Object[] params);
	
	/**
	 * ����HQL��ѯ��䣬�����ݷ�װΪdaoʵ���෺��ָ����ʵ������
	 * @param hql
	 * @return
	 */
	List<E> findListByHql(String hql);
	
	/**
	 * ������countΪ�����HQL�����в�ѯ��
	 * @param hql
	 * @param params
	 * @return
	 */
	int findCountByHql(final String hql, final Object[] params);
	
	/**
	 * ����SQL��ѯ��䡢�����б���ҳ��Ϣ��ѯ���ݣ������ݷ�װΪdaoʵ���෺��ָ����ʵ������
	 * @param sql
	 * @param params
	 * @param page
	 * @return
	 */
//	List<E> findListBySql(String sql, Object[] params, PageInfo page);
	
	/**
	 * ����SQL��ѯ��䡢�����б��ѯ���ݣ������ݷ�װΪdaoʵ���෺��ָ����ʵ�����͡�
	 * @param sql
	 * @param params
	 * @return
	 */
	List<E> findListBySql(String sql, Object[] params);
	
	
	/**
	 * ����sql��ѯ���ݣ������ݷ�װΪdaoʵ���෺��ָ����ʵ�����͡�
	 * @param sql
	 * @return
	 */
	List<E> findListBySql(String sql);
	
	/**
	 * 
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
	
public <T> List<T> sqlFind(final String sql,final Class<T> c,final Object...params);
	
	public <T> List<T> sqlFind(final String sql,final Class<T> c,final Integer page,final Integer pageSize,final Object...params);
	
}
