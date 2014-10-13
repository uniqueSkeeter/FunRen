package com.fr.station.component.customer.dao;

import java.util.List;

import com.fr.station.common.bean.customer.CustomerChargeBean;
import com.fr.station.common.entity.card.FKTGuestAcc;

public interface CustomerChargeDAO {

	/**
	 * get cardAccount record in order to display in the displayCardChargeList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardChargeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerChargeBean> getCustomAccountRecordsByCriteria(CustomerChargeBean customerChargeBean);

	/**
	 * update guestAcc table after deposit charge
	 * 
	 * @return return void
	 */
	public void updateGuestAccEntity(FKTGuestAcc guestAccEntity);

	/**
	 * get tradeNo
	 * 
	 * @return return Integer
	 */
	public Integer getTradeNo();

	/**
	 * update tradeNo
	 * 
	 * @return return void
	 */
	public void updateTradeNo();

}
