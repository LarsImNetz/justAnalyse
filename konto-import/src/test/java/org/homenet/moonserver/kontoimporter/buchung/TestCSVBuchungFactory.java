package org.homenet.moonserver.kontoimporter.buchung;

import org.junit.Assert;
import org.junit.Test;

public class TestCSVBuchungFactory {

	private final CSVBuchungFactory csvBuchungFactory = new CSVBuchungFactory();

	@Test
	public void testFormat1() throws Exception {
		final String[] split = {"1.1.2013", "1.1.2013", "Verwendungszweck", "", "11,00", "EUR"};
		final IBuchung buchung = csvBuchungFactory.create(BuchungFormatEnum.format1, split);
		Assert.assertEquals(CSVBuchungFormat1.class, buchung.getClass());
	}
}
