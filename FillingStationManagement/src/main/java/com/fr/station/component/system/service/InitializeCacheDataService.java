package com.fr.station.component.system.service;


/**
 * The interface for get Gas trading records .
 * 
 * @trace FR.ICCardManagement.OperatorLogEntity.Table
 * 
 * @author _wsq
 */
public interface InitializeCacheDataService {


	/**
	 * initialize data for first log in.
	 * 
	 */	
	public void loadCacheData();
	
}
