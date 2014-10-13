package com.fr.station.component.report.dao;

import java.util.List;

import com.fr.station.common.bean.report.CardTradeReportBean;

public interface ExportShiftChangeDataDAO {

	/**
	 * get each card trade records in order to display in the jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param ClassChangeBean classChangeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardTradeReportBean> generateShiftChangeExcel(CardTradeReportBean cardTradeBean, int startPage, int number);

}
