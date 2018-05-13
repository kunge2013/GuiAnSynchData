package com.keepsoft.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 使用阿里数据源监控
 * @author fk
 *
 */
@Configuration
public class DataSourceConfig {

		@Primary
	 	@Bean(name = "oracleDS")
	    @ConfigurationProperties(prefix = "spring.datasource.oracle-master") // application.properteis中对应属性的前缀
	    public DataSource dataSource1() {
//	        return DataSourceBuilder.create().build();
		  return new DruidDataSource();
	    }



	    @Bean(name = "sqlserverDS")
	    @ConfigurationProperties(prefix = "spring.datasource.sqlserver") // application.properteis中对应属性的前缀
	    public DataSource dataSource2() {
//	        return DataSourceBuilder.create().build();
    	 return new DruidDataSource();
	    }
}
