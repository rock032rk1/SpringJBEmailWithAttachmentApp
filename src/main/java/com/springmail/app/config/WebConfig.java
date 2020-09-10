package com.springmail.app.config;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.springmail.app")
public class WebConfig {

	@Bean
	public InternalResourceViewResolver getResolver() {
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		
		return resolver;
		
	}
	
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		
		//Using Gmail SMTP Configuration
		
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		//User Own Email-ID and Password
		
		
		mailSender.setUsername(""); //enter your email id
		mailSender.setPassword(""); //enter your email-id password
		
		
		    Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
			
		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}
		
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver1() {
		
		CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSizePerFile(20*1024*1024);
		
		return commonsMultipartResolver;
	}
	
}
