package de.vergleich.sample;

import java.util.Locale;

import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import de.vergleich.sample.converter.DoubleWicketConverter;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see de.vergleich.sample.Start#main(String[])
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
	}

	@Override
	public Session newSession(Request request, Response response) {
		Session session = super.newSession(request, response);
		session.setLocale(Locale.GERMANY);
		return session;
	}

	@Override
	protected IConverterLocator newConverterLocator() {
		final ConverterLocator locator = new ConverterLocator();
		locator.set(Double.class, new DoubleWicketConverter());
		return locator;
	}
}
