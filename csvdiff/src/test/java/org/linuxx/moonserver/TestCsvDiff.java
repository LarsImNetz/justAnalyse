package org.linuxx.moonserver;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestCsvDiff {

	@Test
	public void testLeftExists() {
		String leftFilename = getPwd().getAbsolutePath() + "/left.csv";
		Assert.assertTrue(leftFilename.endsWith("/left.csv"));
		System.out.println(leftFilename);
		File left = new File(leftFilename);
		Assert.assertTrue(left.exists());
	}

	@Test
	public void testRightExists() {
		String rightFilename = getPwd().getAbsolutePath() + "/right.csv";
		Assert.assertTrue(rightFilename.endsWith("/right.csv"));
		File right = new File(rightFilename);
		Assert.assertTrue(right.exists());
	}

	/*
	 * HINT: Wenn dieser test fehlschlägt, dann weil die class Main umbenannt
	 * oder verschoben wurde Dann unbedingt auch die pom.xml anpassen
	 * (maven-assembly-plugin artifact plugin)
	 */
	@Test
	public void test() throws IOException {
		String leftFilename = getPwd().getAbsolutePath() + "/left.csv";
		String rightFilename = getPwd().getAbsolutePath() + "/right.csv";
		File left = new File(leftFilename);
		File right = new File(rightFilename);

		CsvDiff app = new CsvDiff(left, right);
		app.workOnFiles();
		Assert.assertEquals("org.linuxx.moonserver.CsvDiff", app.getClass().getCanonicalName());
	}

	@Test
	public void testPwd() {
		System.out.println(getPwd().getAbsolutePath());
	}

	private File getPwd() {
		File aFile = new File("target/test-classes", this.getClass().getName().replace('.', '/') + ".class");
		return aFile.getParentFile();
	}

}
