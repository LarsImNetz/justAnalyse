package org.homelinux.moonserver;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ObjectMapperHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectMapperHelper.class);

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private ObjectMapperHelper() {}
	
	public static String createJsonString(final Object list) {
		String jsonString = "";
		try {
			jsonString = OBJECT_MAPPER.writer().writeValueAsString(list);
		}
		catch (final Exception e) {
			LOGGER.warn("Could not serialize bean into JSON string", e);
			return "";
		}

		return jsonString;
	}
}
