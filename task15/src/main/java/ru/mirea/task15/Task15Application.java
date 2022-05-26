package ru.mirea.task15;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
public class Task15Application {

	public static void main(String[] args) {
		SpringApplication.run(Task15Application.class, args);
	}
	/*
	@Bean
	public HikariDataSource dataSource(){
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.postgresql.Driver");
		config.setJdbcUrl("jdbc:postgresql://localhost/hibernatetest");
		config.setUsername("postgres");
		config.setPassword("12345678");
		return new HikariDataSource(config);
	}

	@Bean
	public LocalSessionFactoryBean factoryBean(DataSource dataSource){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("ru.mirea.task15");
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		sessionFactoryBean.setHibernateProperties(properties);
		return sessionFactoryBean;
	}
	@Bean
	public PlatformTransactionManager platformTransactionManager(LocalSessionFactoryBean factoryBean){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factoryBean.getObject());
		return transactionManager;
	}
	 */
}
