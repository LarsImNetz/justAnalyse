package de.hypoport.einarbeitung;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.WebRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientInfo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientInfo.class);

	private ClientInfo() {}
	
	public static String getOrigIPAddress() {
		final WebSession session = WebSession.get();
		final WebClientInfo info = session.getClientInfo();
		final String remoteAddress = info.getProperties().getRemoteAddress();
		LOGGER.info("ClientInfo: " + remoteAddress);
		return remoteAddress;
	}

	public static String getIPAddress() {

		// http://stackoverflow.com/questions/7769203/wicket-how-to-get-clients-ip-address
		final WebRequest req = (WebRequest) RequestCycle.get().getRequest();
		if (req == null) {
			LOGGER.info("WebRequest is null");
			return getOrigIPAddress();
		}

		final String ip = req.getHeader("ClientIP");
		if (ip == null) {
			LOGGER.info("Header for ClientIP not found");
			return getOrigIPAddress();
		}

		LOGGER.info("clientip: " + ip);
		if (ip.contains(" ")) {
			return ip.split(" ")[0]; // uns interessiert nur der vordere Teil
		}
		return ip;
	}
}
