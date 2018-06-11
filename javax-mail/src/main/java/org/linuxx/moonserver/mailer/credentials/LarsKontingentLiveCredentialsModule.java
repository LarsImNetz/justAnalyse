package org.linuxx.moonserver.mailer.credentials;

import com.google.inject.AbstractModule;

public final class LarsKontingentLiveCredentialsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMailCredentials.class).to(LiveMailCredentials.class);
	}

}
