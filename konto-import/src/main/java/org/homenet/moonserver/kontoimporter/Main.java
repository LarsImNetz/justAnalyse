package org.homenet.moonserver.kontoimporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Main {

	private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	static {
		LOGGER.trace("init static stuff()");
	}

	public Main() {
		LOGGER.trace("c'tor main()");
	}

	public static void main(String[] args) {
		LOGGER.trace("start static main()");
		Main main = new Main();
		main.helloWorld();
		LOGGER.trace("end main()");
	}

	public void helloWorld() {
		LOGGER.trace("start helloWorld()");
		try {
			System.out.println("Hello World!");
			LOGGER.trace("end helloWorld()");
			return;
		}
		catch (RuntimeException e) {
			LOGGER.error("Sollte nicht kommen!");
		}
		finally {
			LOGGER.trace("finally try in helloWorld()");
		}
		LOGGER.trace("will not arrive in helloWorld()");
	}
}
