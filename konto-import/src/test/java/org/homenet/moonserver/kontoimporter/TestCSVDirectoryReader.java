package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class TestCSVDirectoryReader {
	@Test
	public void testFindConfigurationFiles() throws Exception {
		final CSVDirectoryReader interpreter = new CSVDirectoryReader(
				"src/test/resources/org/homenet/moonserver/kontoimporter");
		final Collection<Object[]> configurationFiles = interpreter.findAllVHostFiles();

		Assert.assertEquals(1, configurationFiles.size());

		final Object firstConfigurationFile = configurationFiles.iterator().next()[0];
		Assert.assertTrue(firstConfigurationFile instanceof File);

		final Object firstConfigurationName = configurationFiles.iterator().next()[1];
		Assert.assertTrue(firstConfigurationName instanceof String);
	}
}
