package com.jda.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jda.dao.UserDao;
import com.jda.services.UserService;

@Configuration
	@ComponentScan("com.jda")
	@EnableWebMvc
	public class SpringConfiguration {
		
		@Bean
		public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setPrefix("/templates/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
		
		@Bean
		public UserDao getUserDao()
		{
			return new UserDao();
		}
		
		@Bean
		public UserService getUserService()
		{
			return new UserService();
		}
		
		@Bean
		public DataSource getDataSource()
		{
			DriverManagerDataSource driverMangerDataSource=new DriverManagerDataSource();
			driverMangerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
			driverMangerDataSource.setUrl("jdbc:mysql://10.0.0.160/db1000216");
			driverMangerDataSource.setUsername("u1000216");
			driverMangerDataSource.setPassword("7hIXZYjHI5");
			return driverMangerDataSource;
		}

	}
