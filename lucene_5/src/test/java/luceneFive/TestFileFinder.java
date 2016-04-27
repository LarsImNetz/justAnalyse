package luceneFive;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import luceneFive.FileFinder;

public class TestFileFinder {

	@Test
	public void testName() throws Exception {
		final File file = new FileFinder("file2search").getFile();
		Assert.assertTrue(file.exists());
	}
}
