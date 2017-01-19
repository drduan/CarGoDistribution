package com.neusoft.cargo.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Score;


@Repository("ScoreDao")
public class ScoreDao  extends BaseHibernateDAO{

	public void save(Score transientInstance) throws Exception {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Score persistentInstance) throws Exception {
		try {
			getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Integer deleteByIds(String ids) {
		return getSession().createQuery("delete from Score where id in(" + ids + ")").executeUpdate();
	}

	public List<Score> findByExample(Score instance) {
		try {
			@SuppressWarnings("unchecked")
			List<Score> results = getSession().createCriteria("com.neusoft.cargo.entity.Score").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Score> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Score as model where model." + propertyName + "= ?";
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
	public List<Score> findByProperty(Map<String, Object> map, String extra) {
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

	public Score findById(java.lang.Integer id) {
		try {
			Score instance = (Score) getSession().get("com.neusoft.cargo.entity.Score", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Score> findAll() {
		try {
			String queryString = "from Score";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
