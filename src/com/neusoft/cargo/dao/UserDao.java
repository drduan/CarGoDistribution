package com.neusoft.cargo.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.User;

@Repository("UserDao")
public class UserDao  extends AbstractHibernateDAO< User >{

	
	private static final Log log = LogFactory.getLog(UserDao.class);
	// property constants
	public static final String OPENING_BALENCE = "openingBalence";
	public static final String RECEIVE = "receive";
	public static final String TRANSFER = "transfer";
	public static final String TRANSFER_TO_COMMENT = "transferToComment";
	public static final String DAY_BRAND_RATE = "dayBrandRate";
	public static final String CLOSING_BALANCE = "closingBalance";
	public static final String LAST_UPDATE_USE_ID = "lastUpdateUseId";
	
	
	
	public UserDao(){
	      setClazz(User.class );
	   }
	
	@Override
	public void save(User entity) {
		super.save(entity);
	}
	
	
	public User findByName(String name)
	{
		
		String hql= "from bean.User u where u.name=? and u.password=?";
            return   (User) getHibernateTemplate().find(hql, new String[]{null,name});
		// this.getHibernateTemplate().
//		return getCurrentSession().find(User, name)
//		public T findOne(final long id) {
//			return (T) getCurrentSession().get(clazz, id);
//		}

//		return null;
	}
}
