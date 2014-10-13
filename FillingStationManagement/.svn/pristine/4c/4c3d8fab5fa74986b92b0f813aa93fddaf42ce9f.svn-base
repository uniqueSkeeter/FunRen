package com.fr.station.component.system.dao;

import java.util.List;

import com.fr.station.common.entity.system.OperatorEntity;

/**
 * The interface for the login service .
 * 
 * @trace NH.ICCardManagement.OperatorEntity.Table
 * 
 * @author _wsq
 */
public interface UserDAO {

	/**
	 * save entity into DB.
	 * 
	 * @param OperatorEntity the entity which you want to save the entity in DB.
	 */
	public void addUser(OperatorEntity user);

	/**
	 * find all users from DB.
	 * 
	 * @return return all users
	 */
	public List<OperatorEntity> getAllUsers() throws Exception;

	/**
	 * remove the user in DB.
	 * 
	 * @param OperatorEntity the entity which you want to delete in DB.
	 */
	public void deleteUser(OperatorEntity user);
	
	/**
	 * get the navi menu items for the authority user on the home page and return the role id for another check.
	 * 
	 * @param userName the name from request.
	 * @param passWord the password from request.
	 * @param session the session of sessionAware.
	 * 
	 * @return a value for the particular user.
	 */
	public OperatorEntity getUserByCriteria(Object... args)throws Exception;

	/**
	 * find entity count number from DB using input criteria.
	 * 
	 * @param args which as the search condition.
	 * @throws Exception 
	 */
	public long findCountByCriteria(Object... args) throws Exception;
	
	public List<?> getUserAuthor(int roleId) throws Exception;

}
