package com.baja.ecommercebackend.configuraion;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.baja.ecommercebackend.dto")
@EnableTransactionManagement
public class HibernateConfig {
	// Change the below keys based on your specific database.
	private final static String DATABASE_URL = "jdbc:h2:tcp//localhost/~/ecommerce";
	private final static String DATABASE_DRIVER = "org.h2.driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "baja";
	private final static String DATABASE_PASSWORD = "";

	// DATASOURCE BEAN
	@Bean
	private DataSource getSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setPassword(DATABASE_PASSWORD);
		dataSource.setUsername(DATABASE_USERNAME);

		return dataSource;
	}

	// SessionFactory Bean
	@Bean
	private SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.baja.ecommercebackend.dto");
		return builder.buildSessionFactory();
	}
	
	//All hibernate properties will be returned in this method
	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		return properties;
	}
	//Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hbm = new HibernateTransactionManager(sessionFactory);
		return hbm;
	}
}
