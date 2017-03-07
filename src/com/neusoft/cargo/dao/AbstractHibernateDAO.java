package com.neusoft.cargo.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

public abstract class AbstractHibernateDAO<T extends Serializable> {

	private Class<T> clazz;
	private Session session;
	private static final Log log = LogFactory.getLog(GetClassLoader.fromContext().getClass());

	@Autowired
	private org.hibernate.SessionFactory SessionFactory;

	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	public T findOne(final long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	/*
	 * save or update
	 */
//	public void save(final T entity) {
//		log.debug("saving Selllog instance");
//		try {
//			getCurrentSession().saveOrUpdate(entity);
//			log.debug("save successful");
//		} catch (Exception re) {
//			log.debug("save failed");
//			throw re;
//			
//		}
//	}

	public T update(final T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(final long id) {
		final T entity = findOne(id);
		delete(entity);
	}

	/*
	 * 如果用的getCurrentSession方法得到的session是不需要关闭的，会自动完成，每次事务提交就好了;
	 * 如果出现异常会自动回滚;如果是opensession得到的session，则需要手动去关闭session。通过ThreadLocal.set()
	 * 到线程上的
	 */
	protected final Session getCurrentSession() {
		return SessionFactory.getCurrentSession();
	}

	public void flush() {
		getCurrentSession().flush();
	}

	public void clear() {
		getCurrentSession().clear();
	}

	public void close() {
		getCurrentSession().close();

	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	public Class<T> getPersistentClass() {
		return clazz;
	}

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate()

	{

		// 首先，检查原来的hibernateTemplate实例是否还存在

		if (hibernateTemplate == null)

		{

			// 如果不存在，新建一个HibernateTemplate实例

			hibernateTemplate = new HibernateTemplate(SessionFactory);

		}

		return hibernateTemplate;

	}

}
