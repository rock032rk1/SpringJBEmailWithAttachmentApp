package com.springmail.app.controller;


import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmail.app.dao.MailServiceImpl;

@Controller
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	MailServiceImpl mailService;

	@GetMapping("/")
	public String indexPage() {

		return "index";
	}

	@PostMapping("/sendmail")
	public String sendMail(HttpServletRequest req) {

		String to = req.getParameter("email");
		String subject = req.getParameter("subject");
		String message = req.getParameter("msg");

		mailService.sendMail(to, subject, message);

		return "success";
	}

	@PostMapping("/sendmailwithattach")
	public String email(@RequestParam("file") final MultipartFile file,HttpServletRequest req) throws IOException {
		
		final String to=req.getParameter("email");
		final String subject=req.getParameter("subject");
		final String message=req.getParameter("msg");
		
		
		mailSender.send(new MimeMessagePreparator() {
			
			@SuppressWarnings("unlikely-arg-type")
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stubMimeMessageHelper messageHelper = new MimeMessageHelper(
				MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(to);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);
                
                String attachName = file.getOriginalFilename();
                if (!file.equals("")) {
 
                    messageHelper.addAttachment(attachName, new InputStreamSource() {
						
						public InputStream getInputStream() throws IOException {
							// TODO Auto-generated method stub
							return file.getInputStream();
						}
					});
                }
				
			}
		});
		
		return "success";
	}

	@GetMapping("/email-attachment")
	public String h1() {

		return "email-attachment";
	}
	
	@GetMapping("/index")
	public String index() {

		return "index";
	}

}
