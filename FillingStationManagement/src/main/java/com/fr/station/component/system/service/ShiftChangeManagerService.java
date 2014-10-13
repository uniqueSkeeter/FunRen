package com.fr.station.component.system.service;

import com.fr.station.common.bean.system.ClassChangeBean;
import com.fr.station.common.entity.report.ClassInfoEntity;

/**
 * The interface for the login service .
 *
 * @trace NH.ICCardManagement.OperatorEntity.Table
 *
 * @author _wsq
 */
public interface ShiftChangeManagerService extends BaseService<ClassInfoEntity> {


	public ClassChangeBean initialClassInfo();

	public ClassChangeBean retrieveClassInfo();

	public ClassChangeBean dealWithShiftChange(ClassChangeBean classChangeBean);

}
