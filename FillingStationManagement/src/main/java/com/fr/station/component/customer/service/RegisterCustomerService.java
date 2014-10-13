package com.fr.station.component.customer.service;

import java.util.List;

import com.fr.station.common.bean.customer.RegisterCustomerBean;

/**
 * The interface for get registerCustomer records .
 * 
 * @author WR
 */
public interface RegisterCustomerService {

	/**
	 * get each registerCustomer records in order to display in the diaplayRegisterCustomer.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> findRegisterCustomerRecordsByCriteria(RegisterCustomerBean registerCustomerBean);

	/**
	 * save card info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input of user in dialog
	 * 
	 * @return return void
	 */
	public void addCardInfo(RegisterCustomerBean registerCustomerBean);

}
