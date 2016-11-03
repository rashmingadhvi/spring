package com.rmk.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value= {"classpath:application.properties"})
public class DAOConfig {

	@Autowired
	private Environment environment;
	
	 @Bean
	 
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(restDataSource());
	      sessionFactory.setPackagesToScan(new String[] { "com.rmk.registration" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	 
	      return sessionFactory;
	   }
	 
	@Bean
	
	   public DataSource restDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
	      dataSource.setUrl(environment.getProperty("jdbc.url"));
	      dataSource.setUsername(environment.getProperty("jdbc.user"));
	      dataSource.setPassword(environment.getProperty("jdbc.pass"));
	 
	      return dataSource;
	   }
	 
	 	Properties hibernateProperties() {
	      return new Properties() {
	         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
	            setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
	            setProperty("hibernate.globally_quoted_identifiers", "true");
	         }
	      };
	   }
	 
	   @Bean
	   @Autowired
	   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	      HibernateTransactionManager txManager = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	 
	      return txManager;
	   }
	   
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
}
