package org.homenet.moonserver.kontoimporter.classification;

import org.homenet.moonserver.kontoimporter.buchung.CSVBuchung;
import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.junit.Assert;
import org.junit.Test;

public class TestLarsClassification {

	@Test
	public void testClassifyIBuchung() throws Exception {
		final String[] buchung1 = {"1.1.2000", "1.1.2000", "yyyGA NRxxx", "", "1", "EUR"};
		final IBuchung buchungOne = new CSVBuchung(buchung1);

		final LarsClassification classification = new LarsClassification();
		Assert.assertEquals(ClassificationEnum.GELDAUTOMAT, classification.classify(buchungOne));
	}

}
