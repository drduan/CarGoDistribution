package com.neusoft.cargo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.User;

@Repository("UserDao")
public class UserDao extends AbstractHibernateDAO<User> {

	private static final Log log = LogFactory.getLog(UserDao.class);
	// property constants
	public static final String OPENING_BALENCE = "openingBalence";
	public static final String RECEIVE = "receive";
	public static final String TRANSFER = "transfer";
	public static final String TRANSFER_TO_COMMENT = "transferToComment";
	public static final String DAY_BRAND_RATE = "dayBrandRate";
	public static final String CLOSING_BALANCE = "closingBalance";
	public static final String LAST_UPDATE_USE_ID = "lastUpdateUseId";

	public UserDao() {
		setClazz(User.class);
	}

	@Override
	public void save(User entity) {
		super.save(entity);
	}

	public User findByMail(String email) {

		List<User> result = (List<User>) this.getHibernateTemplate().find("from User u where u.email=?", email);
		if (result.isEmpty()) {

			return null;
			
		}
		else {
			
			return result.get(0);
		}

		
	}

	public User getUniqueByProperty(String paramName, String value) {
		// TODO Auto-generated method stub
//		log.error("paramName"+paramName+"value"+value);
		
		
		return  (User) this.getHibernateTemplate().find("from User u where u.username=?", value).get(0);
	}
}
