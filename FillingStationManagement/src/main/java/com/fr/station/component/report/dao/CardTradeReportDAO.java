package com.fr.station.component.report.dao;

import java.util.List;

import com.fr.station.common.bean.report.CardTradeReportBean;

public interface CardTradeReportDAO {

	/**
	 * get each card trade records in order to display in the jsp page.
	 *
	 * @param args which is retrieved in the input jsp page
	 * @param ClassChangeBean classChangeBean include the search criteria.
	 *
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> getCardTradeRecordsByCriteria(CardTradeReportBean cardTradeBean);

	/**
	 * get each guest credit records in order to display in the jsp page.
	 *
	 * @param args which is retrieved in the input jsp page
	 * @param ClassChangeBean classChangeBean include the search criteria.
	 *
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> getGuestCreditRecordsByCriteria(CardTradeReportBean cardTradeBean);

	/**
	 * get each card predistribution records in order to display in the jsp page.
	 *
	 * @param args which is retrieved in the input jsp page
	 * @param ClassChangeBean classChangeBean include the search criteria.
	 *
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> getCardPredistributionRecordsByCriteria(CardTradeReportBean cardTradeBean);

}
