package org.linuxx.moonserver.mailer;

import java.io.IOException;

import javax.mail.MessagingException;

public interface IMailer {
	void start() throws MessagingException, IOException ;
	void deleteLast() throws Exception;
	void deleteOneDayOlds() throws Exception;
}
