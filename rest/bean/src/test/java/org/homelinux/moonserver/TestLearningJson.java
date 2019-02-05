package org.homelinux.moonserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestLearningJson {

	private static final boolean NOT_STRICT = false;
	private static final boolean STRICT = false;

	@Test
	public void testInteger() throws JSONException, IOException {
		Integer i = 1;

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(i);
		JSONAssert.assertEquals("1", json, NOT_STRICT);
	}

	@Test
	public void testString() throws JSONException, IOException  {
		String value = "ein String";

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(value);
		JSONAssert.assertEquals("\"ein String\"", json, NOT_STRICT);
	}

	@Test
	public void testStringArray() throws JSONException, IOException {
		String[] array = { "a", "b", "c" };

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(array);
		JSONAssert.assertEquals("[ 'a', 'b','c' ]", json, NOT_STRICT);
	}

	@Test
	public void testStringList() throws JSONException, IOException {
		List<String> strings = new ArrayList<>();
		strings.add("Hallo");
		strings.add("World");

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(strings);
		JSONAssert.assertEquals("[ 'Hallo', 'World' ]", json, STRICT);
	}

	@Test
	public void testStringMap() throws JSONException, IOException {
		Map<String, String> strings = new HashMap<>();
		strings.put("1", "Hallo");
		strings.put("2", "World");

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(strings);
 		JSONAssert.assertEquals("{ '1':'Hallo', '2':'World' }", json, NOT_STRICT);
	}

	@Test
	public void testStringMapMap() throws JSONException, IOException {
		Map<String, Map<String, String>> strings = new HashMap<>();
		Map<String, String> innerMap = new HashMap<>();
		innerMap.put("1", "Hallo");
		innerMap.put("2", "World");
		strings.put("one", innerMap);

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(strings);
		JSONAssert.assertEquals("{ 'one': {'1':'Hallo', '2':'World'} }", json, NOT_STRICT);
	}

}
