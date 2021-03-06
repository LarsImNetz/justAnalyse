package de.hypoport.einarbeitung.homepage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.hypoport.einarbeitung.ClientPage;
import de.hypoport.einarbeitung.HomePage;
import de.hypoport.einarbeitung.SecondPage;
import de.hypoport.einarbeitung.page.SinglePage;

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
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// add your configuration here

		mountPage("a", HomePage.class);
		mountPage("b", SecondPage.class);
		mountPage("ip", ClientPage.class);
		mountPage("c", SinglePage.class);
		this.getMarkupSettings().setStripWicketTags(true);
	}
}
