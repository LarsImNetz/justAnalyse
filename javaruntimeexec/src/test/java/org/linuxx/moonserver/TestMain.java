package org.linuxx.moonserver;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class TestMain {

	/*
	 * HINT: Wenn dieser test fehlschlägt, dann weil die class Main umbenannt oder
	 * verschoben wurde Dann unbedingt auch die pom.xml anpassen
	 * (maven-assembly-plugin artifact plugin)
	 */
	@Test
	public void test() {
		Main app = new Main();
		Assert.assertEquals("org.linuxx.moonserver.Main", app.getClass().getCanonicalName());
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
