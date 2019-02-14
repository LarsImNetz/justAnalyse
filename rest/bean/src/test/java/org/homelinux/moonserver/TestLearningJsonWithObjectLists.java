package org.homelinux.moonserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestLearningJsonWithObjectLists {

	private static final boolean NOT_STRICT = false;
	private static final boolean STRICT = true;

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
		System.out.println(json);
		JSONAssert.assertEquals("[{ 'name':'Luke'},{ 'name':'Leia'}]", json, STRICT);

		JSONAssert.assertEquals("[{},{}]", json, NOT_STRICT);
		JSONAssert.assertEquals("[{ 'name':'Luke'},{}]", json, NOT_STRICT);
		JSONAssert.assertEquals("[{ 'name':'Leia'},{}]", json, NOT_STRICT);
	}

}
