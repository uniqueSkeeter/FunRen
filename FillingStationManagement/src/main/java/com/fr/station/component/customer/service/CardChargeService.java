package com.fr.station.component.customer.service;

import java.util.List;

import com.fr.station.common.bean.customer.CardChargeBean;

public interface CardChargeService {

	/**
	 * get each cardAccount records in order to display in the diaplayCardChargeList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param cardChargeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardChargeBean> findCardAccountRecordsByCriteria(CardChargeBean cardChargeBean);

	/**
	 * save cardCharge info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param cardChargeBean include the input of user in dialog
	 * 
	 * @return return void
	 */
	public void addCardChargeInfo(CardChargeBean cardChargeBean);

}
