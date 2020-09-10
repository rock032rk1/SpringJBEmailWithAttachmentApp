package com.springmail.app.dao;

import java.io.File;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	public void sendMail(final String to, final String subject, final String msg) {
		// TODO Auto-generated method stub
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub

				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress("")); //Enter you Email-Id here
				mimeMessage.setSubject(subject);
				mimeMessage.setText(msg);

			}
		};

		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
	}

	public void sendMailWithAttachment(final String to, final String subject, final String body,
			final String fileToAttach) {
		// TODO Auto-generated method stub
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress("rakeshmaraskolhe08@gmail.com"));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(body);

				FileSystemResource file = new FileSystemResource(new File(fileToAttach));
				//MultipartFile fileatt=null;
				//fileatt.getOriginalFilename();
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.addAttachment(fileToAttach, file);
				
			}
		};

		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}

	}

}
