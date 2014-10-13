package com.fr.station.component.customer.dao;

import java.util.List;

import com.fr.station.common.bean.customer.CardChargeBean;
import com.fr.station.common.entity.card.FKTCardTZEntity;

public interface CardChargeDAO {

	/**
	 * get cardAccount record in order to display in the displayCardChargeList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardChargeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardChargeBean> getCardAccountRecordsByCriteria(CardChargeBean cardChargeBean);

	/**
	 * update cardTZ table after charge
	 */
	public void updateCardAccEntity(FKTCardTZEntity cardAccEntity);

	/**
	 * get cardTradeNo
	 * 
	 * @return return Integer
	 */
	public Integer getCardTradeNo();

	/**
	 * update cardTradeNo
	 * 
	 * @return return void
	 */
	public void updateCardTradeNo();

}
