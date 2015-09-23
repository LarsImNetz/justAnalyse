package experiment.lars.java.path;

import org.junit.Assert;
import org.junit.Test;

public class TestPathProvider {

	@Test
	public void testName() throws Exception {
		final PathProvider pathProviderSUT = new PathProvider("src", "test", "resources", "config-test.properties");
		final String jobFileName = pathProviderSUT.getJobFileName();
		Assert.assertTrue(
				jobFileName.endsWith("src/test/resources/config-test.properties") || jobFileName.endsWith("src\\test\\resources\\config-test.properties"));
	}

	@Test
	public void testNameOneDeeper() throws Exception {
		final PathProvider pathProviderSUT = new PathProvider("java-simple", "src", "test", "resources", "config-test.properties");
		final String jobFileName = pathProviderSUT.getJobFileName();
		Assert.assertTrue(
				jobFileName.endsWith("src/test/resources/config-test.properties") || jobFileName.endsWith("src\\test\\resources\\config-test.properties"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongPath() throws Exception {
		new PathProvider("src", "egal", "resources", "config-test.properties");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongFile2() throws Exception {
		new PathProvider("src", "test", "resources", "gibbets-nicht");
	}
}
