package org.homelinux.moonserver;

import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import com.google.inject.Injector;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.homelinux.moonserver.JettyStart#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
//	private transient Injector injector;

	@Override
	public void init()
	{
		super.init();
		// add your configuration here

		initializeInjector();
	}

	private void initializeInjector() {
//		this.injector = Guice.createInjector(new VisibilityHelperModule());
//		getComponentInstantiationListeners().add(new GuiceComponentInjector(this, this.injector));
	}

	/**
	 * Mal auf Deutsch einstellen
	 */
	@Override
	public Session newSession(Request request, Response response) {
		// TODO Auto-generated method stub
		 Session newSession = super.newSession(request, response);
		 newSession.setLocale(Locale.GERMANY);
		 return newSession;
	}
}
