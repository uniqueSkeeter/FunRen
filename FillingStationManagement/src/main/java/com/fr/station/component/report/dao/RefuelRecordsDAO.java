package com.fr.station.component.report.dao;

import java.util.List;

import com.fr.station.common.bean.system.OperateLogBean;
import com.fr.station.common.entity.report.OperatelogEntity;


/**
 * The interface for get Gas trading records .
 * 
 * @trace FR.ICCardManagement.OperatorLogEntity.Table
 * 
 * @author _wsq
 */
public interface RefuelRecordsDAO {

	/**
	 * get the navi menu items for the authority user on the home page and return the role id for another check.
	 * 
	 * @param userName the name from request.
	 * @param passWord the password from request.
	 * @param session the session of sessionAware.
	 * 
	 * @return a value for the particular user.
	 */	
	public List<OperatelogEntity> getAllGasRecords(OperateLogBean operateLogBean) throws Exception;

	/**
	 * get the navi menu items for the authority user on the home page and return the role id for another check.
	 * 
	 * @param userName the name from request.
	 * @param passWord the password from request.
	 * @param session the session of sessionAware.
	 * 
	 * @return a value for the particular user.
	 */	
	public List<OperateLogBean> getGasRecordsByCriteria(OperateLogBean operateLogBean, Object... args);
	
}
