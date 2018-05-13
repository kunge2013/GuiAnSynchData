package com.keepsoft.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	  private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

	    @Override
	    protected Object determineCurrentLookupKey() {
	        log.debug("数据源为{}", DataSourceContextHolder.getDB());

	        return DataSourceContextHolder.getDB();
	    }
}
