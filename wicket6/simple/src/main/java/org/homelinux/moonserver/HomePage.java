package org.homelinux.moonserver;

import java.util.Set;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	@SuppressWarnings("serial")
	public HomePage() {

		LOGGER.debug("HomePage of Simple Page");
		
		final Request request = getRequest();
		final Session session = getSession();
		
		final Url url = request.getOriginalUrl();
		final String ip = getOrigIPAddress();
		
		final IRequestParameters requestParameters = request.getRequestParameters();
		final Set<String> parameterNames = requestParameters.getParameterNames();
		final StringBuilder allNames = new StringBuilder();
		for (final String name: parameterNames) {
			allNames.append(name).append("\n");
		}
		System.out.println(allNames.toString());
	}
	
	public static String getOrigIPAddress() {
		final WebSession session = WebSession.get();
		final WebClientInfo info = session.getClientInfo();
		final String remoteAddress = info.getProperties().getRemoteAddress();
		System.out.println("ClientInfo: " + remoteAddress);
		return remoteAddress;
	}


}
