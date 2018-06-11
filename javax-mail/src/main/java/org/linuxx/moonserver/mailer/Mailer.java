package org.linuxx.moonserver.mailer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Store;

import org.linuxx.moonserver.mailer.credentials.IMailCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mailer implements IMailer {
	private static Logger LOGGER = LoggerFactory.getLogger(Mailer.class);

	private final Store mailStore;
	private Folder mailFolder;

	private IMailCredentials credentials;

	@Inject
	public Mailer(Store store, IMailCredentials credentials) {
		this.mailStore = store;
		this.credentials = credentials;
	}

	@Override
	public void deleteOneDayOlds() throws Exception {
		LOGGER.info("start()");
		if (mailStore != null) {
			LOGGER.info("store exist");
		}

		mailStore.connect(credentials.getUsername(), credentials.getPassword());

		mailFolder = mailStore.getFolder("INBOX");
		mailFolder.open(Folder.READ_WRITE);
		int numOfMessages = mailFolder.getMessageCount();
		LOGGER.info("There exist {} messages", numOfMessages);

		boolean expungeMessages = false;
		if (numOfMessages > 0) {
			Message[] messages = mailFolder.getMessages();

			long twentyfourHoursOld = new Date().getTime() - (86400 * 1000);
			int count = 0;
			for (int currentMessageIndex = 0; currentMessageIndex < messages.length - 4; currentMessageIndex++) {
				final Message currentMessage = messages[currentMessageIndex];

				long sentDate = currentMessage.getSentDate().getTime();
				if (sentDate < twentyfourHoursOld) {
					count ++;
					currentMessage.setFlag(Flag.DELETED, true);
					
					expungeMessages = true;
				}
			}
			LOGGER.info("messages marked as deleted: {}", count);
		}
		mailFolder.close(expungeMessages);
		mailStore.close();
	}

	@Override
	public void deleteLast() throws Exception {
		LOGGER.info("start()");
		if (mailStore != null) {
			LOGGER.info("store exist");
		}

		mailStore.connect(credentials.getUsername(), credentials.getPassword());

		mailFolder = mailStore.getFolder("INBOX");
		mailFolder.open(Folder.READ_WRITE);
		int numOfMessages = mailFolder.getMessageCount();
		LOGGER.info("There exist {} messages", numOfMessages);

		if (numOfMessages > 0) {
			Message message = mailFolder.getMessage(1);
			LOGGER.info("Message 1 subject is : {}", message.getSubject());

			message.setFlag(Flag.DELETED, true);
		}
		mailFolder.close(true);
		mailStore.close();
	}
	
	
	@Override
	public void start() throws MessagingException, IOException {
		LOGGER.info("start()");
		if (mailStore != null) {
			LOGGER.info("store exist");
		}

		mailStore.connect(credentials.getUsername(), credentials.getPassword());

		mailFolder = mailStore.getFolder("INBOX");
		mailFolder.open(Folder.READ_ONLY);
		int numOfMessages = mailFolder.getMessageCount();
		LOGGER.info("There exist {} messages", numOfMessages);

		if (numOfMessages > 0) {
			Message message = mailFolder.getMessage(1);
			LOGGER.info("Message 1 subject is : {}", message.getSubject());
			Message[] messages = mailFolder.getMessages();

			int count = 1;
			for (int currentMessageIndex = messages.length - 1; currentMessageIndex >= 0; currentMessageIndex--) {
				final Message currentMessage = messages[currentMessageIndex];
				final String subject = currentMessage.getSubject();
				LOGGER.info("Message {} subject is : {}", currentMessageIndex, subject);

				if (currentMessage.isMimeType("multipart/*")) {
					Date sentDate = currentMessage.getSentDate();
					LOGGER.info("Message Date is : {}", getCurrentTimeStamp(sentDate));

					final Multipart mp = (Multipart) currentMessage.getContent();
					int mpCount = mp.getCount();
					LOGGER.info("Multipart Message erkannt mit {} parts.", mpCount);
				}

				// uns interessieren die letzten 4 messages
				count++;
				if (count > 4) {
					break;
				}
			}
		}
		else {
			LOGGER.warn("There exist no mails");		
		}
		mailFolder.close(false);
		mailStore.close();
	}

	private static String getCurrentTimeStamp(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfDate.format(date);
	}
}
