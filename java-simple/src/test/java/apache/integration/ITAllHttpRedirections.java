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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import apache.HttpRedirectionTester;
import apache.VHostDirectoryReader;
import apache.VHostInterpreter;
import apache.VirtualHost;

@RunWith(Parameterized.class)
public class ITAllHttpRedirections {

	private static Logger LOGGER = LoggerFactory.getLogger(ITAllHttpRedirections.class);

	private HttpRedirectionTester tester;

	@Before
	public void before() {
		tester = new HttpRedirectionTester();
	}

	@Parameters(name = "{1}, {0}, {3}")
	public static Collection<Object[]> findAllTests() {
		final VHostDirectoryReader configurationFileReader = new VHostDirectoryReader();
		final Collection<Object[]> configurationFiles = configurationFileReader.findAllVHostFiles();

		final List<Object[]> list = new ArrayList<>();
		final Iterator<Object[]> iterator = configurationFiles.iterator();
		// jede vhost.d/*.conf Datei
		while (iterator.hasNext()) {
			final Object[] next = iterator.next();
			final File vhostConfigurationFile = (File) next[0];
			final String vhostName = (String) next[1];

			if (vhostConfigurationFile != null) {
				final VHostInterpreter interpreter = new VHostInterpreter(vhostConfigurationFile);
				final List<VirtualHost> vhosts = interpreter.interpret();
				// jede <VirtualHost *> in einer vhost.d/*.conf Datei
				for (final VirtualHost vhost : vhosts) {
					final List<String> serverAliases = vhost.getServerAliases();
					if (serverAliases != null) {
						// jeder ServerAlias in einer <VirtualHost *> Definition
						for (final String serverAlias : serverAliases) {
							if (vhost.getRedirection() != null) {
								if (vhost.getRedirection().contains("www.vergleich.de")) {
									append(list, serverAlias, vhost, vhost.getRedirection(), vhostName);
								}
							}
						}
					}
					else {
						LOGGER.warn(vhostName + " in <VirtualHost> " + vhost.getServerName() + " enthält keine ServerAliases.");
					}
				}
			}
		}
		return list;
	}

	private static void append(final List<Object[]> list, final String serverAlias, final VirtualHost vhost, final String redirectionUrl, final String name) {
		list.add(new Object[] {serverAlias, name, vhost, redirectionUrl});
	}

	//	@Test
	//	public void test_www_meinzins_de() throws Exception {
	//
	//		final String url = "http://www.meinzins.de/";
	//		final String expected = "https://www.vergleich.de/online/tagesgeld-vergleich";
	//
	//		tester.assertRedirectPermanently(url, expected);
	//	}

	public ITAllHttpRedirections(final String serverAlias, final String testName, final VirtualHost virtualHost, final String redirectionUrl) {
		this.serverAlias = serverAlias;
		this.virtualHost = virtualHost;
		this.testName = testName;
		this.redirectionUrl = redirectionUrl;
	}

	private final String serverAlias;
	private final VirtualHost virtualHost;
	private final String testName;
	private final String redirectionUrl;

	/*
	 * Der eigentliche Test, der mit den Parametern zurecht kommen sollte.
	 */
	@Test
	public void test() {
		Assert.assertNotNull(virtualHost);
		final String serverAliasUrl = "http://" + serverAlias;
		tester.init(serverAliasUrl);
		if (tester.getStatusCode() != 301) {
			System.out.println("HINWEIS: http://" + serverAlias + " zeigt auf " + redirectionUrl + " liefert nicht 301 sondern: " + tester.getStatusCode());
		}
		tester.assertRedirectPermanently(serverAliasUrl, redirectionUrl);
	}

}
