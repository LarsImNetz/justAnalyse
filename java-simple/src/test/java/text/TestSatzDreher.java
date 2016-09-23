package text;

import org.junit.Assert;
import org.junit.Test;

public class TestSatzDreher {

	@Test
	public void testSatz() {
		SatzDreher satzDreher = new SatzDreher("Hello World");
		Assert.assertEquals("Hello World", satzDreher.getSatz());
	}

	@Test
	public void testGetVerdrehtenSatz() throws Exception {
		SatzDreher satzDreher = new SatzDreher("Dieser Satz sollte noch lesbar sein, auch wenn er etwas komisch aussieht.");
		System.out.println(satzDreher.getVerdrehtenSatz());
	}
	
	@Test
	public void testLongSentence() {
		String satz = "Wer jetzt bereits die Datenbank gefüllt hat, sollte diese bereinigen, nach dem die Stopwörter gesetzt wurden. Mit einem einfachen SQL-Statement kann die Relationen-Tabelle aufgeräumt werden. Dabei ist zu berücksichtigen, dass bei mehreren Millionen Datensätzen dieser Vorgang recht lange dauern kann. Ich empfehle daher die Abfrage mit einem LIMIT auszuführen, so dass nur eine begrenzte Zahl an Datensätzen gelöscht wird. Der Vorgang muss dann mehrfach wiederholt werden. Dabei kann LIMIT entsprechend der Reaktionszeit des Servers angepasst werden. Wer damit noch kein Erfahrung hat, sollte ggf. jemanden fragen, der sich ein wenig mit SQL auskennt.";
		SatzDreher satzDreher = new SatzDreher(satz);
		System.out.println(satzDreher.getVerdrehtenSatz());		
	}
}
