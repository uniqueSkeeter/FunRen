package com.fr.station.component.report.service;

import java.util.List;

import com.fr.station.common.bean.report.CardTradeReportBean;

/**
 * 该接口用于获得卡交易明细记录
 * 
 * 
 * @author hjq
 */
public interface CardTradeReportService {

	/**
	 * 获得每条卡交易明细记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardTradeReportBean cardTradeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> findCardTradeRecordsByCriteria(CardTradeReportBean cardTradeBean);

	/**
	 * 获得每条客户缴费明细记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardTradeReportBean cardTradeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> findGuestCreditRecordsByCriteria(CardTradeReportBean cardTradeBean);

	/**
	 * 获得每条预分配明细记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardTradeReportBean cardTradeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> findCardPredistributionRecordsByCriteria(CardTradeReportBean cardTradeBean);

}
