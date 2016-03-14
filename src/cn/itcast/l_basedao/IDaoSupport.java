package cn.itcast.l_basedao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface IDaoSupport {
	HibernateTemplate getHibernateTemplate();
}
