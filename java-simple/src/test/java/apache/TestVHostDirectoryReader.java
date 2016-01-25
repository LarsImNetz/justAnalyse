package apache;

import java.io.File;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class TestVHostDirectoryReader {
	@Test
	public void testFindConfigurationFiles() throws Exception {
		final VHostDirectoryReader interpreter = new VHostDirectoryReader();
		final Collection<Object[]> configurationFiles = interpreter.findAllVHostFiles();
		
		Assert.assertEquals(13, configurationFiles.size());
		
		final Object firstConfigurationFile = configurationFiles.iterator().next()[0];
		Assert.assertTrue(firstConfigurationFile instanceof File);

		final Object firstConfigurationName = configurationFiles.iterator().next()[1];
		Assert.assertTrue(firstConfigurationName instanceof String);
	}
}
