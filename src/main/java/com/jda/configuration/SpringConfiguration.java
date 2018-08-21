package com.jda.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jda.dao.UserDao;
import com.jda.services.UserService;
import com.jda.utility.MailService;

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
		
		@Bean
		public PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
		

	//    @Bean
//	    public JavaMailSender javaMailService() {
//	       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//
//	       javaMailSender.setHost("smtp.gmail.com");
//	        javaMailSender.setPort(587);
//	        javaMailSender.setUsername("try.java01@gmail.com");
//	        javaMailSender.setPassword("qwertyuiop!@#$%");
//	        
//	        Properties props =javaMailSender.getJavaMailProperties();
//	        props.put("mail.transport.protocol","smtp");
//	        props.put("mail.smtp.auth", true);
//	        props.put("mail.smtp.starttls.enable", true);
//	        props.put("mail.debug",true);
//	        
//
//	    //   javaMailSender.setJavaMailProperties(props);
//
//	        return javaMailSender;
	   // }

	  

	}
