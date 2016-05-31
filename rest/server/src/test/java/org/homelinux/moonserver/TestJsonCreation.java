package org.homelinux.moonserver;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestJsonCreation {

	@Test
	public void testValue() {
		final Integer value = Integer.valueOf(3);
		final String json = ObjectMapperHelper.createJsonString(value);
		Assert.assertEquals("3", json);
	}

	@Test
	public void testString() {
		final String hello = "Hello World!";
		final String json = ObjectMapperHelper.createJsonString(hello);
		Assert.assertEquals("\"Hello World!\"", json);
	}

	@Test
	public void testArray() {
		final List<String> list = Arrays.asList("a", "b");
		final String json = ObjectMapperHelper.createJsonString(list);
		Assert.assertEquals("[\"a\",\"b\"]", json);
	}

	// -------------------------------------------------------------

	private static class A {

		int eins;

		public A(final int eins) {
			this.eins = eins;
		}
		
		public int getEins() {
			return this.eins;
		}

		public void setEins(final int eins) {
			this.eins = eins;
		}
	}

	@Test
	public void testClassA() {
		final A a = new A(2);

		final String json = ObjectMapperHelper.createJsonString(a);
		Assert.assertEquals("{\"eins\":2}", json);
	}

	// -------------------------------------------------------------
	private static class B {

		private String vorname;
		private String nachname;
		private LocalDateTime geburtstag;

		public B() {
		}

		
		public String getVorname() {
			return vorname;
		}

		
		public void setVorname(final String vorname) {
			this.vorname = vorname;
		}

		
		public String getNachname() {
			return nachname;
		}

		
		public void setNachname(final String nachname) {
			this.nachname = nachname;
		}

		
		public LocalDateTime getGeburtstag() {
			return geburtstag;
		}

		
		public void setGeburtstag(final LocalDateTime geburtstag) {
			this.geburtstag = geburtstag;
		}
		
	}

	@Test
	public void testClassBEmpty() {
		final B b = new B();
		
		final String json = ObjectMapperHelper.createJsonString(b);
		Assert.assertEquals("{\"vorname\":null,\"nachname\":null,\"geburtstag\":null}", json);
	}

	@Test
	public void testClassB() {
		final B b = new B();
		b.setVorname("Lars");
		b.setNachname("Langhans");
		b.setGeburtstag(geburtstag);
		final String json = ObjectMapperHelper.createJsonString(b);
		Assert.assertEquals("{\"vorname\":null,\"nachname\":null,\"geburtstag\":null}", json);
	}

}
