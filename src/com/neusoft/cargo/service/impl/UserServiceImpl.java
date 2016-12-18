package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;

public class UserServiceImpl implements UserService {
	   private EntityManager em;
	   
	    @PersistenceContext
	    public void setEntityManager(EntityManager em) {
	        this.em = em;
	    }
	 
	    @SuppressWarnings("unchecked")
	    public List<User> findAll() {
	        Query query = getEntityManager().createQuery("select p FROM Person p");
	        return query.getResultList();
	    }
	 
	    public void save(User person) {
	        if (person.getId() == null) {
	            // new
	            em.persist(person);
	        } else {
	            // update
	            em.merge(person);
	        }
	    }
	 
	    public void remove(int id) {
	    	User person = find(id);
	        if (person != null) {
	            em.remove(person);
	        }
	    }
	 
	    private EntityManager getEntityManager() {
	        return em;
	    }
	 
	    public User find(int id) {
	        return em.find(User.class, id);
	    }
}
