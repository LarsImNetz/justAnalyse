package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class Test2014CSVKontoInterpreter {

	private final File testFile2014 = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test2014.csv");
	private final CSVKontoInterpreter interpreter2014 = new CSVKontoInterpreter(testFile2014);

	@Test
	public void testTest2014FileExists() {
		Assert.assertTrue(testFile2014.exists());
	}


	@Test
	public void test2012KannLesen() {
		final List<IBuchung> buchungen = interpreter2014.interpret();

		Assert.assertEquals(3, buchungen.size());

	// 16.06.2014;16.06.2014;;;1246683090258355 AMAZON *MKTPLCE EU-DE LARS LANGHANS;;;;;;;;;-5,84;;EUR
		final IBuchung buchung = buchungen.get(0);
		Assert.assertEquals(new DateTime(2014, 6, 16,0,0), buchung.getBuchungsdatum());
		Assert.assertEquals("1246683090258355 AMAZON *MKTPLCE EU-DE LARS LANGHANS", buchung.getVerwendungszweck());
		Assert.assertEquals(-5.84, buchung.getSoll(), 0.001);
		Assert.assertEquals(null, buchung.getHaben());
	}
	
}
