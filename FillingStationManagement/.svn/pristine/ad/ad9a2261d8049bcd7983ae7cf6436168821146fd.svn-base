package com.fr.station.common.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fr.station.common.bean.system.ClassChangeBean;
import com.fr.station.common.entity.card.CardEntity;
import com.fr.station.common.entity.card.FkTCardInOutEntity;
import com.fr.station.common.entity.system.StationEntity;

public class ApplicationContext {

	public static ApplicationContext instance;

	private ApplicationContext() {

	}

	private String stationNum;

	// the station name which the uers is login
	private String stationName;

	// login user name
	private String userName;

	// 角色名称
	private String roleName;

	// operator number which is save in the table fkt_employeeInfo
	private String operatorNo;

	// update cardEntity for personal card change. just temporary save the card info
	private CardEntity cardEntity;

	// get the station name list which need to limit to access different gas station.
	// map<upcompnay, stationList>
	private final Map<String, List<StationEntity>> limitStationMap = new HashMap<String, List<StationEntity>>();

	// temporary save the carInout entity to cache for the cardinout detail.
	private FkTCardInOutEntity cardInoutEntity;

	// temporary save the classChangeBean to cache for the shift chagne page to display detail.
	private ClassChangeBean classChangeBean;

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public String getStationNum() {
		return this.stationNum;
	}

	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getOperatorNo() {
		return this.operatorNo;
	}

	public void setOperatorNo(String operatorNo) {
		this.operatorNo = operatorNo;
	}

	public CardEntity getCardEntity() {
		return this.cardEntity;
	}

	public void setCardEntity(CardEntity cardEntity) {
		this.cardEntity = cardEntity;
	}

	public FkTCardInOutEntity getCardInoutEntity() {
		return this.cardInoutEntity;
	}

	public void setCardInoutEntity(FkTCardInOutEntity cardInoutEntity) {
		this.cardInoutEntity = cardInoutEntity;
	}

	public Map<String, List<StationEntity>> getLimitStationMap() {
		return this.limitStationMap;
	}

	public void addLimitStationMap(String key, StationEntity stationEntity) {
		List<StationEntity> limitStationList = this.limitStationMap.get(key);
		if (limitStationList == null) {
			limitStationList = new ArrayList<StationEntity>();
			this.limitStationMap.put(key, limitStationList);
		}
		limitStationList.add(stationEntity);
	}

	public ClassChangeBean getClassChangeBean() {
		return this.classChangeBean;
	}

	public void setClassChangeBean(ClassChangeBean classChangeBean) {
		this.classChangeBean = classChangeBean;
	}

}
