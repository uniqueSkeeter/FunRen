package com.fr.station.component.report.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.report.DayExchangeBean;
import com.fr.station.common.entity.report.DayExchangeEntity;
import com.fr.station.common.utility.CommonUtility;
import com.fr.station.component.report.dao.DayExchangeDAO;
import com.fr.station.component.report.service.DayExchangeService;
import com.fr.station.component.system.service.impl.AbstractBaseService;

@Service
public class DayExchangeServiceImpl extends AbstractBaseService<DayExchangeEntity> implements DayExchangeService {

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	private static Logger log = Logger.getLogger(ShiftChangeReportServiceImpl.class);

	private DayExchangeDAO dayExchangeDaoImpl;

	// ------- Constructors ----------------------------------------------------

	public DayExchangeServiceImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<DayExchangeBean> findDayExchangeRecordsByCriteria(DayExchangeBean dayExchangeBean) {
		CommonUtility.countPaginationNumber(dayExchangeBean);
		return this.dayExchangeDaoImpl.getDayExchangeRecordsByCriteria(dayExchangeBean);

	}

	@Autowired
	public void setDayExchangeDAO(DayExchangeDAO dayExchangeDaoImpl) {
		super.setBaseDao(dayExchangeDaoImpl);
		this.dayExchangeDaoImpl = dayExchangeDaoImpl;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
