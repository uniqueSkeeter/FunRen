package com.fr.station.component.report.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.report.ClassChangeBean;
import com.fr.station.common.consts.SqlConsts;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.report.ClassInfoEntity;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.report.dao.ClassChangeDAO;
import com.fr.station.component.system.dao.AbstractBaseDAO;

/**
 * The action for dashboard. It handles the user request from the web sites. Mainly responsible to handle user login
 * 
 * @author hjq
 */
@Repository
public class ClassChangeDaoImpl extends AbstractBaseDAO<ClassInfoEntity> implements ClassChangeDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(ClassChangeDaoImpl.class);

	private static final String ID = "id";

	private static final String CLASS_STATUS = "class_status";

	private static final String WORK_DATE = "create_date";

	private static final String STATION_NO = "stationNo";

	private static final String ACCNO = "accno";

	private static final String GUEST_ACC_NO = "card.accno";

	private static final String GUEST_STATION_NO = "card.stationNo";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// 班结查询
	private final String selectClassRecordsSql = "select CONVERT(varchar(19), create_date, 21) create_date,CONVERT(varchar(19), update_date, 21) update_date,class_no,class_status,userid,id from CLASS_INFO WHERE ";

	private final String selectAllCountClassRecordsSql = "select count(*) from CLASS_INFO WHERE ";

	// 卡片出入库明细查询
	private final String selectCardStorageRecordsSql = "select cardtype,insum,outsum,chsum,cardsum,CONVERT(varchar(19), workdate, 21) workdate,CONVERT(varchar(19), accdate, 21) accdate,userid from FK_T_StorageTZ WHERE ";

	private final String selectAllCountCardStorageRecordsSql = "select count(*) from FK_T_StorageTZ WHERE ";

	// 网点交易明细查询
	private final String selectStationTradeRecordsSql = "select guestname,guestno,incno,inctype,zffs,amn,userid, CONVERT(varchar(19), workdate, 21) workdate, CONVERT(varchar(19), accdate, 21) accdate from FK_TT_GUESTCREDIT WHERE ";

	private final String selectAllCountStationTradeRecordsSql = "select count(*) from FK_TT_GUESTCREDIT WHERE ";

	// 发票明细查询

	private final String selectInvoiceRecordsSql = "select fp_code, start_code, end_code, fp_no, fp_zs, kpje, kpzs, CONVERT(varchar(19), workdate, 21) workdate from C_T_InvoiceInfo WHERE ";

	private final String selectAllCountInvoiceRecordsSql = "select count(*) from C_T_InvoiceInfo WHERE ";

	// 查询班结汇总（包括班结信息，交易统计，发票统计

	private final String selectClassSummarySql = "select classinfo.create_date,classinfo.update_date,classinfo.class_no,classinfo.class_status,classinfo.userid,"
			+ "cashtotal.cashamount,cardtotal.cardamount,chequetotal.chequeamount,returntotal.returnamount,recvforegift.recvamount,returnforegift.returnDepositAmount,"
			+ "invoiceinfo.invoiceamount,invoiceinfo.invoicecount from";

	// 查询班次信息

	private final String selectClassInfoSql = "(select CONVERT(varchar(19), create_date, 21) create_date,CONVERT(varchar(19), update_date, 21) update_date,class_no,class_status,userid,id from CLASS_INFO WHERE  ";

	// 查询现金充值总额
	private final String selectCashTotalSql = "(select sum(amn) as cashamount from FK_TT_GUESTCREDIT where zffs='11' AND inctype='0' AND ";

	// 查询银行卡充值总额
	private final String selectCardTotalSql = "(select sum(amn) as cardamount from FK_TT_GUESTCREDIT where zffs='12' AND inctype='0' AND ";

	// 查询支票充值总额
	private final String selectChequeTotalSql = "(select sum(amn) as chequeamount from FK_TT_GUESTCREDIT where zffs='13' AND inctype='0' AND ";

	// 查询小胡退款总额
	private final String selectReturnTotalSql = "(select sum(amn) as returnamount from FK_TT_GUESTCREDIT where inctype='1' AND ";

	// 查询押金收入总额
	private final String selectRecvForegiftSql = "(select sum(card.deposit) as recvamount from FK_TT_GUESTCREDIT guest, FK_T_CARD card where card.accno = guest.accno AND guest.inctype = '3' AND ";

	// 查询押金退还总额
	private final String selectReturnForegiftSql = "(select sum(card.deposit) as returnDepositAmount from FK_TT_GUESTCREDIT guest, FK_T_CARD card where card.accno = guest.accno AND guest.inctype = '1' AND ";

	// 查询发票统计信息
	private final String selectInvoiceInfoSql = "(select sum(kpje) as invoiceamount, sum(kpzs) as invoicecount from C_T_InvoiceInfo where ";

	// 查询卡库存信息
	private final String selectCardInfoSql = "select cardtype,sum(cardsum) as cardsum ,sum(insum) as insum ,sum(outsum) as outsum ,sum(chsum) as chsum ,count(*) as tradecount from FK_T_StorageTZ where ";

	// ------- Constructors ----------------------------------------------------
	public ClassChangeDaoImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------
	/*
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassChangeBean> getClassRecordsByCriteria(ClassChangeBean classChangeBean) {
		List<ClassChangeBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputCriteria(classChangeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectClassRecordsSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder, this.selectAllCountClassRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(classChangeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBean(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;

	}

	/*
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassChangeBean> getCardStorageRecordsByCriteria(ClassChangeBean classChangeBean) {
		List<ClassChangeBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputCriteria(classChangeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectCardStorageRecordsSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder, this.selectAllCountCardStorageRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(classChangeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBeanForCardAccount(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;

	}

	/*
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassChangeBean> getStationTradeRecordsByCriteria(ClassChangeBean classChangeBean) {
		List<ClassChangeBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputCriteria(classChangeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectStationTradeRecordsSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder, this.selectAllCountStationTradeRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(classChangeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBeanForStationTrade(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;

	}

	/*
	 * {@inheritDoc}
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassChangeBean> getInvoiceRecordsByCriteria(ClassChangeBean classChangeBean) {
		List<ClassChangeBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputCriteria(classChangeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectInvoiceRecordsSql);

			// get total records by specified sql.selectAllCountInvoiceRecordsSql
			int totalSize = this.getTotalCount(builder, this.selectAllCountInvoiceRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(classChangeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBeanForInvoice(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;

	}

	/*
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ClassChangeBean getClassSummaryRecordsByCriteria(ClassChangeBean classChangeBean) {
		List<ClassChangeBean> resultList = null;
		StringBuilder builderForSummary = new StringBuilder();
		this.buildShiftChangeSummarySql(classChangeBean, builderForSummary);
		try {
			// 查询班次信息 ，交易统计信息，发票统计信息
			Query query = this.getQueryByCriteria(builderForSummary.toString());
			List<Object[]> result = query.list();
			resultList = this.convertDataToBeanForClassSummary(result);
			// 构建查询卡片出入库丝逆袭的sql语句
			StringBuilder condition = this.validateInputCriteria(classChangeBean);

			StringBuilder builderForCardSummary = this.buildCardDetailSql(condition);
			// 查询卡片出入库信息
			Query queryForCardSummary = this.getQueryByCriteria(builderForCardSummary.toString());
			List<Object[]> cardResult = queryForCardSummary.list();
			if (resultList != null && resultList.size() > 0) {
				this.converDataToBeanForCardSummary(cardResult, resultList.get(0));
			} else {
				return null;
			}
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList.get(0);
	}

	private StringBuilder buildCardDetailSql(StringBuilder condition) {
		StringBuilder builderForCardSummary = new StringBuilder();
		builderForCardSummary.append(this.selectCardInfoSql);
		builderForCardSummary.append(condition);
		builderForCardSummary.append("\n group by cardtype");
		return builderForCardSummary;
	}

	private void buildShiftChangeSummarySql(ClassChangeBean classChangeBean, StringBuilder selectSummarySql) {
		selectSummarySql.append(this.selectClassSummarySql);
		selectSummarySql.append(this.selectClassInfoSql);
		StringBuilder builder = this.validateInputCriteria(classChangeBean);
		selectSummarySql.append("class_no=" + classChangeBean.getClassNo());
		selectSummarySql.append(")classinfo,");
		selectSummarySql.append(this.selectCashTotalSql);
		selectSummarySql.append(builder);
		selectSummarySql.append(" )cashtotal,");
		selectSummarySql.append(this.selectCardTotalSql);
		selectSummarySql.append(builder);
		selectSummarySql.append(")cardtotal,");
		selectSummarySql.append(this.selectChequeTotalSql);
		selectSummarySql.append(builder);
		selectSummarySql.append(")chequetotal,");
		selectSummarySql.append(this.selectReturnTotalSql);
		selectSummarySql.append(builder);
		selectSummarySql.append(")returntotal,");
		selectSummarySql.append(this.selectRecvForegiftSql);
		StringBuilder criteria = this.validate(classChangeBean);
		selectSummarySql.append(criteria);
		// builderForClassSummary.append(builder);
		selectSummarySql.append(")recvforegift,");
		selectSummarySql.append(this.selectReturnForegiftSql);
		// builderForClassSummary.append(builder);
		selectSummarySql.append(criteria);
		selectSummarySql.append(")returnforegift,");
		selectSummarySql.append(this.selectInvoiceInfoSql);
		selectSummarySql.append(builder);
		selectSummarySql.append(")invoiceinfo");
		/*
		 * selectSummarySql .append(
		 * "\n where classinfo.class_no = cashtotal.accno AND cashtotal.accno = cardtotal.accno AND cardtotal.accno = chequetotal.accno AND chequetotal.accno = returntotal.accno AND returntotal.accno = recvforegift.classno  AND recvforegift.classno = returnforegift.classno AND returnforegift.classno = invoiceinfo.accno"
		 * );
		 */
	}

	private void converDataToBeanForCardSummary(List<Object[]> dataResult, ClassChangeBean classChangeBean) {
		// TODO Auto-generated method stub
		ClassChangeBean classChangeBeanList = null;
		for (Object[] dataRow : dataResult) {
			classChangeBeanList = new ClassChangeBean();
			classChangeBeanList.setCardType(String.valueOf(dataRow[0]));
			classChangeBeanList.setCardQuantityBegin(Integer.valueOf(String.valueOf(dataRow[1]))
					- Integer.valueOf(String.valueOf(dataRow[2])) + Integer.valueOf(String.valueOf(dataRow[3]))
					- Integer.valueOf(String.valueOf(dataRow[4])));
			classChangeBeanList.setCardQuantityEnd(Integer.valueOf(String.valueOf(dataRow[1])));
			classChangeBeanList.setCardQuantity(classChangeBeanList.getCardQuantityEnd()
					- classChangeBeanList.getCardQuantityBegin());
			classChangeBeanList.setTradeCount(Integer.valueOf(String.valueOf(dataRow[5])));
			classChangeBean.addCardStorageList(classChangeBeanList);
		}
	}

	private List<ClassChangeBean> convertDataToBeanForClassSummary(List<Object[]> dataResult) {
		// TODO Auto-generated method stub
		List<ClassChangeBean> classChangeBeanList = new ArrayList<ClassChangeBean>();
		ClassChangeBean classChangeBean = null;
		for (Object[] dataRow : dataResult) {
			classChangeBean = new ClassChangeBean();
			classChangeBean.setWorkDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[0])));
			classChangeBean.setStartTime(DateUtil.formatDateYYYY_MM_DD_HH_MM((String) (dataRow[0])));
			classChangeBean.setEndTime(DateUtil.formatDateYYYY_MM_DD_HH_MM((String) (dataRow[1])));
			classChangeBean.setClassNo(String.valueOf(dataRow[2]));
			classChangeBean.setClassStatus(String.valueOf(dataRow[3]));
			classChangeBean.setUserId(Integer.valueOf(String.valueOf(dataRow[4])));
			if (dataRow[5] == null) {
				classChangeBean.setChargeFromCash(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[5])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setChargeFromCash(bigDecimal);
			}
			if (dataRow[6] == null) {
				classChangeBean.setChargeFromICCard(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[6])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setChargeFromICCard(bigDecimal);
			}
			if (dataRow[7] == null) {
				classChangeBean.setChargeFromCheque(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[7])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setChargeFromCheque(bigDecimal);
			}
			if (dataRow[8] == null) {
				classChangeBean.setReturnAmount(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[8])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setReturnAmount(bigDecimal);
			}
			if (dataRow[9] == null) {
				classChangeBean.setReceiveForegiftAmount(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[9])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setReceiveForegiftAmount(bigDecimal);

			}
			if (dataRow[10] == null) {
				classChangeBean.setReturnForegiftAmount(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[10])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setReturnForegiftAmount(bigDecimal);

			}
			if (dataRow[11] == null) {
				classChangeBean.setInvoiceTotalAmount(BigDecimal.valueOf(Double.valueOf(0)));
			} else {
				BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[11])));
				bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				classChangeBean.setInvoiceTotalAmount(bigDecimal);

			}
			if (dataRow[12] == null) {
				classChangeBean.setInvoiceTotalCount(0);
			} else {
				classChangeBean.setInvoiceTotalCount(Integer.valueOf(String.valueOf(dataRow[12])));
			}
			BigDecimal totalMoney = classChangeBean.getChargeFromCash().add(classChangeBean.getChargeFromICCard())
					.add(classChangeBean.getChargeFromCheque()).subtract(classChangeBean.getReturnAmount())
					.add(classChangeBean.getReceiveForegiftAmount()).subtract(classChangeBean.getReturnForegiftAmount());
			classChangeBean.setTotalMoney(totalMoney);
			classChangeBeanList.add(classChangeBean);
		}
		return classChangeBeanList;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------
	private StringBuilder validate(ClassChangeBean classChangeBean) {
		StringBuilder builder = new StringBuilder();
		if (classChangeBean.getClassNo() != null) {
			builder.append(GUEST_ACC_NO).append(SqlConsts.EQUAL).append(classChangeBean.getClassNo());
		}
		if (StringUtils.isNotEmpty(ApplicationContext.getInstance().getStationNum())) {
			builder.append(SqlConsts.ADD).append(GUEST_STATION_NO).append(SqlConsts.EQUAL)
					.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		}
		return builder;

	}

	private StringBuilder validateInputCriteria(ClassChangeBean classChangeBean) {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(ApplicationContext.getInstance().getStationNum())) {
			builder.append(STATION_NO).append(SqlConsts.EQUAL)
					.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		}
		if (classChangeBean.getClassNo() != null) {
			builder.append(SqlConsts.ADD).append(ACCNO).append(SqlConsts.EQUAL).append(classChangeBean.getClassNo());
		}
		if (classChangeBean.getId() != null) {
			builder.append(ID).append(SqlConsts.EQUAL).append(classChangeBean.getId());
		}
		if (classChangeBean.getStartDate() != null && classChangeBean.getEndDate() != null) {
			String startDate = DateUtil.formatDate(classChangeBean.getStartDate(), DateUtil.DATE_PATTERN_8);
			String endDate = DateUtil.formatDate(classChangeBean.getEndDate(), DateUtil.DATE_PATTERN_8);
			builder.append(SqlConsts.ADD).append(WORK_DATE).append(SqlConsts.BETWEEN).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES).append(SqlConsts.ADD).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (classChangeBean.getStartDate() != null && classChangeBean.getEndDate() == null) {
			String startDate = DateUtil.formatDate(classChangeBean.getStartDate(), DateUtil.DATE_PATTERN_8);
			builder.append(SqlConsts.ADD).append(WORK_DATE).append(SqlConsts.GE).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (classChangeBean.getStartDate() == null && classChangeBean.getEndDate() != null) {
			String endDate = DateUtil.formatDate(classChangeBean.getEndDate(), DateUtil.DATE_PATTERN_8);
			endDate = DateUtil.addDaysPatternEight(endDate, 1);
			builder.append(SqlConsts.ADD).append(WORK_DATE).append(SqlConsts.LT).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtils.isNotEmpty(classChangeBean.getClassStatus())) {
			builder.append(SqlConsts.ADD).append(CLASS_STATUS).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(classChangeBean.getClassStatus()).append(SqlConsts.SINGLE_QUOTES);
		}

		return builder;
	}

	private List<ClassChangeBean> convertDataToBean(List<Object[]> dataResult, int totalAccount) {
		// TODO Auto-generated method stub
		List<ClassChangeBean> classChangeBeanList = new ArrayList<ClassChangeBean>();
		ClassChangeBean classChangeBean = null;
		for (Object[] dataRow : dataResult) {
			classChangeBean = new ClassChangeBean();
			classChangeBean.setWorkDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[0])));
			classChangeBean.setStartTime(DateUtil.formatDateYYYY_MM_DD_HH_MM((String) (dataRow[0])));
			classChangeBean.setEndTime(DateUtil.formatDateYYYY_MM_DD_HH_MM((String) (dataRow[1])));
			classChangeBean.setClassNo(String.valueOf(dataRow[2]));
			classChangeBean.setClassStatus(String.valueOf(dataRow[3]));
			classChangeBean.setUserId(Integer.valueOf(String.valueOf(dataRow[4])));
			classChangeBean.setId(Integer.valueOf(String.valueOf(dataRow[5])));
			classChangeBean.setTotalData(totalAccount);
			classChangeBeanList.add(classChangeBean);
		}
		return classChangeBeanList;
	}

	private List<ClassChangeBean> convertDataToBeanForCardAccount(List<Object[]> dataResult, int totalAccount) {
		// TODO Auto-generated method stub
		List<ClassChangeBean> classChangeBeanList = new ArrayList<ClassChangeBean>();
		ClassChangeBean classChangeBean = null;
		for (Object[] dataRow : dataResult) {
			classChangeBean = new ClassChangeBean();
			classChangeBean.setCardType(String.valueOf(dataRow[0]));
			classChangeBean.setInSum(Integer.valueOf(String.valueOf(dataRow[1])));
			classChangeBean.setOutSum(Integer.valueOf(String.valueOf(dataRow[2])));
			classChangeBean.setChSum(Integer.valueOf(String.valueOf(dataRow[3])));
			classChangeBean.setCardSum(Integer.valueOf(String.valueOf(dataRow[4])));
			classChangeBean.setWorkDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[5])));
			classChangeBean.setAccDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[6])));
			classChangeBean.setUserId(Integer.valueOf(String.valueOf(dataRow[7])));
			classChangeBean.setTotalData(totalAccount);
			classChangeBeanList.add(classChangeBean);
		}
		return classChangeBeanList;
	}

	private List<ClassChangeBean> convertDataToBeanForStationTrade(List<Object[]> dataResult, int totalAccount) {
		// TODO Auto-generated method stub
		List<ClassChangeBean> classChangeBeanList = new ArrayList<ClassChangeBean>();
		ClassChangeBean classChangeBean = null;
		for (Object[] dataRow : dataResult) {
			classChangeBean = new ClassChangeBean();
			classChangeBean.setGuestName(String.valueOf(dataRow[0]));
			classChangeBean.setGuestNo(String.valueOf(dataRow[1]));
			classChangeBean.setIncNo(String.valueOf(dataRow[2]));
			classChangeBean.setTradeType(String.valueOf(dataRow[3]));
			classChangeBean.setPayType(String.valueOf(dataRow[4]));
			classChangeBean.setMoneySum(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[5]))));
			classChangeBean.setUserId(Integer.valueOf(String.valueOf(dataRow[6])));
			classChangeBean.setWorkDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[7])));
			classChangeBean.setAccDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[8])));
			classChangeBean.setTotalData(totalAccount);
			classChangeBeanList.add(classChangeBean);
		}
		return classChangeBeanList;
	}

	private List<ClassChangeBean> convertDataToBeanForInvoice(List<Object[]> dataResult, int totalAccount) {
		// TODO Auto-generated method stub
		List<ClassChangeBean> classChangeBeanList = new ArrayList<ClassChangeBean>();
		ClassChangeBean classChangeBean = null;
		for (Object[] dataRow : dataResult) {
			classChangeBean = new ClassChangeBean();
			classChangeBean.setInvoiceCode(String.valueOf(dataRow[0]));
			classChangeBean.setStartCode(String.valueOf(dataRow[1]));
			classChangeBean.setEndCode(String.valueOf(dataRow[2]));
			classChangeBean.setInvoiceNo(String.valueOf(dataRow[3]));
			classChangeBean.setInvoiceSum(Integer.valueOf(String.valueOf(dataRow[4])));
			classChangeBean.setInvoiceMoney(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[5]))));
			classChangeBean.setInvoiceAmount(Integer.valueOf(String.valueOf(dataRow[6])));
			classChangeBean.setWorkDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[7])));
			classChangeBean.setTotalData(totalAccount);
			classChangeBeanList.add(classChangeBean);
		}
		return classChangeBeanList;
	}

	private void setPaginationNumber(ClassChangeBean classChangeBean, Query query) {
		query.setFirstResult(classChangeBean.getStartNumber());
		query.setMaxResults(classChangeBean.getTotalNumber());
	}

	private int getTotalCount(StringBuilder builder, String sql) throws Exception {
		List<?> dataResultList = this.findBySql(new StringBuilder().append(sql).append(builder).toString());
		if (dataResultList.size() > 0) {
			return (int) dataResultList.toArray()[0];
		}
		return 0;
	}

	private Query createSpecifiedQuery(StringBuilder builder, String sql) throws Exception {
		return this.getQueryByCriteria(new StringBuilder().append(sql).append(builder).toString());
	}

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
