package com.fr.station.component.dataCenter.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.report.EmployeeBean;
import com.fr.station.common.bean.system.OperateLogBean;
import com.fr.station.common.entity.report.OperatelogEntity;
import com.fr.station.component.dataCenter.dao.DataCenterDAO;
import com.fr.station.component.dataCenter.service.DataCenterService;
import com.fr.station.component.system.service.impl.AbstractBaseService;

/**
 * The service is mainly to used get station trade logs for each car.
 * Mainly responsible to handle different scenario search
 * 
 * @author henry
 */
@SuppressWarnings("rawtypes")
@Service("dataCenterService")
public class DataCenterServiceImpl extends AbstractBaseService implements DataCenterService {
	
	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	
	// ------- Constructors ----------------------------------------------------
	
	
	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------
	
}
