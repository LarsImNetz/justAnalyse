package org.linuxx.moonserver.mailer.credentials;

final class LiveMailCredentials implements IMailCredentials {

	private static final String POP3_USERNAME = "baufi-reporting@csvupload.local";
	private static final String POP3_PASSWORD = "gcOwyqN4DZS";

	@Override
	public String getUsername() {
		return POP3_USERNAME;
	}

	@Override
	public String getPassword() {
		return POP3_PASSWORD;
	}

}
