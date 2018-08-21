package com.jda.utility;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
//	 @Autowired
//    private JavaMailSender emailSender;
	 

		public void sendSimpleMessage(String link){
	       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

	       javaMailSender.setHost("smtp.gmail.com");
	        javaMailSender.setPort(587);
	        javaMailSender.setUsername("try.java01@gmail.com");
	        javaMailSender.setPassword("qwertyuiop!@#$%");
	        
	        Properties props =javaMailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol","smtp");
	        props.put("mail.smtp.auth", true);
	        props.put("mail.smtp.starttls.enable", true);
	        props.put("mail.debug",true);
	        

	    //   javaMailSender.setJavaMailProperties(props);

			
		        SimpleMailMessage message = new SimpleMailMessage();
		        message.setSubject("BootCamp");
		        message.setText(link);
		        message.setTo("neha19oct97@gmail.com");
		      //  message.setFrom("neha19oct97@gmail.com");

		        javaMailSender.send(message);
		    }
	  }

