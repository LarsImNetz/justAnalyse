package org.homelinux.moonserver;

import java.util.Enumeration;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
		
		// Beispielchen, wie man unter Wicket an den HTML Header kommt.
		final Request request = getRequest();
		final HttpServletRequest servletRequest = (HttpServletRequest)request.getContainerRequest();
		final String contextPath = servletRequest.getContextPath();
		final String characterEncoding = servletRequest.getCharacterEncoding();
		final Enumeration headerNames = servletRequest.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			final Object element = headerNames.nextElement();
			if (element instanceof String) {
				final String elementKey = (String)element;
				System.out.println(elementKey + ":=" + servletRequest.getHeader(elementKey));
			}
		}
		
		// final RequestCycle requestCycle = getRequestCycle();
		
		// final Session session = getSession();
		
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
