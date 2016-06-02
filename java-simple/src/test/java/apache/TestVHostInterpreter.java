package apache;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestVHostInterpreter {

	private final File testFile = new File("src/test/resources/apache/test.conf");
	private final VHostInterpreter interpreter = new VHostInterpreter(testFile);

	@Test
	public void testTestFileExists() {
		Assert.assertTrue(testFile.exists());
	}

	@Test
	public void testInterpreter() {

		final List<VirtualHost> virtualHosts = interpreter.interpret();
		Assert.assertNotNull(virtualHosts);
		Assert.assertEquals(3, virtualHosts.size());
	}
	
	@Ignore
	@Test
	public void testVirtualHost1_full() {
		final List<VirtualHost> virtualHosts = interpreter.interpret();
		final VirtualHost virtualHost = virtualHosts.get(0);
		Assert.assertEquals("email", virtualHost.serverAdmin);
		Assert.assertEquals("name", virtualHost.serverName);

		Assert.assertEquals(2, virtualHost.serverAliases.size());
		Assert.assertEquals("permanent", virtualHost.redirect.state);
		Assert.assertEquals("/", virtualHost.redirect.filter);
		Assert.assertEquals("https://www.vergleich.de/", virtualHost.redirect.url);
	}

	@Ignore
	@Test
	public void testVirtualHost3_redirectmatch() {
		final List<VirtualHost> virtualHosts = interpreter.interpret();
		final VirtualHost virtualHost = virtualHosts.get(2);

		Assert.assertEquals("301", virtualHost.redirect.state);
		Assert.assertEquals("(.*)", virtualHost.redirect.filter);
		Assert.assertEquals("http://www.qualitypool.de", virtualHost.redirect.url);
	}
}
