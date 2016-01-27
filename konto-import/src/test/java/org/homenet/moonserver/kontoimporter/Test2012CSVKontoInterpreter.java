package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class Test2012CSVKontoInterpreter {

	private final File testFile2012 = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test2012.csv");
	private final CSVKontoInterpreter interpreter2012 = new CSVKontoInterpreter(testFile2012);

	@Test
	public void testTest2012FileExists() {
		Assert.assertTrue(testFile2012.exists());
	}

	@Test
	public void test2012KannLesen() {
		final List<IBuchung> buchungen = interpreter2012.interpret();

		Assert.assertEquals(1, buchungen.size());

		// 31.10.2011;31.10.2011;"GA NR07303311 BLZ2307070008 29.10/10.52UHR LUEBECK 33";-20,00;;EUR
		final IBuchung buchung = buchungen.get(0);
		Assert.assertEquals(new DateTime(2011, 10, 31,0,0), buchung.getBuchungsdatum());
		Assert.assertEquals("GA NR07303311 BLZ2307070008 29.10/10.52UHR LUEBECK 33", buchung.getVerwendungszweck());
		Assert.assertEquals(-20d, buchung.getSoll(), 0.001);
		Assert.assertEquals(null, buchung.getHaben());
	}
	
}
