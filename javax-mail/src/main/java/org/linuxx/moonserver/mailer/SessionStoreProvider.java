package org.linuxx.moonserver.mailer;

import java.util.Properties;

import javax.inject.Provider;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

final class SessionStoreProvider implements Provider<Store> {

	private static final String POP3_HOST = "web02.hypoport.de";
	private static final String STORE_TYPE = "pop3";

	@Override
	public Store get() {
		final Properties properties = new Properties();
		properties.put("mail.pop3.host", POP3_HOST);
		final Session emailSession = Session.getInstance(properties);

		try {
			return emailSession.getStore(STORE_TYPE);
		}
		catch (final NoSuchProviderException e) {
			throw new IllegalStateException("Could not instantiate SessionStore", e);
		}
	}
}
