package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class Test2015CSVKontoInterpreter {

	private final File testFile2015 = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test2015.csv");
	private final CSVKontoInterpreter interpreter2015 = new CSVKontoInterpreter(testFile2015);

	@Test
	public void testTest2015FileExists() {
		Assert.assertTrue(testFile2015.exists());
	}

	@Test
	public void test2015KannLesen() {
		final List<IBuchung> buchungen = interpreter2015.interpret();

		Assert.assertEquals(8, buchungen.size());

		// 01.10.2015;01.10.2015;;;300913567084074181200008100 ELV65409121 30.09 13.56 ME7 SKY MARKT 810 SAGT DANKE 5084074;;;;;;;;;;-45,95;;EUR
		final IBuchung buchung = buchungen.get(0);
		Assert.assertEquals(new DateTime(2015, 10, 1, 0, 0), buchung.getBuchungsdatum());
		Assert.assertEquals("300913567084074181200008100 ELV65409121 30.09 13.56 ME7 SKY MARKT 810 SAGT DANKE 5084074", buchung.getVerwendungszweck());
		Assert.assertEquals(-45.95, buchung.getSoll(), 0.001);
		Assert.assertEquals(null, buchung.getHaben());
		
		// 07.12.2015;07.12.2015;;;Restbetrag Rechner;;;;;;;;;;;135,00;EUR
		final IBuchung buchung7 = buchungen.get(7);
		Assert.assertEquals(new DateTime(2015, 12, 7, 0, 0), buchung7.getBuchungsdatum());
		Assert.assertEquals("Restbetrag Rechner", buchung7.getVerwendungszweck());
		Assert.assertEquals(null, buchung7.getSoll());
		Assert.assertEquals(135d, buchung7.getHaben(), 0.001);
	}

}
