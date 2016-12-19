package com.neusoft.cargo.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.User;


@Repository("UserDao")
public class UserDao  extends BaseHibernateDAO{

	public void save(User transientInstance) throws Exception {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(User persistentInstance) throws Exception {
		try {
			getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Integer deleteByIds(String ids) {
		return getSession().createQuery("delete from Video where id in(" + ids + ")").executeUpdate();
	}

	public List<User> findByExample(User instance) {
		try {
			@SuppressWarnings("unchecked")
			List<User> results = getSession().createCriteria("cn.elfsoft.entity.Video").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Video as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 根据条件查询
	 * 
	 * @param map
	 *            参数map
	 * @param extra
	 *            额外的条件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> findByProperty(Map<String, Object> map, String extra) {
		try {
			String queryString = "from Video as model where 1=1 ";
			for (String key : map.keySet()) {
				queryString += "and model." + key + "=? ";
			}
			queryString += extra;
			Query queryObject = getSession().createQuery(queryString);
			int index = 0;
			for (String key : map.keySet()) {
				queryObject.setParameter(index++, map.get(key));
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		try {
			User instance = (User) getSession().get("cn.elfsoft.entity.Video", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
