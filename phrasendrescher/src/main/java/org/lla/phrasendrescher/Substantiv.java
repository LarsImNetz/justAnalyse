package org.lla.phrasendrescher;

/**
 * Das Substantiv
 * 
 * Auch bekannt als Nomen oder Hauptwort
 *
 */
public class Substantiv extends WortListe {

	/**
	 * Nimmt eine whitespace getrennte Wortliste entgegen
	 * @param liste
	 */
	public Substantiv(final String liste) {
		super(liste);
	}

	public Substantiv(final String liste, final String liste2) {
		super(liste, liste2);
	}
}
