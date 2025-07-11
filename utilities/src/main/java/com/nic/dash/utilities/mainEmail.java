package com.nic.dash.utilities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;*/

@Component
public class mainEmail {

	//@Value("${host}")
	private String host="smtp.gmail.com";
//	@Value("${password}")
	private String password="nrxdriripoehbylz\r\n";
//	@Value("${mail_id}")
	private String mailId="dikshant.ds@gmail.com";
//	@Value("${mail_name}")
	private String mailName="AutomatedMailTesting";
//	@Value("${smtp_port}")
	private String port="587";

	public InternetAddress[] convertStringToInternetAddress(String input) throws AddressException 
    {
			String[] list = input.split(",");
			InternetAddress[] conevrtedArray = new InternetAddress[list.length];
			InternetAddress addr;
			int i = 0;
	   for (String s : list) 
	    {
			addr = new InternetAddress(s);
			conevrtedArray[i] = addr;
			i++;
	     }
	return conevrtedArray;

	}

	public Multipart addMultipleAttachments(String attachmentFolder, String attachments, Multipart multipart)
	throws MessagingException 
 {
	String[] list = attachments.split(",");

	MimeBodyPart messageBodyPart;
	for (String s : list) 
      {

			messageBodyPart = new MimeBodyPart();		
			DataSource source = new FileDataSource(attachmentFolder + s);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(source.getName());
			multipart.addBodyPart(messageBodyPart);
	   }
	return multipart;

}


	public Multipart addMultipleAttachmentsWithNameChange(String attachmentFolder, String attachments, String attachmentNames, Multipart multipart)
	throws MessagingException 
    {
	String[] attachmentsArray = attachments.split("######");
	String[] names = attachments.split("######");

	MimeBodyPart messageBodyPart;
	
	for (int i=0;i< attachmentsArray.length ;i++) 
	   {
			messageBodyPart = new MimeBodyPart();
		
			DataSource source = new FileDataSource(attachmentFolder + attachmentsArray[i]);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(names[i]);
			multipart.addBodyPart(messageBodyPart);
	    }
	return multipart;

}

	public void sendMail(String subject,String attachmentPath, String to, String cc) throws MessagingException,IOException 
	 {
		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.debug", "true");

	Session session = Session.getInstance(props, new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(mailId, password);
				}
		});

	MimeMessage message = new MimeMessage(session);
	
	message.setFrom(new InternetAddress(mailId, mailName));
	message.addRecipients(Message.RecipientType.TO, convertStringToInternetAddress(to));
	message.addRecipients(Message.RecipientType.CC, convertStringToInternetAddress(cc));
	message.setSubject(subject);
	
	MimeBodyPart textPart = new MimeBodyPart();
    textPart.setText("Image file for testing, pls ignore");
	 
	MimeBodyPart attachmentPart = new MimeBodyPart();
	attachmentPart.attachFile(attachmentPath);
	
    Multipart multipart = new MimeMultipart();
	multipart.addBodyPart(textPart);
	multipart.addBodyPart(attachmentPart);

	message.setContent(multipart);
	
// Part two is attachment
	/*
	 * if ((!attachmentFolder.isEmpty()) && (!attachments.isEmpty()) &&
	 * (attachmentFolder != null) && (attachments != null)) { multipart =
	 * addMultipleAttachments(attachmentFolder, attachments, multipart); }
	 */
	
	// Send the complete message parts
      Transport.send(message);
   	  System.out.println("mail sent");

	}

	public void sendMailWithAttachmentNameChange(String subject, String body, String attachmentFolder, String attachments,String attachmentNames, String to, String cc)
	throws MessagingException, UnsupportedEncodingException {

	Properties props = new Properties();

	props.put("mail.transport.protocol", "smtp");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	//props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	props.put("mail.smtp.port", port);
	props.put("mail.smtp.debug", "true");

	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(mailId, password);
	}
	});

	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress(mailId, mailName));
	message.addRecipients(Message.RecipientType.TO, convertStringToInternetAddress(to));
	message.addRecipients(Message.RecipientType.CC, convertStringToInternetAddress(cc));
	message.setSubject(subject);

	BodyPart messageBodyPart = new MimeBodyPart();

	// Now set the actual message
	messageBodyPart.setContent(body, "text/html");

	// Create a multipar message
	Multipart multipart = new MimeMultipart();

	// Set text message part
	multipart.addBodyPart(messageBodyPart);

	// Part two is attachment


	if ((!attachmentFolder.isEmpty()) && (!attachments.isEmpty()) && (attachmentFolder != null)
	&& (attachments != null)) {
	multipart = addMultipleAttachmentsWithNameChange(attachmentFolder, attachments,attachmentNames, multipart);
	}
	// Send the complete message parts

	message.setContent(multipart);

	Transport.send(message);

	}
	}

