package com.fr.station.component.customer.dao;

import java.util.List;

import com.fr.station.common.bean.customer.RegisterCustomerBean;

public interface RegistMultiCustomerDAO {

	/**
	 * get each driver records in order to display in the saleMultiUserCard.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getDriverRecordsByCriteria(RegisterCustomerBean registerCustomerBean, int startPage,
			int number);

	/**
	 * get each department records in order to display in the departmentMaintain.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getDepRecordsByCriteria(RegisterCustomerBean registerCustomerBean, int startPage,
			int number);

	/**
	 * get department records in order to display in the departmentAdd.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getAllDepartment(RegisterCustomerBean registerCustomerBean);

	/**
	 * 获得当前单位的客户编号
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getCorpGuestNo(RegisterCustomerBean registerCustomerBean);

	/**
	 * 获得当前司机对应的单位的客户编号和部门信息
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getGuestNoAndDepNo(RegisterCustomerBean registerCustomerBean);

	/**
	 * 获得当前司机的部门编号
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getDepNo(RegisterCustomerBean registerCustomerBean);

	/**
	 * get depNo
	 * 
	 * @return return Integer
	 */
	public Integer getDepNo();

	/**
	 * update depNo
	 * 
	 * @return void
	 */
	public void updateDepNo();

	/**
	 * change driver depNo
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * @return void
	 */
	public void changeDriverDepNo(RegisterCustomerBean registerCustomerBean);
}
