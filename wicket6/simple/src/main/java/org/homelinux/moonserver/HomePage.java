package org.homelinux.moonserver;

import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	@SuppressWarnings("serial")
	public HomePage() {

		LOGGER.debug("HomePage of Simple Page");

	}
}
