package apache;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;

public class HttpRedirectionTester {

	public HttpRedirectionTester() {
	}

	public void assertRedirectPermanently(final String url, final String newLocation) {
		initialize(url);
		Assert.assertEquals(HttpStatus.SC_MOVED_PERMANENTLY, getStatusCode());
		Assert.assertEquals(newLocation, getLocation());
	}

	public void assertRedirectTemporarily(final String url, final String newLocation) {
		initialize(url);
		Assert.assertEquals(HttpStatus.SC_MOVED_TEMPORARILY, getStatusCode());
		Assert.assertEquals(newLocation, getLocation());
	}

	private CloseableHttpResponse response;

	private void initialize(final String url) {
		final CloseableHttpClient httpclient = HttpClients.createDefault();

		final Builder custom = RequestConfig.custom();

		custom.setRedirectsEnabled(false);
		final RequestConfig config = custom.build();

		final HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(config);

		try {
			response = httpclient.execute(httpGet);
			httpclient.close();
		}
		catch (final Exception e) {
			Assert.fail("Exception caught: " + e.getMessage());
		}
	}

	public int getStatusCode() {
		Assert.assertNotNull("initialize nicht ausgeführt?", response);
		return response.getStatusLine().getStatusCode();
	}

	public String getLocation() {
		Assert.assertNotNull("initialize nicht ausgeführt?", response);
		final String location = response.getFirstHeader("Location").getValue();
		return location;
	}
}
