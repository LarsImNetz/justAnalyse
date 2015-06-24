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
public class BankkontoSkeletonDefinition {

	private Bankkonto konto;
	private Kontoauszug auszug;
	
	@Angenommen("^ich lege ein Bankkonto an$")
	public void ich_lege_ein_Bankkonto_an() throws Throwable {
		konto = new Bankkonto();
	}

	@Wenn("^ich ein Bankkonto anlege$")
	public void ich_ein_Bankkonto_anlege() throws Throwable {
	}

	@Dann("^habe ich ein Bankkonto$")
	public void habe_ich_ein_Bankkonto() throws Throwable {
		Assert.assertNotNull(konto);
	}

	@Dann("^es ist leer$")
	public void es_ist_leer() throws Throwable {
		Assert.assertEquals(0, konto.getDeposit());
	}
	
	@Wenn("^ich (\\d+) Euro einzahle$")
	public void ich_Euro_einzahle(int einzahlung) throws Throwable {
		konto.deposit(einzahlung);
	}

	@Dann("^beträgt der Kontostand (\\d+) Euro$")
	public void beträgt_der_Kontostand_Euro(int einzahlung) throws Throwable {
		Assert.assertEquals(einzahlung, konto.getDeposit());
	}
	
	@Wenn("^ich (\\d+) Euro abhebe$")
	public void ich_Euro_abhebe(int auszahlung) throws Throwable {
		konto.withdraw(auszahlung);
	}
	
	@Wenn("^ich einen Kontoauszug anfordere$")
	public void ich_einen_Kontoauszug_anfordere() throws Throwable {
	    auszug = konto.getKontoauszug();
	}

	@Dann("^erhalte ich einen Kontoauszug$")
	public void erhalte_ich_einen_Kontoauszug() throws Throwable {
	    Assert.assertNotNull(auszug);
	}
}
