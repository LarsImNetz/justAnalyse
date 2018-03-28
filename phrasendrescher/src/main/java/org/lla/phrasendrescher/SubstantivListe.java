package org.lla.phrasendrescher;

/**
 * Das Substantiv
 * 
 * auch bekannt als Nomen oder Hauptwort
 *
 */
public class SubstantivListe extends WortListe {

	/**
	 * Nimmt eine whitespace getrennte Wortliste entgegen
	 * @param liste
	 */
	public SubstantivListe(final String liste) {
		super(liste);
	}

	/**
	 * Nimmt zwei whitespace getrennte Wortlisten entgegen, die als ein Wort zurückgegeben werden können
	 * @param liste
	 */
	public SubstantivListe(final String liste, final String liste2) {
		super(liste, liste2);
	}
}
