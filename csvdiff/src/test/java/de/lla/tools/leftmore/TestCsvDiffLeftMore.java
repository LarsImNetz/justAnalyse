package de.lla.tools.leftmore;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import de.lla.tools.CsvDiff;
import de.lla.tools.Option;

public class TestCsvDiffLeftMore {

	@Test
	public void testLeftExists() {
		String leftFilename = getPwd().getAbsolutePath() + "/leftmore.csv";
		Assert.assertTrue(leftFilename.endsWith("/leftmore.csv"));
		System.out.println(leftFilename);
		File left = new File(leftFilename);
		Assert.assertTrue(left.exists());
	}

	@Test
	public void test() throws IOException {
		String leftFilename = getPwd().getAbsolutePath() + "/leftmore.csv";
		String rightFilename = getPwd().getAbsolutePath() + "/.." + "/right.csv";
		File left = new File(leftFilename);
		File right = new File(rightFilename);

		Option options = new Option();
		options.setIgnoreMoreToken(true);
		CsvDiff app = new CsvDiff(left, right, options);

		app.workOnFiles();
		Assert.assertEquals("de.lla.tools.CsvDiff", app.getClass().getCanonicalName());
	}

	private File getPwd() {
		File aFile = new File("target/test-classes", this.getClass().getName().replace('.', '/') + ".class");
		return aFile.getParentFile();
	}
}
