package org.linuxx.moonserver;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

/**
 * Startet einen Service
 *
 * TODO: Rausfinden, wie wir das Jar bauen müssen, damit das Teil so in einer Shell läuft.
 */
public class Main {

	private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		LOGGER.trace("start static main()");

		HttpServer server = HttpServerFactory.create( "http://localhost:8080/rest" );
		server.start();
		
		JOptionPane.showMessageDialog( null, "Ende" );
		server.stop( 0 );
		
	}
}
