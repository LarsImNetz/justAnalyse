package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class TestCSVDirectoryReader {

	private static String baseFolder = "src/test/resources/org/homenet/moonserver/kontoimporter";

	@Test
	public void testCheckExistance() {
		final File baseFolderFile = new File(baseFolder);
		Assert.assertTrue("base folder must exist.", baseFolderFile.exists());
	}

	/**
	 * Dieser Test wird fehlschlagen, sobald mehr test*.csv Dateien in den
	 * Ressourcen untergebracht werden
	 */
	@Test
	public void testCountConfigurationFiles() throws Exception {
		final File baseFolderFile = new File(baseFolder);

		final CSVDirectoryReader reader = new CSVDirectoryReader(baseFolderFile, new SimpleCSVFilter());
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		Assert.assertEquals(5, csvFiles.size());

		final Object firstCSVFile = csvFiles.iterator().next()[0];
		Assert.assertTrue(firstCSVFile instanceof File);

		final Object firstCSVName = csvFiles.iterator().next()[1];
		Assert.assertTrue(firstCSVName instanceof String);
	}
}
