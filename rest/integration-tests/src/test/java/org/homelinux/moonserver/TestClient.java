package org.homelinux.moonserver;

import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClient {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	private static class IConfiguration {
		public String getUrl() {return "";}
	}
	
	private static class Name {
		
	};
	
	private static class BvoBeraterLoader {

		private static final Logger LOGGER = LoggerFactory.getLogger(BvoBeraterLoader.class);

		private final Client client;

		private final String nameUrl;

		@Inject
		public BvoBeraterLoader(final Client client, final IConfiguration config) {
			this.client = client;
			nameUrl = config.getUrl();
		}

		// @Override
		public List<Name> load() {
			// https://qa.relaunch.drklein.hypoport.local/jsonExport/berater/
			final List<Name> names = client.target(nameUrl).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Name>>() {});
			LOGGER.info("Loaded {} Berater from {}", names.size(), nameUrl);
			return names;
		}

	}

}
