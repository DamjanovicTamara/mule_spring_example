package com.acme_travel.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = {"com.acme_travel.flight"})
@EnableTransactionManagement
public class DataSourceConfiguration {
	@Autowired
	Environment environment;

	

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource  ds = new BasicDataSource ();
		ds.setUrl(environment.getProperty("spring.datasource.url"));
		ds.setUsername(environment.getProperty("spring.datasource.username"));
		ds.setPassword(environment.getProperty("spring.datasource.password"));
		ds.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.acme_travel.flight");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(getJpaProperties());
		return factory;
	}
	
	private Properties getJpaProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		return prop;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactory().getObject());
		return manager;
	}

}
