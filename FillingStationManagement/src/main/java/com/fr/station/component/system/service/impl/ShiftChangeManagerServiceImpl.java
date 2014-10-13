package com.fr.station.component.system.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.system.ClassChangeBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.report.ClassInfoEntity;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.system.dao.ShiftChangeManageDAO;
import com.fr.station.component.system.dao.impl.ShiftChangeManageDaoImpl;
import com.fr.station.component.system.service.ShiftChangeManagerService;

/**
 * The action for dashboard. It handles the user request from the web sites. Mainly responsible to handle user login
 *
 * @author henry
 */
@Service("shiftChangeManagerService")
public class ShiftChangeManagerServiceImpl extends AbstractBaseService<ClassInfoEntity> implements ShiftChangeManagerService {

	// ------- Constants (static final) ----------------------------------------

	private static Logger log = Logger.getLogger(ShiftChangeManagerServiceImpl.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private ShiftChangeManageDAO shiftChangeManageDaoImpl;

	// ------- Constructors ----------------------------------------------------

	public ShiftChangeManagerServiceImpl() {
		super();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ClassChangeBean initialClassInfo() {
		ClassChangeBean resultClassChangeBean = this.shiftChangeManageDaoImpl.getCurrentShiftNum();
		// save result class information bean temporary for later using
		ApplicationContext.getInstance().setClassChangeBean(resultClassChangeBean);
		return resultClassChangeBean;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ClassChangeBean retrieveClassInfo() {
		ClassChangeBean cacheChangeBean = ApplicationContext.getInstance().getClassChangeBean();
		if(cacheChangeBean != null){
			return cacheChangeBean;
		}else{
			return this.shiftChangeManageDaoImpl.getCurrentShiftNum();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ClassChangeBean dealWithShiftChange(ClassChangeBean classChangeBean) {
		// deal with default data for changing next shift
		boolean flag = true;
		if(flag){
			try {
				return this.shiftChangeManageDaoImpl.saveCurrentShift(classChangeBean);
			} catch (Exception e) {
				log.info("Save current class information in service is occured error, more detail please see the log log\n " + "["
						+  e + "]\n" + ErrorLogUtil.printInfo(e));
			}
		}
		return null;

	}

	@Autowired
	public void setShiftChangeManageDaoImpl(ShiftChangeManageDaoImpl shiftChangeManageDaoImpl) {
		super.setBaseDao(shiftChangeManageDaoImpl);
		this.shiftChangeManageDaoImpl = shiftChangeManageDaoImpl;
	}

	// ------- Instance Methods (public) ---------------------------------------


}
