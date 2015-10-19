package cn.itcast.k_tx_hibernate.base;

import java.io.Serializable;

import org.springframework.orm.hibernate3.HibernateOperations;

public interface ISqlCommonDao {
	public <G> G getEntity(Class<G> entityClass, Serializable id);
	public <G> void persistEntity(G entity);
	public <G> G mergeEntity(G entity);
	public <G> void removeEntity(G entity);
}
