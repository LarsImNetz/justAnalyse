package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class TestCSVDirectoryReader {

	// Dieser Test wird fehlschlagen, sobald mehr test*.csv Dateien in den resourcen untergebracht werden
	@Test
	public void testCountConfigurationFiles() throws Exception {
		final CSVDirectoryReader reader = new CSVDirectoryReader(
				"src/test/resources/org/homenet/moonserver/kontoimporter", new SimpleCSVFilter());
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		Assert.assertEquals(4, csvFiles.size());

		final Object firstCSVFile = csvFiles.iterator().next()[0];
		Assert.assertTrue(firstCSVFile instanceof File);

		final Object firstCSVName = csvFiles.iterator().next()[1];
		Assert.assertTrue(firstCSVName instanceof String);
	}
}
