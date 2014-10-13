package com.fr.station.component.report.service;

import java.util.List;

import com.fr.station.common.bean.report.EmployeeBean;
import com.fr.station.common.bean.system.OperateLogBean;
import com.fr.station.common.entity.report.OperatelogEntity;

/**
 * The interface for get Gas trading records .
 * 
 * @trace FR.ICCardManagement.OperatorLogEntity.Table
 * 
 * @author _wsq
 */
public interface RefuelRecordsService {

	/**
	 * get all operatelogEntity data from db.
	 * 
	 * 
	 * @return return the list of OperatelogEntity.
	 */	
	public List<OperatelogEntity> findAllGasRecords(EmployeeBean employeeBean) throws Exception;

	/**
	 * get all operatelogEntity data from db by input criteria.
	 * 
	 * @param the parameter of dataCenter page 
	 * @return return the list of OperatelogEntity.
	 */	
	public List<OperateLogBean> findGasRecordsByCriteria(OperateLogBean operateLogBean, Object... args);
	
}
