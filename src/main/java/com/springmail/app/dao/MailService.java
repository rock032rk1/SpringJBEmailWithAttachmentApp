package com.springmail.app.dao;

public interface MailService {

	public void sendMail(final String to,final String subject,final String msg);
	
}
