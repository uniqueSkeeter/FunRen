package com.fr.station.component.system.service;

import java.util.List;
import java.util.Map;

import com.fr.station.common.entity.system.OperatorEntity;
import com.fr.station.component.system.exception.EmployeeException;

/**
 * The interface for the login service .
 *
 * @trace NH.ICCardManagement.OperatorEntity.Table
 *
 * @author _wsq
 */
public interface UserService extends BaseService<OperatorEntity> {

	public void addUser(OperatorEntity employee);

	public void deleteUser(OperatorEntity userEntity);

	public List<OperatorEntity> getAllUsers();

	/**
	 * get the top menu items for the authority user on the home page and return the role id for another check.
	 *
	 * @param userName the name from request.
	 * @param passWord the password from request.
	 * @param passWord the session of sessionAware.
	 *
	 * @return a value for the particular user.
	 * @throws EmployeeException
	 * @throws Exception
	 */
	public int getUserRoleByCriteria(String userName, String passWord, Map<String, Object> session,
			Map<String, Object> application) throws EmployeeException, Exception;

	public void getUserAuthor(int roleId);

}
