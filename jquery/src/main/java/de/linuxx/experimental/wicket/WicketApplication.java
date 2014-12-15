package de.linuxx.experimental.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.linuxx.experimental.jquery.animation.APage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 *
 * @see org.homelinux.moonserver.JettyStart#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
//		return HomePage.class;
		return null;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// add your configuration here
		mountPage("/animation", APage.class);
//		mountPage("a", HomePage.class);
		this.getMarkupSettings().setStripWicketTags(true);
	}
}
