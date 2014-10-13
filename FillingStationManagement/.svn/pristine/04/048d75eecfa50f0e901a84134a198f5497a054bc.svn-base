package com.fr.station.component.customer.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.customer.CardChargeBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.card.FKTCardTZEntity;
import com.fr.station.common.entity.card.FkTCreditEntity;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.customer.dao.CardChargeDAO;
import com.fr.station.component.system.dao.AbstractBaseDAO;

/**
 * The cardChargeServiceImpl for cardCharge
 * 
 * @author WR
 */
@Repository
public class CardChargeDaoImpl extends AbstractBaseDAO<FkTCreditEntity> implements CardChargeDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(CardChargeDaoImpl.class);

	// ------- Static Variables (static) ---------------------------------------

	private final String cardAcountSql = " SELECT card.cardNo, card.cardType, card.cardStatus, card.cardFlag, card.guestType, card.guestNum, "
			+ " card.guestNo, card.guestName, cardAcc.cardInc, cardAcc.cardBal, cardAcc.pre, cardAcc.cardDec, cardAcc.id "
			+ " FROM FK_T_CARD card, FK_T_CARDTZ cardAcc WHERE card.cardNo = cardAcc.cardNo ";

	private final String updateCardTZSql = "UPDATE FK_T_CARDTZ SET cardBal = ? , cardInc = ? , cardDec = ? , update_date = ? WHERE id = ? ";

	private final String selectCardTradeNoSql = "SELECT attriValue FROM stationParameter WHERE attriName = 'cardTradeNo' ";

	private final String updateSysParameterAttriValueSql = "UPDATE stationParameter SET attriValue = attriValue + '1'  WHERE attriName = ? ";

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------
	public CardChargeDaoImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * 获得卡账户信息 2014-7-30 更新
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CardChargeBean> getCardAccountRecordsByCriteria(CardChargeBean cardChargeBean) {
		List<CardChargeBean> resultList = null;
		StringBuilder builder = new StringBuilder();
		builder.append(this.cardAcountSql);
		try {
			StringBuilder req = this.validateCardAccountInput(cardChargeBean);
			builder.append(req);
			Query query = null;
			try {
				query = this.getQueryByCriteria(builder.toString());
			} catch (Exception e) {
				log.info("Sql execute error, more detail please see the detail log" + e.getMessage() + "\n");
			}
			List<Object[]> result = query.list();
			resultList = this.convertCardAccountToBean(result);

		} catch (QueryException e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;
	}

	/**
	 * 卡充值时更新卡账信息表
	 */
	@Override
	public void updateCardAccEntity(FKTCardTZEntity cardAccEntity) {
		Object[] args = { cardAccEntity.getCardbal(), cardAccEntity.getCardinc(), cardAccEntity.getCarddec(),
				DateUtil.currentTimestamp(), cardAccEntity.getId() };
		this.upateBySql(this.updateCardTZSql, args);
	}

	/**
	 * @Inherited doc 取得卡交易的交易流水号
	 */
	@Override
	public Integer getCardTradeNo() {
		Integer cardTradeNo = 0;
		try {
			List<?> resultList = this.findBySql(this.selectCardTradeNoSql);
			if (resultList.size() > 0) {
				cardTradeNo = (Integer) resultList.get(0);
			}
		} catch (Exception e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return cardTradeNo;
	}

	/**
	 * @Inherited doc 使卡交易交易流水号自增
	 */
	@Override
	public void updateCardTradeNo() {
		Object[] args = { "cardTradeNo" };
		// 执行SQL
		this.upateBySql(this.updateSysParameterAttriValueSql, args);
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	/**
	 * 查询卡账户信息SQL语句查询条件
	 */
	private StringBuilder validateCardAccountInput(CardChargeBean cardChargeBean) {
		StringBuilder builder = new StringBuilder();
		if (ApplicationContext.getInstance().getStationNum() != null) {
			builder.append(" AND ").append(" card.stationNo = '").append(ApplicationContext.getInstance().getStationNum())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(cardChargeBean.getCardNo())) {
			builder.append(" AND ").append("card.cardNo = '").append(cardChargeBean.getCardNo()).append("' ");
		} else if (StringUtils.isNotEmpty(cardChargeBean.getGuestNo())) {
			builder.append(" AND ").append("card.guestNo = '").append(cardChargeBean.getGuestNo()).append("' ");
		}
		return builder;
	}

	/**
	 * 把卡账户信息覆盖到bean
	 */
	private List<CardChargeBean> convertCardAccountToBean(List<Object[]> dataResult) {
		List<CardChargeBean> cardChargeBeanList = new ArrayList<CardChargeBean>();
		CardChargeBean cardChargeBean;
		for (Object[] dataRow : dataResult) {
			cardChargeBean = new CardChargeBean();
			// 卡号
			cardChargeBean.setCardNo(String.valueOf(dataRow[0]));
			// 卡片类型
			cardChargeBean.setCardType(String.valueOf(dataRow[1]));
			// 卡状态
			cardChargeBean.setCardStatus(String.valueOf(dataRow[2]));
			// 是否主卡
			if (String.valueOf(dataRow[3]).split(" ")[0].equals("Y")) {
				cardChargeBean.setMainCardFlag(true);
			} else {
				cardChargeBean.setMainCardFlag(false);
			}
			// 证件类型
			cardChargeBean.setGuestType(String.valueOf(dataRow[4]));
			// 证件号码
			cardChargeBean.setGuestNum(String.valueOf(dataRow[5]));
			// 客户编号
			cardChargeBean.setGuestNo(String.valueOf(dataRow[6]));
			// 持卡人
			cardChargeBean.setGuestName(String.valueOf(dataRow[7]));
			// 充值总和
			cardChargeBean.setRechargeAmount(((BigDecimal) (dataRow[8])));
			// 卡内余额
			cardChargeBean.setCardAccount(((BigDecimal) (dataRow[9])));
			// 卡备用金
			cardChargeBean.setCardPre(((BigDecimal) (dataRow[10])));
			// 消费总和
			cardChargeBean.setConsumeSum(((BigDecimal) (dataRow[11])));
			// cardAcc id
			cardChargeBean.setId(((Integer) (dataRow[12])));

			cardChargeBeanList.add(cardChargeBean);
		}
		return cardChargeBeanList;
	}
	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
