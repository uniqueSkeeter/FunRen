package com.fr.station.component.customer.dao;

import java.util.List;

import com.fr.station.common.bean.customer.RegisterCustomerBean;

/**
 * The interface for get registerCustomer registerCustomer records;save card info; get driver records
 * 
 * @author WR
 */
public interface RegisterCustomerDAO {

	/**
	 * get each registerCustomer records in order to display in the displayRegisterCustomer.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param RegisterCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> getRegisterCustomerRecordsByCriteria(RegisterCustomerBean registerCustomerBean,
			int startPage, int number);

	/**
	 * get guestNo
	 * 
	 * @return return Integer
	 */
	public Integer getGuestNo();

	/**
	 * get seriaNum
	 * 
	 * @return return Integer
	 */
	public Integer getSeriaNum();

	/**
	 * update guestNo
	 * 
	 */
	public void updateGuestNo();

	/**
	 * update seriaNum
	 * 
	 */
	public void updateSeriaNum();

	/**
	 * get the latest class number
	 * 
	 */
	public Object[] getClassNum();
}
