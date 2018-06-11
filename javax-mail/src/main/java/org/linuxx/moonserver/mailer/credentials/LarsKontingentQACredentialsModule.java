package org.linuxx.moonserver.mailer.credentials;

import com.google.inject.AbstractModule;

public final class LarsKontingentQACredentialsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMailCredentials.class).to(QAMailCredentials.class);
	}

}
