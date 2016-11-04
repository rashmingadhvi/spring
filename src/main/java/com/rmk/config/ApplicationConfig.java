package com.rmk.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
import java.io.IOException;
import java.util.Properties;

/**
 * Created by RashMin on 29-10-2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.rmk.controller","com.rmk.dao","com.rmk.model","com.rmk.service"})
@EnableTransactionManagement
@PropertySource(value= {"classpath:application.properties"})
/**
 * This is a main configuration class for configuring the spring components
 */
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean(name="sessionFactory")
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(this.dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.rmk.model" });
        sessionFactory.setAnnotatedPackages("com.rmk.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        try {
            sessionFactory.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("###############SF############");
        return sessionFactory.getObject();
    }



    /*public DataSource restDataSource() {
       BasicDataSource dataSource = new BasicDataSource();
       dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
       dataSource.setUrl(environment.getProperty("jdbc.url"));
       dataSource.setUsername(environment.getProperty("jdbc.user"));
       dataSource.setPassword(environment.getProperty("jdbc.pass"));

       return dataSource;
    }*/
    @Bean(name="dataSource")
    public DataSource dataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setName("###H2 Embaded#######")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/create-db.sql")
                .addScript("/insert-data.sql")
                .build();
        System.out.println("########DB initialized#########"+db+"##################");
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
                setProperty("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.show_sql","true");
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
