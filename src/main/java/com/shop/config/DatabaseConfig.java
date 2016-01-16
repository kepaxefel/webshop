package com.shop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
	@Value("${spring.datasource.driverClassName}")
	private String dbDriver;
	  
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String dbUsername;	  

	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	  
	@Value("${hibernate.show_sql}")
	private String hibernateShowSQL;
	 
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	@Value("${entitymanager.packagesToScan}")
	private String packegesToScan;
  
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(dbDriver);
	    dataSource.setUrl(dbUrl);
	    dataSource.setUsername(dbUsername);
	    dataSource.setPassword(dbPassword);
	    return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource());
	    sessionFactoryBean.setPackagesToScan(packegesToScan);
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect",  hibernateDialect);
	    hibernateProperties.put("hibernate.show_sql", hibernateShowSQL);
	    hibernateProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	}
}