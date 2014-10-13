package com.fr.station.component.customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.customer.CardChargeBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.data.DataCollections;
import com.fr.station.common.entity.card.FKTCardTZEntity;
import com.fr.station.common.entity.card.FkTCreditEntity;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.component.customer.dao.CardChargeDAO;
import com.fr.station.component.customer.dao.RegisterCustomerDAO;
import com.fr.station.component.customer.service.CardChargeService;
import com.fr.station.component.system.service.impl.AbstractBaseService;

/**
 * The cardChargeServiceImpl for cardCharge
 * 
 * @author WR
 */
@Service
public class CardChargeServiceImpl extends AbstractBaseService implements CardChargeService {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(CardChargeServiceImpl.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private CardChargeDAO cardChargeDaoImpl;

	private RegisterCustomerDAO registerCustomerDaoImpl;

	// ------- Constructors ----------------------------------------------------
	public CardChargeServiceImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	@Autowired
	public void setCardChargeDAO(CardChargeDAO cardChargeDaoImpl) {
		super.setBaseDao(cardChargeDaoImpl);
		this.cardChargeDaoImpl = cardChargeDaoImpl;
	}

	@Autowired
	public void setRegisterCustomerDAO(RegisterCustomerDAO registerCustomerDaoImpl) {
		super.setBaseDao(registerCustomerDaoImpl);
		this.registerCustomerDaoImpl = registerCustomerDaoImpl;
	}

	/**
	 * 返回对应的卡账户信息
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CardChargeBean> findCardAccountRecordsByCriteria(CardChargeBean cardChargeBean) {
		List<CardChargeBean> cardChargeBeanList = null;
		log.info("start to find Card Account Records By Criteria");
		if (cardChargeBean == null) {
			log.info("cardChargeBean is null");
			return null;
		}
		cardChargeBeanList = this.cardChargeDaoImpl.getCardAccountRecordsByCriteria(cardChargeBean);
		if (cardChargeBeanList == null) {
			cardChargeBeanList = new ArrayList<CardChargeBean>();
			log.info("cardChargeBeanList is null");
		}
		log.info("end find Card Account Records By Criteria");
		return cardChargeBeanList;
	}

	/**
	 * addCardChargeInfo 2014-7-29更新
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCardChargeInfo(CardChargeBean cardChargeBean) {
		log.info("Persist cardChargeBean entity begain");

		// construct card account entity
		FKTCardTZEntity cardAccEntity = this.covertDataToCardAccEntity(cardChargeBean);

		// 更新卡账户信息表
		this.cardChargeDaoImpl.updateCardAccEntity(cardAccEntity);

		// get user cardTradeNo from system parameter table.
		Integer cardTradeNo = this.cardChargeDaoImpl.getCardTradeNo();

		// construct card Credit Entity
		FkTCreditEntity cardCreditEntity = this.covertDataToCardCreditEntity(cardChargeBean);

		// 设置卡交易号
		cardCreditEntity.setIncno(String.valueOf(cardTradeNo));

		// persist card Credit Entity
		this.save(cardCreditEntity);

		// update table system parameter set attriValue plus one when guest info is successfully save into DB.
		this.cardChargeDaoImpl.updateCardTradeNo();

		log.info("Succefully saved  entity into DB");
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------
	/**
	 * 把交易类型(tradeType)由数字变为文字
	 */
	private String convertTradeTypeKeyToValue(String key) {
		final Map<String, String> TradeType = DataCollections.chargeTradeType;
		for (final Entry<String, String> entry : TradeType.entrySet()) {
			if (entry.getKey().trim().equalsIgnoreCase(key)) {
				return entry.getValue();
			}
		}
		log.info("can not find the trade type value");
		return null;
	}

	/**
	 * 将cardChargeBean转换成fktCardTZEntity
	 */
	private FKTCardTZEntity covertDataToCardAccEntity(CardChargeBean cardChargeBean) {
		FKTCardTZEntity fktCardTZEntity = new FKTCardTZEntity();
		if (cardChargeBean.getId() != null) {
			fktCardTZEntity.setId(cardChargeBean.getId());
		}
		// 充值
		if (this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("充值")) {
			// 卡内余额更新
			if (cardChargeBean.getCardAccount() != null && cardChargeBean.getChargeAmount() != null) {
				fktCardTZEntity.setCardbal(cardChargeBean.getCardAccount().add(cardChargeBean.getChargeAmount()));
			}
			// 充值总额更新
			if (cardChargeBean.getRechargeAmount() != null && cardChargeBean.getChargeAmount() != null) {
				fktCardTZEntity.setCardinc(cardChargeBean.getRechargeAmount().add(cardChargeBean.getChargeAmount()));
			}
			// 消费总额更新
			if (cardChargeBean.getConsumeSum() != null) {
				fktCardTZEntity.setCarddec(cardChargeBean.getConsumeSum());
			}
		}
		// 扣款
		else if (this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("退款")
				|| this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("消费")
				|| this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("撤销")) {
			// 卡内余额跟新
			if (cardChargeBean.getCardAccount() != null && cardChargeBean.getChargeAmount() != null) {
				fktCardTZEntity.setCardbal(cardChargeBean.getCardAccount().subtract(cardChargeBean.getChargeAmount()));
			}
			// 充值总额更新
			if (this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("撤销")) {
				if (cardChargeBean.getRechargeAmount() != null && cardChargeBean.getChargeAmount() != null) {
					fktCardTZEntity.setCardinc(cardChargeBean.getRechargeAmount().subtract(cardChargeBean.getChargeAmount()));
				}
			} else {
				if (cardChargeBean.getRechargeAmount() != null) {
					fktCardTZEntity.setCardinc(cardChargeBean.getRechargeAmount());
				}
			}
			// 消费总额更新
			if (this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("消费")) {
				if (cardChargeBean.getConsumeSum() != null && cardChargeBean.getChargeAmount() != null) {
					fktCardTZEntity.setCarddec(cardChargeBean.getConsumeSum().add(cardChargeBean.getChargeAmount()));
				}
			} else {
				if (cardChargeBean.getConsumeSum() != null) {
					fktCardTZEntity.setCarddec(cardChargeBean.getConsumeSum());
				}
			}

		}

		return fktCardTZEntity;
	}

	/**
	 * 将cardChargeBean转换成FkTCreditEntity
	 */
	private FkTCreditEntity covertDataToCardCreditEntity(CardChargeBean cardChargeBean) {
		FkTCreditEntity cardCreditEntity = new FkTCreditEntity();
		// 用户名
		if (StringUtils.isNotBlank(cardChargeBean.getGuestName())) {
			cardCreditEntity.setGuestname(cardChargeBean.getGuestName());
		}
		// 交易序号 银行卡充值时有值
		if (StringUtils.isNotBlank(cardChargeBean.getBankSerialNum())) {
			cardCreditEntity.setIncno(cardChargeBean.getBankSerialNum());
		}
		// 卡号
		if (StringUtils.isNotBlank(cardChargeBean.getCardNo())) {
			cardCreditEntity.setCardno(cardChargeBean.getCardNo());
		}
		// 交易额
		if (cardChargeBean.getChargeAmount() != null) {
			cardCreditEntity.setCardinc(cardChargeBean.getChargeAmount());
		}
		// 交易前余额
		if (cardChargeBean.getCardAccount() != null) {
			cardCreditEntity.setCardbeg(cardChargeBean.getCardAccount());
		}
		if (this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("充值")) {
			// 交易后余额
			if (cardChargeBean.getChargeAmount() != null && cardChargeBean.getCardAccount() != null) {
				cardCreditEntity.setCardbal(cardChargeBean.getCardAccount().add(cardChargeBean.getChargeAmount()));
			}
		} else if (this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("退款")
				|| this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("消费")
				|| this.convertTradeTypeKeyToValue(cardChargeBean.getTradeType()).equals("撤销")) {
			// 交易后余额
			if (cardChargeBean.getChargeAmount() != null && cardChargeBean.getCardAccount() != null) {
				cardCreditEntity.setCardbal(cardChargeBean.getCardAccount().subtract(cardChargeBean.getChargeAmount()));
			}
		}
		// 交易类型
		if (StringUtils.isNotBlank(cardChargeBean.getTradeType())) {
			cardCreditEntity.setInctype(cardChargeBean.getTradeType());
		}
		// 充值类型
		if (StringUtils.isNotBlank(cardChargeBean.getPayType())) {
			cardCreditEntity.setRectype(cardChargeBean.getPayType());
		}
		// 站点编号
		if (StringUtils.isNotBlank(ApplicationContext.getInstance().getStationNum())) {
			cardCreditEntity.setStationno(ApplicationContext.getInstance().getStationNum());
		}
		// 操作员编号
		if (StringUtils.isNotBlank(ApplicationContext.getInstance().getOperatorNo())) {
			cardCreditEntity.setUserid(Integer.parseInt(ApplicationContext.getInstance().getOperatorNo()));
		}
		// 创建日期
		cardCreditEntity.setCreateDate(DateUtil.currentTimestamp());
		// 班结号
		if (StringUtils.isNotBlank(ApplicationContext.getInstance().getClassChangeBean().getClassNo())) {
			cardCreditEntity.setAccNo(ApplicationContext.getInstance().getClassChangeBean().getClassNo());
		}
		// 转账类型
		cardCreditEntity.setTransferType("0");
		return cardCreditEntity;
	}
	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
