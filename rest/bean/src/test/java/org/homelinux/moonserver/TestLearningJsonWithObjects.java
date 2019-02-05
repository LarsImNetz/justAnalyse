package org.homelinux.moonserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestLearningJsonWithObjects {

	private static final boolean NOT_STRICT = false;
	private static final boolean STRICT = true;

	@Test
	public void testNameValuePair() throws JSONException, IOException {
		BasicNameValuePair pair = new BasicNameValuePair("ein Name", "ein Value");

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pair);
		JSONAssert.assertEquals("{'value':'ein Value','name':'ein Name'}", json, NOT_STRICT);
	}

	private static class MyInnerObject {
		private String innerValue;

		public MyInnerObject() {
			innerValue = "a inner value";
		}

		public String getInnerValue() {
			return innerValue;
		}
	}

	private static class MyObject {
		private String name;
		private Integer wert;
		private MyInnerObject innerObject;

		public MyObject() {
			name = "Hello";
			wert = 1;
			innerObject = new MyInnerObject();
		}

		public String getName() {
			return name;
		}

		public Integer getWert() {
			return wert;
		}

		public MyInnerObject getInnerObject() {
			return innerObject;
		}
	}

	@Test
	public void testObject() throws JSONException, IOException {
		// HINT: man braucht in dem Objekt mindestens getter!
		Object aObject = new MyObject();

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(aObject);
		JSONAssert.assertEquals("{ 'name':'Hello', 'wert':1,'innerObject':{'innerValue':'a inner value'} }", json,
				STRICT);
	}

	private static class Name {
		private String name;

		public Name(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	@Test
	public void testListOfName() throws JSONException, IOException {
		List<Name> names = new ArrayList<>();
		names.add(new Name("Luke"));
		names.add(new Name("Leia"));

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(names);
		JSONAssert.assertEquals("[{ 'name':'Luke'},{ 'name':'Leia'}]", json, STRICT);

		JSONAssert.assertEquals("[{},{}]", json, NOT_STRICT);
		JSONAssert.assertEquals("[{ 'name':'Luke'},{}]", json, NOT_STRICT);
		JSONAssert.assertEquals("[{ 'name':'Leia'},{}]", json, NOT_STRICT);
	}

}
