package apache.integration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import apache.HttpRedirectionTester;
import apache.VHostDirectoryReader;


@RunWith(Parameterized.class)
public class ITAllHttpRedirections {

	private HttpRedirectionTester tester;
	
	@Before
	public void before() {
		tester = new HttpRedirectionTester();
	}

	@Parameters(name = "{1}")
	public static Collection<Object[]> findAllTests() {
		final VHostDirectoryReader interpreter = new VHostDirectoryReader();
		final Collection<Object[]> configurationFiles = interpreter.findAllVHostFiles();

		final List<Object[]> list = new ArrayList<>();
		final Iterator<Object[]> iterator = configurationFiles.iterator();
		while(iterator.hasNext()) {
			final Object[] next = iterator.next();
			final File configFile = (File) next[0];
			final String name = (String) next[1];
			
			if (configFile != null) {
				append(list, configFile, name);
			}
		}
		return list;
	}

	private static void append(final List<Object[]> list, final File configFile, final String name) {
		list.add(new Object[] {configFile, name});
	}

//	@Test
//	public void test_www_meinzins_de() throws Exception {
//
//		final String url = "http://www.meinzins.de/";
//		final String expected = "https://www.vergleich.de/online/tagesgeld-vergleich";
//
//		tester.assertRedirectPermanently(url, expected);
//	}
	
	public ITAllHttpRedirections(final File configFile, final String testName) {
		this.configFile = configFile;
	}

	private final File configFile;

	/*
	 * Der eigentliche Test, der mit den Parametern zurecht kommen sollte.
	 */
	@Test
	public void test() {
		Assert.assertNotNull(configFile);
		Assert.assertTrue(configFile.exists());
		// tester.assertRedirectPermanently(url, "https://www.vergleich.de/");
	}

}
