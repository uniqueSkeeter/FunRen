package com.fr.station.component.report.dao;

import java.util.List;

import com.fr.station.common.bean.report.ShiftChangeBean;
import com.fr.station.common.bean.system.ReportTypeEnum;


/**
 * The interface for get Gas trading records .
 * 
 * @trace FR.ICCardManagement.OperatorLogEntity.Table
 * 
 * @author _wsq
 */
public interface RefuelDiagramDAO {

	/**
	 * get total records in order to display in the jsp page.
	 * 
	 * @param shiftChangeBean shiftChangeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */	
	public List<ShiftChangeBean> getTotalOilRecordsForReport(ShiftChangeBean shiftChangeBean, ReportTypeEnum reportType) throws Exception;

}
