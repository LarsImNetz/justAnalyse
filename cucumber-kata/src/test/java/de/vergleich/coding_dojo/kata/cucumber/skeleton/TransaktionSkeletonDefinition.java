package de.vergleich.coding_dojo.kata.cucumber.skeleton;

import org.junit.Assert;

import cucumber.api.java.de.Angenommen;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

/**
 * <pre>
 * Aufgabe: Bank account Kata
 * 
 * Implementiere ein Bank-Konto, das folgende Transaktionen kennt:
 * - Einzahlung
 * - Auszahlung
 * - Überweisung
 * 
 * Eine Transaktion soll dabei bestehen aus:
 * - Transaktionsdatum
 * - Art der Transaktion
 * - Wert der Transaktion
 * --> Beispielsweise 10.05.2015 Einzahlung 500 Euro
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
public class TransaktionSkeletonDefinition {

	private Transaktion transaktion;

	@Wenn("^ich (\\d+) Euro in ein Konto einzahle$")
	public void ich_Euro_in_ein_Konto_einzahle(int arg1) throws Throwable {
		transaktion = new Transaktion(arg1);
	}

	@Dann("^habe ich (\\d+) Euro in einer Transaktion$")
	public void habe_ich_Euro_in_einer_Transaktion(int arg1) throws Throwable {
		Assert.assertEquals(arg1, transaktion.getWert());
	}

	@Dann("^es existiert ein Datum$")
	public void es_existiert_ein_Datum() throws Throwable {
		Assert.assertNotNull(transaktion.getDatum());
	}

}
