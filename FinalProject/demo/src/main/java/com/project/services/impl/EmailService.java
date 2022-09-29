package com.project.services.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to) {
		
		boolean  f=false;
		
		String from = "team10cdacproject@gmail.com";
		
		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("Properties "+properties);		
		
		//host set
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object
		Session session = Session.getInstance(properties,new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("team10cdacproject@gmail.com","iplobrnrweulxmzw");
			}
		});
		session.setDebug(true);
		
		//Step 2:Compose the message[text,image]
		MimeMessage m =  new MimeMessage(session);
		
		try {
			m.setFrom(to);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject("Booking Sucecessful !!");
			m.setText("Dear Customer\n\n"+message+"\n\nThankyou for registrating with us."
					+ "\nWe are here to provide you the facility at the sport turf."
					+ "\nFor further details/queries related to booking kindly contact us at team10cdacproject@gmail.com"
					+ "\n\nTeam,\nPure Play");
			
			
			//Step 3:send the message using transport class
			Transport.send(m);
			System.out.println("Sent successfully....");
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}






