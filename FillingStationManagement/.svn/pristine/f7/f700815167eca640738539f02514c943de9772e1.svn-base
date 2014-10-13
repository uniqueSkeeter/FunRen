package com.fr.station.component.report.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.report.ShiftChangeBean;
import com.fr.station.common.bean.system.ReportTypeEnum;
import com.fr.station.common.consts.SqlConsts;
import com.fr.station.common.entity.report.OperatelogEntity;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.report.dao.RefuelDiagramDAO;
import com.fr.station.component.system.dao.AbstractBaseDAO;

/**
 * The action for dashboard. It handles the user request from the web sites.
 * Mainly responsible to handle user login
 * 
 * @author _wsq
 */
@Repository
public class RefuelDiagramDaoImpl extends AbstractBaseDAO<OperatelogEntity> implements RefuelDiagramDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(RefuelDiagramDaoImpl.class);

	private static final String EXCHANGE_DATE = "AccDate";
	private static final String STATION_NUM = "stationNO";
	private static final String OIL_Code = "oilCode";
	
	// ------- Static Variables (static) ---------------------------------------
	
	// ------- Instance Variables (private) ------------------------------------
	
	private String selectTotalRecordsByDay = SqlConsts.SELECT + "SUM(ckd.CKSL) totalNum, ckd.AccDate, ckd.OilName FROM [FRCENTER].[dbo].[T_T_CKD] ckd WHERE ";
	
	private String selectTotalRecordsByMonth = SqlConsts.SELECT + "SUM(ckd.CKSL) totalNum, YEAR (ckd.AccDate) * 100 + MONTH (ckd.AccDate), ckd.OilName FROM [FRCENTER].[dbo].[T_T_CKD] ckd WHERE ";
	
	// ------- Constructors ----------------------------------------------------
	
	public RefuelDiagramDaoImpl() {
		super();
	}

	/**
	 *  inherited java doc.
	 */
	@Override
	public List<ShiftChangeBean> getTotalOilRecordsForReport(ShiftChangeBean shiftChangeBean, ReportTypeEnum reportType) {
		StringBuilder builder = new StringBuilder();
		switch(reportType){
			case DAY_REPORT:
				builder.append(selectTotalRecordsByDay);
				this.validateInputCriteria(builder, shiftChangeBean);
				builder.append(" GROUP BY ").append("ckd.AccDate, ckd.OilName").append(" ORDER BY ckd.AccDate ");
				break;
			case MONTH_REPORT:
				builder.append(selectTotalRecordsByMonth);
				this.validateInputCriteria(builder, shiftChangeBean);
				builder.append(" GROUP BY ").append("ckd.OilName, DATEPART(mm, ckd.AccDate), YEAR (ckd.AccDate) * 100 + MONTH (ckd.AccDate)")
				.append(" ORDER BY ").append("YEAR (ckd.AccDate) * 100 + MONTH (ckd.AccDate), DATEPART(mm, ckd.AccDate)");
				break;
			default :
				break;
		}
		return generateDayMonthReport(shiftChangeBean, builder, reportType);
	}

	@SuppressWarnings("unchecked")
	private List<ShiftChangeBean> generateDayMonthReport(ShiftChangeBean shiftChangeBean, StringBuilder builder,
			ReportTypeEnum reportType) {
		List<ShiftChangeBean> resultList = new ArrayList<ShiftChangeBean>();
		try {
			List<Object[]> result = (List<Object[]>) this.findBySql(builder.toString());
			resultList = convertDataToBean(result, reportType);
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" +
					e.getMessage() + "\n" + ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" +
					e.getMessage() + "\n" + ErrorLogUtil.printInfo(e));
		}
		return resultList;
	}

	// ------- Instance Methods (public) ---------------------------------------
	
	// ------- Instance Methods (protected) ------------------------------------

	private void validateInputCriteria(StringBuilder builder, ShiftChangeBean shiftChangeBean) {

		String sdate = DateUtil.formatDate(shiftChangeBean.getStartDate(), DateUtil.DATE_PATTERN_17);
		String edate = DateUtil.formatDate(shiftChangeBean.getEndDate(), DateUtil.DATE_PATTERN_17);
		builder.append("ckd.");
		builder.append(EXCHANGE_DATE).append(" >= ").append("'" + sdate + "'").append(" AND ckd.");
		builder.append(EXCHANGE_DATE).append(" <= ").append("dateadd(day,1,'" + edate + "')");
		
		if(StringUtils.isNotEmpty(shiftChangeBean.getStationNum()) && StringUtils.isNotBlank(shiftChangeBean.getStationNum())){
			builder.append(" AND ckd.").append(STATION_NUM).append(" = ").append(shiftChangeBean.getStationNum());
		}
		if(StringUtils.isNotEmpty(shiftChangeBean.getOilCode())){
			builder.append(" AND ckd.").append(OIL_Code).append(" = ").append(shiftChangeBean.getOilCode());
		}
	}
	
	private List<ShiftChangeBean> convertDataToBean(List<Object[]> dataResult, ReportTypeEnum reportType){
		List<ShiftChangeBean> shiftChangeBeanList = new ArrayList<ShiftChangeBean>();
		switch(reportType){
			case DAY_REPORT:
				this.createDayReportBean(dataResult, shiftChangeBeanList);
				break;
			case MONTH_REPORT:
				this.createMonthReportBean(dataResult, shiftChangeBeanList);
				break;
			default :
				break;
		}
		return shiftChangeBeanList;
	}

	private void createDayReportBean(List<Object[]> dataResult, List<ShiftChangeBean> shiftChangeBeanList) {
		ShiftChangeBean shiftChangeBean = null;
		for(Object[] dataRow : dataResult){
			shiftChangeBean = new ShiftChangeBean();
			shiftChangeBean.setTotalNum((BigDecimal)dataRow[0]);
			shiftChangeBean.setTradeDate((Date)(dataRow[1]));
			shiftChangeBean.setOilName(String.valueOf(dataRow[2]));
			shiftChangeBeanList.add(shiftChangeBean);
		}
	}
	
	private void createMonthReportBean(List<Object[]> dataResult, List<ShiftChangeBean> shiftChangeBeanList) {
		ShiftChangeBean shiftChangeBean = null;
		for(Object[] dataRow : dataResult){
			shiftChangeBean = new ShiftChangeBean();
			shiftChangeBean.setTotalNum((BigDecimal)dataRow[0]);
			shiftChangeBean.setDisplayDate(DateUtil.formatDateYYMM((String.valueOf(dataRow[1].toString()))));
			shiftChangeBean.setOilName(String.valueOf(dataRow[2]));
			shiftChangeBeanList.add(shiftChangeBean);
		}
	}
	
	

}
