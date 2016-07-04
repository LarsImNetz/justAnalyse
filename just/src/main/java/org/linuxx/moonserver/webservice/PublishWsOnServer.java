package org.linuxx.moonserver.webservice;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

public class PublishWsOnServer {

	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/services", new HelloWorld());
		JOptionPane.showMessageDialog(null, "OK klicken, um den aktuellen Server beenden?\nhttp://localhost:8080/services");
		endpoint.stop();
	}
}
