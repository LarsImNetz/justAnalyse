package org.homelinux.moonserver.guice.provider;

import java.net.URI;
import java.net.URISyntaxException;

import org.homelinux.moonserver.IWebservice;
import org.homelinux.moonserver.Webservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class WebserviceQAProvider implements Provider<IWebservice> {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebserviceQAProvider.class);

	@Inject
	private Injector injector;

	@Override
	public IWebservice get() {
		final Webservice webservice = new Webservice();
		injector.injectMembers(webservice);

		try {
			webservice.setUri(new URI(Webservice.QA_REST_URL));
		}
		catch (final URISyntaxException e) {
			LOGGER.error("Beim Setzen der URI fuer den Webservice ist ein Fehler aufgetreten", e);
		}

		return webservice;
	}

}
