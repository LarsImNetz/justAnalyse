package de.hypoport.einarbeitung;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.WebRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientInfo {
	private static final Logger logger = LoggerFactory.getLogger(ClientInfo.class);

	public static String getOrigIPAddress() {
		WebSession session = WebSession.get();
		WebClientInfo info = (WebClientInfo) session.getClientInfo();
		final String remoteAddress = info.getProperties().getRemoteAddress();
		logger.info("ClientInfo: " + remoteAddress);
		return remoteAddress;
	}

	public static String getIPAddress() {

		// http://stackoverflow.com/questions/7769203/wicket-how-to-get-clients-ip-address
		WebRequest req = (WebRequest) RequestCycle.get().getRequest();
		if (req == null) {
			logger.info("WebRequest is null");
			return getOrigIPAddress();
		}

		String ip = req.getHeader("ClientIP");
		if (ip == null) {
			logger.info("Header for ClientIP not found");
			return getOrigIPAddress();
		}

		logger.info("clientip: " + ip);
		if (ip.contains(" ")) {
			return ip.split(" ")[0]; // uns interessiert nur der vordere Teil
		}
		return ip;
	}
}
