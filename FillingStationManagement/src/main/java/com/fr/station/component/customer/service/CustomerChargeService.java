package com.fr.station.component.customer.service;

import java.util.List;

import com.fr.station.common.bean.customer.CustomerChargeBean;

public interface CustomerChargeService {

	/**
	 * get customer Account records in order to display in the displayCustomerDepositCharge.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerChargeBean> findCustomAccountRecordsByCriteria(CustomerChargeBean customerChargeBean);

	/**
	 * save customer charge info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the input of user in dialog
	 * 
	 * @return return void
	 */
	public void addCustomChargeInfo(CustomerChargeBean customerChargeBean);
}
