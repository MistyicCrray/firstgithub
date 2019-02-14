package com.springboot.tools;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 * @author Administrator
 *
 */
public class SendEmailUtil {

	/**
	 * 发送邮箱
	 * @param content 内容
	 * @param sendTo 接收者
	 * @param subJect 主题
	 * @param javaMailSender
	 * @param form 发送者
	 * @return
	 * @throws MessagingException
	 */
	public static String send(String content, String sendTo, String subJect, JavaMailSender javaMailSender, String form)
			throws MessagingException {
		MimeMessage meMimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(meMimeMessage, true, "UTF-8");
		// 发送者
		messageHelper.setFrom(form);
		// 接收者
		messageHelper.setTo(sendTo);
		// 邮件主题
		meMimeMessage.setSubject(subJect);
		// 邮件内容
		meMimeMessage.setContent(content, "text/html;charset=UTF-8");
		javaMailSender.send(meMimeMessage);
		return "success";
	}
}
