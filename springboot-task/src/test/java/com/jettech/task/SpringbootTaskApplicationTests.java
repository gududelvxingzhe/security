package com.jettech.task;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

	@Autowired
	JavaMailSender mailSender;
	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		//邮件标题
		message.setSubject("通知：今晚开会");
		message.setText("邮件内容……");
		//发给谁
		message.setTo("gududelvxingzhe@163.com");
		//谁发的
		message.setFrom("1024968529@qq.com");
		mailSender.send(message);
	}
	
	/**
	 * 发送复杂的邮件
	 * @throws MessagingException 
	 */
	@Test
	public void test02() throws MessagingException {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		//邮件设置
		helper.setSubject("通知-今晚开会");
		helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);
		
		helper.setTo("17512080612@163.com");
		helper.setFrom("534096094@qq.com");
		
		//上传文件
		helper.addAttachment("1.jpg", new File("E:\\My Pictures\\1ee9c49064a52af.jpg"));
		helper.addAttachment("1.jpg", new File("E:\\My Pictures\\8d37fca5066ead4.jpg"));
		
		mailSender.send(mimeMessage);
	}

}
