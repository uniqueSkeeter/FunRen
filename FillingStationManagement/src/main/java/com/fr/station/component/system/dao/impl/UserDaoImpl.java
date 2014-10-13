package com.fr.station.component.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fr.station.common.entity.system.OperatorEntity;
import com.fr.station.component.system.dao.AbstractBaseDAO;
import com.fr.station.component.system.dao.UserDAO;
/**
 * 
 * 
 * @author henry
 */
@Repository
public class UserDaoImpl extends AbstractBaseDAO<OperatorEntity> implements UserDAO {

	// ------- Constants (static final) ----------------------------------------
	
	private final String sqlGetByNameAndPass = "from " + this.getTableName() + " where userName = ? and passWord = ?";
	
	private final static String AUTHOR_SQL = "SELECT a.id, a.name, a.upStep, a.step, a.ltree, a.open, a.url FROM RoleFunctionInfoEntity as b, "
			+ " FunctionInfoEntity AS a WHERE b.functionId = a.id and b.roleId = ? and a.useStatus = 1 ORDER BY a.id";
	
	private final static String sqlGetCountNum = "select count(*) from FunctionInfoEntity func where func.upStep = ? and ltree = ?";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	@Override
	public void addUser(OperatorEntity userEntity) {
		this.save(userEntity);
	}

	@Override
	public List<OperatorEntity> getAllUsers() throws Exception {
		return this.findAll();
	}

	@Override
	public void deleteUser(OperatorEntity userEntity) {
		this.delete(userEntity);
	}

	@Override
	public OperatorEntity getUserByCriteria(Object... args) throws Exception {
		List<OperatorEntity> userEntityList = this.findByHql(sqlGetByNameAndPass, args);
		
		OperatorEntity operatorEntity = null;
		if(userEntityList.size() > 0){
			operatorEntity = userEntityList.get(0);
		}
		return operatorEntity;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List getUserAuthor(int roleId) throws Exception {

		List treeList = this.findByHql(AUTHOR_SQL, roleId);

		return treeList;
	}

	@Override
	public long findCountByCriteria(Object... args) throws Exception {
		long count = 0;
		List<?> userEntityList = this.findByHql(sqlGetCountNum,	 args);
		Object[] result = userEntityList.toArray();
		if(result != null){
			return (long)result[0];
		}
		return count;
	}
	
	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	
}
