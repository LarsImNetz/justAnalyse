package org.homelinux.moonserver;

import java.io.IOException;
import java.time.LocalDate;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestLearningJsonWithLocaldate {

	private static final boolean NOT_STRICT = false;
	private static final boolean STRICT = true;

	private static class MyObject {
		private LocalDate date;

		public MyObject() {
			date = LocalDate.of(1997, 8, 22);
		}

		public LocalDate getDate() {
			return date;
		}
	}

	@Test
	public void testObject() throws JSONException, IOException {
		// HINT: man braucht in dem Objekt mindestens getter!
		Object aObject = new MyObject();

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(aObject);
		System.out.println(json);
		JSONAssert.assertEquals("{\"date\":{\"year\":1997,\"month\":\"AUGUST\",\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"},\"dayOfMonth\":22,\"dayOfWeek\":\"FRIDAY\",\"dayOfYear\":234,\"era\":\"CE\",\"monthValue\":8,\"leapYear\":false}}", json,
				STRICT);
	}

	@Test
	public void testLocalDateWithSerializer() throws JSONException, IOException {
		Object aObject = new MyObject();

		ObjectMapper mapper = new ObjectMapper();
		String name = "test";
		Version version = new Version(1, 0, 0, "");
		final SimpleModule module = new SimpleModule(name, version);
		module.addSerializer(LocalDate.class, new LocalDateSerializer());
		mapper.registerModule(module);

		final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aObject);
		System.out.println(json);
		JSONAssert.assertEquals("{\"date\":\"1997-08-22\"}", json, STRICT);
		JSONAssert.assertEquals("{}", json,	NOT_STRICT);
	}

}
