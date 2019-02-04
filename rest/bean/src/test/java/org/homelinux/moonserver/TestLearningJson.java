package org.homelinux.moonserver;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.omg.DynamicAny.NameValuePair;
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

	@Test
	public void testNameValuePair()  throws Exception {
		 BasicNameValuePair pair = new BasicNameValuePair("key", "value");
		 
		 // NameValuePair[] array = {{"vorname","Testy"},{"nachname", "McTest"}};

		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pair);
		System.out.println(json);
		// TODO: JSONAssert.assertEquals("[ 'a', 'b' ]", json, false);
	}

}
