package com.rmk.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@EnableTransactionManagement
@PropertySource(value= {"classpath:application.properties"})
public class DAOConfig {

	@Autowired
	private Environment environment;
	

	 
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(this.dataSource());
	      sessionFactory.setPackagesToScan(new String[] { "com.rmk.model" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	 		System.out.println("###############SF############");
	      return sessionFactory;
	   }
	 

	
	   /*public DataSource restDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
	      dataSource.setUrl(environment.getProperty("jdbc.url"));
	      dataSource.setUsername(environment.getProperty("jdbc.user"));
	      dataSource.setPassword(environment.getProperty("jdbc.pass"));
	 
	      return dataSource;
	   }*/

	public DataSource dataSource() {

		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/create-db.sql")
				.addScript("/insert-data.sql")
				.build();
		System.out.println("#################"+db+"##################");
		return db;
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
	 


	   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	      HibernateTransactionManager txManager = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	 
	      return txManager;
	   }
	   

	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
}
