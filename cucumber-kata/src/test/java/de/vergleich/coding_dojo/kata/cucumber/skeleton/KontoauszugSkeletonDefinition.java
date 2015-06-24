package de.vergleich.coding_dojo.kata.cucumber.skeleton;

import org.junit.Assert;

import cucumber.api.java.de.Angenommen;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

/**
 * <pre>
 * Aufgabe: Bank account Kata
 * 
 * Es soll folgende Ausgaben unterstützen:
 * - Kontostandsabfrage
 * - Kontoauszug
 * -- Alle Posten anzeigen
 * -- Nur Einzahlungen anzeigen
 * -- Nur Auszahlungen anzeigen
 * -- Nur Überweisungen anzeigen
 * -- Nur Posten aus einem bestimmten Zeitraum anzeigen
 * 
 * 
 * Hinweise zu Cucumber:
 * - Cucumber-Test schreiben, Test ausführen, vorgeschlagene Definitionen kopieren, anpassen und mit Leben füllen
 * 
 * - Tabellen werden in der Form
 * 
 * | Überschrift 1 | Überschrift 2 |
 * | Wert 1        | Wert 2        |
 * 
 * geschrieben
 * 
 * - Datumspattern können beispielsweise mit
 * 
 * @When("Am (.+) habe ich nichts getan")
 * public void methodname(@Format("yyyy-MM-dd") Date date) {...}
 * 
 * geschrieben werden
 * 
 * - Schlüsselwörter für den Test
 * Feature    - Funktionalität
 * Background - Grundlage
 * Given      - Angenommen
 * Scenario   - Szenario
 * When       - Wenn
 * And        - Und
 * Then       - Dann
 * </pre>
 **/
public class KontoauszugSkeletonDefinition {

	private Kontoauszug auszug;
	private Bankkonto konto;

	@Angenommen("^es existiert ein Bankkonto mit (\\d+) Transaktionen$")
	public void es_existiert_ein_Bankkonto_mit_Transaktionen(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		konto = new Bankkonto();
		konto.deposit(100);
		konto.deposit(200);
	}

	@Angenommen("^dazu wurde ein Kontoauszug angefordert$")
	public void dazu_wurde_ein_Kontoauszug_angefordert() throws Throwable {
		auszug = new Kontoauszug(konto);
	}

	@Dann("^enthält mein Kontoauszug (\\d+) Einträge$")
	public void enthält_mein_Kontoauszug_Einträge(int transaktionen) throws Throwable {
		Assert.assertEquals(transaktionen, auszug.getAnzahlTransaktionen());
	}
}
