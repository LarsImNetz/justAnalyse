package org.linuxx.moonserver.mailer.credentials;

final class QAMailCredentials implements IMailCredentials {

	/*
	 * Informationen für Outlook:
	 * Name: baufi-qa-lars-reporting
	 * E-Mail-Adresse: baufi-reporting-qa@csvupload.local
	 * Kontotyp: POP3
	 * Posteingangsserver: web02.hypoport.de
	 * Postausgangsserver: web02.hypoport.de
	 * Benutzername: baufi-reporting-qa@csvupload.local
	 * Kennwort: pO9rGeojRZQ
	 * 
	 * Damit sollte die Anmeldung über Outlook klappen.
	 */
	private static final String POP3_USERNAME = "baufi-reporting-qa@csvupload.local";
	private static final String POP3_PASSWORD = "pO9rGeojRZQ";

	@Override
	public String getUsername() {
		return POP3_USERNAME;
	}

	@Override
	public String getPassword() {
		return POP3_PASSWORD;
	}

}
