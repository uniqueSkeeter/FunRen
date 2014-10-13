package com.fr.station.component.report.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fr.station.common.bean.report.ClassChangeBean;

/**
 * 该接口用于获得班结记录
 * 
 * 
 * @author hjq
 */
public interface ShiftChangeReportService {

	/**
	 * 获得每条班结记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<ClassChangeBean> findClassRecordsByCriteria(ClassChangeBean classChangeBean);

	/**
	 * 获得每条卡片库存明细记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<ClassChangeBean> findCardStorageRecordsByCriteria(ClassChangeBean classChangeBean);

	/**
	 * 获得每条网点交易明细记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<ClassChangeBean> findStationTradeRecordsByCriteria(ClassChangeBean classChangeBean);

	/**
	 * 获得每条发票明细记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<ClassChangeBean> findInvoiceRecordsByCriteria(ClassChangeBean classChangeBean);

	/**
	 * 获得班结汇总记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public ClassChangeBean findClassSummaryByCriteria(ClassChangeBean classChangeBean);

	/**
	 * get each card trade records in order to display in the jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param ClassChangeBean classChangeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public HSSFWorkbook generateShiftChangeExcel(ClassChangeBean classChangeBean);

}
