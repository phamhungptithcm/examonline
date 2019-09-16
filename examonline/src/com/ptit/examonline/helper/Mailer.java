package com.ptit.examonline.helper;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Mailer {
	@Autowired
	JavaMailSender mailSender;

	public boolean send(String to, String subject, String content) {
		boolean status = true;
		String from = "phamhung.pitit@gmail.com";
		try {
			this.send(from, to, null, null, subject, content, null);
		} catch (SendFailedException e) {
			e.printStackTrace();
			status = false;
			System.out.println(e.getMessage());
		}
		return status;
	}

	private void send(String from, String to, String cc, String bcc, String subject, String content, String files)
			throws SendFailedException {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(from, from);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(content, true);
			messageHelper.setReplyTo(from, from);

			// check and set cc or bcc nếu có
			if (cc != null && cc.length() > 0) {
				messageHelper.setCc(cc.split("[,; ]+"));
			}
			if (bcc != null && bcc.length() > 0) {
				messageHelper.setBcc(bcc.split("[,; ]+"));
			}

			// attach files
			if (files != null && files.length() > 0) {
				String[] paths = files.split("[,; ]+");
				for (String path : paths) {
					File file = new File(path);
					messageHelper.addAttachment(file.getName(), file);
				}
			}

			// Send mail
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
