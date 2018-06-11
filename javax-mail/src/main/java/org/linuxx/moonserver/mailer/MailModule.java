package org.linuxx.moonserver.mailer;

import javax.mail.Store;

import com.google.inject.AbstractModule;


public final class MailModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMailer.class).to(Mailer.class).asEagerSingleton();
		bind(Store.class).toProvider(SessionStoreProvider.class);
	}
}
