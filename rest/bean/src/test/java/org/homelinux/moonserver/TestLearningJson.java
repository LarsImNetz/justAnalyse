package org.homelinux.moonserver;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestLearningJson {

	@Test
	public void testInteger()  throws Exception {
		Integer i = 1;

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(i);
		System.out.println(json);
		JSONAssert.assertEquals("1", json, false);
	}

	@Test
	public void testString()  throws Exception {
		String value = "ein String";

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(value);
		System.out.println(json);
		JSONAssert.assertEquals("\"ein String\"", json, false);
	}

	@Test
	public void testStringArray()  throws Exception {
		String[] array = {"a", "b"};

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(array);
		System.out.println(json);
		JSONAssert.assertEquals("[ 'a', 'b' ]", json, false);
	}

}
