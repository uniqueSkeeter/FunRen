package com.fr.station.component.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.report.CardTradeReportBean;
import com.fr.station.common.entity.card.FkTCreditEntity;
import com.fr.station.common.utility.CommonUtility;
import com.fr.station.component.report.dao.CardTradeReportDAO;
import com.fr.station.component.report.service.CardTradeReportService;
import com.fr.station.component.system.service.impl.AbstractBaseService;

@Service
public class CardTradeReportServiceImpl extends AbstractBaseService<FkTCreditEntity> implements CardTradeReportService {

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private CardTradeReportDAO cardTradeDaoImpl;

	// ------- Constructors ----------------------------------------------------
	public CardTradeReportServiceImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CardTradeReportBean> findCardTradeRecordsByCriteria(CardTradeReportBean cardTradeBean) {
		CommonUtility.countPaginationNumber(cardTradeBean);
		return this.cardTradeDaoImpl.getCardTradeRecordsByCriteria(cardTradeBean);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CardTradeReportBean> findGuestCreditRecordsByCriteria(CardTradeReportBean cardTradeBean) {
		CommonUtility.countPaginationNumber(cardTradeBean);
		return this.cardTradeDaoImpl.getGuestCreditRecordsByCriteria(cardTradeBean);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CardTradeReportBean> findCardPredistributionRecordsByCriteria(CardTradeReportBean cardTradeBean) {
		CommonUtility.countPaginationNumber(cardTradeBean);
		return this.cardTradeDaoImpl.getCardPredistributionRecordsByCriteria(cardTradeBean);

	}

	@Autowired
	public void setCardTradeDAO(CardTradeReportDAO cardTradeDaoImpl) {
		super.setBaseDao(cardTradeDaoImpl);
		this.cardTradeDaoImpl = cardTradeDaoImpl;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
