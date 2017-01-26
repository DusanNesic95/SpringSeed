package net.sytes.codeline.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sytes.codeline.entities.Demo;

import net.sytes.codeline.dao.DemoDao;
import net.sytes.codeline.dao.DemoDaoImpl;

/**
 * @author Dusan Nesic
 * Spring config class
 * Defines database connections, and sessionFactory
 * along with bean definitions
 */
@Configuration
@ComponentScan("net.sytes.codeline")
@EnableTransactionManagement
public class ApplicationContextConfig {

	/**
	 * Method getDataSource
	 * Defines the database, driver usage, and connection credentials
	 * 
	 * @return - DataSource - database info
	 */
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_indocool");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.addConnectionProperty("useUnicode", "yes");
		dataSource.addConnectionProperty("characterEncoding", "UTF-8");
		return dataSource;
	}
	
	/**
	 * Method getSessionFactory
	 * Defines SessionFactory, and which entities are used as beans
	 * 
	 * @param dataSource - specifies which database is used
	 * @return - SessionFactory - preset sessionFactory
	 */
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Demo.class);
		sessionBuilder.addProperties(getHibernateProperties());
		
		return sessionBuilder.buildSessionFactory();
	}
	
	/**
	 * Method getHibernateProperties
	 * Returns Properties out of hibernate properties
	 * 
	 * @return - Properties - preset Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return properties;
	}
	
	/**
	 * Method getTransactionManager
	 * Setting up the TransactionManager
	 * 
	 * @param sessionFactory - passing the already defined SessionFactory
	 * @return - HibernateTransactionManager - preset component
	 */
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	/**
	 * Demo method of creating beans
	 */
	@Autowired
	@Bean(name="demoDao")
	public DemoDao getDemoDao(SessionFactory sessionFactory) {
		return new DemoDaoImpl(sessionFactory);
	}

}
