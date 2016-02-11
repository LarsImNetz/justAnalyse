package org.homenet.moonserver.kontoimporter.buchung;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITestLineHandler {

	private LineHandler lineHandlerSUT;

	@Before
	public void setUp() {
		lineHandlerSUT = new LineHandler(new CSVLineSplitter(), new CSVBuchungFactory());
		// TODO: ich wünsche mir, das hier die CSVBuchungen zum lineHandler hinzugefügt werden können
		// lineHandler.add(new CSVBuchungFormat1());
		// lineHandler.add(new CSVBuchungFormat2014());
		// [...]		
	}

	@Test
	public void testBuchungFormat1() throws Exception {

		final String line = "Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung";
		IBuchung currentBuchung = lineHandlerSUT.handleCurrentLine(line, 1);

		Assert.assertNull(currentBuchung);

		final String line2 = "1.1.2014;1.1.2014;verwendungszweck;;10,00;EUR";
		currentBuchung = lineHandlerSUT.handleCurrentLine(line2, 1);

		Assert.assertEquals(new DateTime(2014, 1, 1, 0, 0), currentBuchung.getBuchungsdatum());
		Assert.assertEquals(Double.valueOf(10), currentBuchung.getHaben());
		Assert.assertEquals("verwendungszweck", currentBuchung.getVerwendungszweck());
		Assert.assertEquals(Double.valueOf(0), currentBuchung.getSoll());
	}

	@Test
	public void testBuchungFormat2012() throws Exception {

		final String line = "Buchungstag;Wert;Verwendungszweck;Soll;Haben;Währung";
		IBuchung currentBuchung = lineHandlerSUT.handleCurrentLine(line, 1);

		Assert.assertNull(currentBuchung);

		final String line2 = "1.1.2014;1.1.2014;verwendungszweck;;10,00;EUR";
		currentBuchung = lineHandlerSUT.handleCurrentLine(line2, 1);

		Assert.assertEquals(new DateTime(2014, 1, 1, 0, 0), currentBuchung.getBuchungsdatum());
		Assert.assertEquals(Double.valueOf(10), currentBuchung.getHaben());
		Assert.assertEquals("verwendungszweck", currentBuchung.getVerwendungszweck());
		Assert.assertEquals(Double.valueOf(0), currentBuchung.getSoll());
	}

	@Test
	public void testBuchungFormat2014() throws Exception {

		final String line = "Buchungstag;Wert;Umsatzart;Begünstigter / Auftraggeber;Verwendungszweck;IBAN;BIC;Kundenreferenz;Mandatsreferenz ;Gläubiger ID;Fremde Gebühren;Betrag;Abweichender Empfänger;Soll;Haben;Währung";
		IBuchung currentBuchung = lineHandlerSUT.handleCurrentLine(line, 1);

		Assert.assertNull(currentBuchung);

		final String line2 = "1.1.2014;1.1.2014;;;verwendungszweck;;;;;;;;;;10,00;EUR";
		currentBuchung = lineHandlerSUT.handleCurrentLine(line2, 1);

		Assert.assertEquals(new DateTime(2014, 1, 1, 0, 0), currentBuchung.getBuchungsdatum());
		Assert.assertEquals(Double.valueOf(10), currentBuchung.getHaben());
		Assert.assertEquals("verwendungszweck", currentBuchung.getVerwendungszweck());
		Assert.assertEquals(Double.valueOf(0), currentBuchung.getSoll());
	}

	@Test
	public void testBuchungFormat2015() throws Exception {

		final String line = "Buchungstag;Wert;Umsatzart;Begünstigter / Auftraggeber;Verwendungszweck;IBAN;BIC;Kundenreferenz;Mandatsreferenz ;Gläubiger ID;Fremde Gebühren;Betrag;Abweichender Empfänger;Anzahl der Aufträge;Soll;Haben;Währung";
		IBuchung currentBuchung = lineHandlerSUT.handleCurrentLine(line, 1);

		Assert.assertNull(currentBuchung);

		final String line2 = "1.1.2014;1.1.2014;;;verwendungszweck;;;;;;;;;;;10,00;EUR";
		currentBuchung = lineHandlerSUT.handleCurrentLine(line2, 1);

		Assert.assertEquals(new DateTime(2014, 1, 1, 0, 0), currentBuchung.getBuchungsdatum());
		Assert.assertEquals(Double.valueOf(10), currentBuchung.getHaben());
		Assert.assertEquals("verwendungszweck", currentBuchung.getVerwendungszweck());
		Assert.assertEquals(Double.valueOf(0), currentBuchung.getSoll());
	}

}
