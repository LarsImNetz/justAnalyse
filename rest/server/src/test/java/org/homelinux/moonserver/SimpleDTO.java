package org.homelinux.moonserver;

import java.time.LocalDate;

// -------------------------------------------------------------
final class SimpleDTO {

	private String vorname;
	private String nachname;
	private LocalDate geburtstag;

	public SimpleDTO() {
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(final String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(final String nachname) {
		this.nachname = nachname;
	}

	public LocalDate getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(final LocalDate geburtstag) {
		this.geburtstag = geburtstag;
	}

}
