package org.linuxx.moonserver;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.linuxx.moonserver.mailer.MailModule;
import org.linuxx.moonserver.mailer.Mailer;
import org.linuxx.moonserver.mailer.credentials.LarsKontingentLiveCredentialsModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		LOGGER.trace("start static main()");

		// sendMail();

		Injector injector = Guice.createInjector(new MailModule(), new LarsKontingentLiveCredentialsModule());

		Mailer mailer = injector.getInstance(Mailer.class);
		// mailer.deleteLast();
		mailer.deleteOneDayOlds();
		mailer.start();
	}

	public static void sendMail() {
		// Recipient's email ID needs to be mentioned.
		String to = "baufi-reporting-qa@csvupload.local";

		// Sender's email ID needs to be mentioned
		String from = "lars.langhans@hypoport.de";

		// Assuming you are sending email from localhost
		String host = "web02.hypoport.de";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			LOGGER.info("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
