package com.fr.station.component.system.service;

import java.util.List;

import com.fr.station.common.bean.report.EmployeeBean;
import com.fr.station.common.entity.system.EmployeeEntity;

public interface EmployeeService extends BaseService<EmployeeEntity>{
	
	public void addEmployee(EmployeeBean employeeBean);

	public List<EmployeeEntity> getAllEmployees() throws Exception;
	
	public List<EmployeeBean> getEmplByFormCondition(EmployeeBean employeeBean) throws Exception;

	public void deleteEmployee(Integer employeeId);
	
	public void updateEmployee(EmployeeBean employeeBean, Object... args);
	
	
}
