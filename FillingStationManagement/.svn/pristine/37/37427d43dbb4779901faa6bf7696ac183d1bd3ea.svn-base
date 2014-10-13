package com.fr.station.common.listener;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.fr.station.component.system.service.InitializeCacheDataService;

public class CacheDataListener implements InitializingBean, ServletContextAware {

	@Autowired
	private InitializeCacheDataService initializeCacheDataService;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.initializeCacheDataService.loadCacheData();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	
}
