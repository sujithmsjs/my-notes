package com.onpassive.odesk_admin.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.onpassive.odesk_admin.constant.Constants;
import com.onpassive.odesk_admin.dto.MailDto;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailUtility {
	private static final String CLASS_NAME = "MailUtility";
	String methodName = "";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration config;

	@Value("${agent1.email_from}")
	public String fromEmailAddress;

	public boolean sendMail(MailDto mailDto) {
		methodName = "sendMail";
		log.info(Constants.STARTED, CLASS_NAME, methodName);
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			Template t = config.getTemplate("email-template3.ftl");
			Map<String, String> resultmap = new HashMap<>();

			resultmap.put("companyName", mailDto.getCompanyName());
			resultmap.put("Url", mailDto.getUrl());
			resultmap.put("email", mailDto.getEmail());
			resultmap.put("passWord", mailDto.getPassword());
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, resultmap);

			helper.setTo(mailDto.getEmail());
			helper.setText(html, true);
			helper.setSubject("Welcome to O-Desk");
			helper.setFrom(new InternetAddress(fromEmailAddress, "ODESK"));
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(Constants.ENDED, CLASS_NAME, methodName);
			return false;
		}
		log.info(Constants.ENDED, CLASS_NAME, methodName);
		return true;
	}
}
