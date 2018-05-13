package com.keepsoft.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
@Configuration
@MapperScan(basePackages ={"com.keepsoft.dao"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisOracleConfig {
    @Autowired
    @Qualifier("oracleDS")
    private DataSource ds1;
    /**
     * 数据源xml解析配置
     */
    @Value("${oracleFactoryMapper}")
    private String oracleFactoryMapper;
 
    
    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1); // 
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        
        factoryBean.setMapperLocations(resolver.getResources(oracleFactoryMapper));
        
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
        return template;
    }
}
