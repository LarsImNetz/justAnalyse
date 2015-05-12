package experiment.lars.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestAnnotationJson {

	public static class Pojo {

		@JsonIgnore
		private final String toIgnore = "ignore";

		@JsonProperty("foo")
		private final String a;

		@JsonProperty("b")
		@JsonInclude(value = Include.NON_EMPTY)
		private String nullableB;

		@JsonProperty("c")
		@JsonInclude(value = Include.NON_NULL)
		private String notNullC;

		public Pojo() {
			a = null;
		}

		public Pojo(final String a) {
			this.a = a;
			this.nullableB = null;
		}

		public Pojo(final String a, final String b) {
			this.a = a;
			this.nullableB = b;
			this.notNullC = null;
		}

		public Pojo(final String a, final String b, final String c) {
			this.a = a;
			this.nullableB = b;
			this.notNullC = c;
		}

		public String getA() {
			return a;
		}

		public String getB() {
			return nullableB;
		}

		public void setB(final String nullableB) {
			this.nullableB = nullableB;
		}
	}

	@Test
	public void testWriteAndDeserialize_withoutB() throws JsonGenerationException, JsonMappingException, IOException {

		final String foo = "one";

		final Pojo pojo = new Pojo(foo);

		final String expected = "{\"foo\":\"" + foo + "\"}";

		final ObjectMapper objectMapper = new ObjectMapper();
		final String output = objectMapper.writeValueAsString(pojo);
		assertEquals(expected, output);

		final Pojo deserialized = objectMapper.readValue(output, Pojo.class);
		assertEquals(foo, deserialized.getA());
	}

	@Test
	public void testWriteAndDeserialize_withB() throws JsonGenerationException, JsonMappingException, IOException {

		final String foo = "one";
		final String b = "two";

		final Pojo pojo = new Pojo(foo, b);

		final String expected = "{\"b\":\"" + b + "\",\"foo\":\"" + foo + "\"}";

		final ObjectMapper objectMapper = new ObjectMapper();
		final String output = objectMapper.writeValueAsString(pojo);
		assertEquals(expected, output);

		final Pojo deserialized = objectMapper.readValue(output, Pojo.class);
		assertEquals(foo, deserialized.getA());
		assertEquals(b, deserialized.getB());
	}

	@Test
	public void testWriteAndDeserialize_withBAndC() throws JsonGenerationException, JsonMappingException, IOException {

		final String foo = "one";
		final String b = "two";
		final String c = "three";

		final Pojo pojo = new Pojo(foo, b, c);

		final String expected = "{\"b\":\"" + b + "\",\"foo\":\"" + foo + "\",\"c\":\"" + c + "\"}";

		final ObjectMapper objectMapper = new ObjectMapper();
		final String output = objectMapper.writeValueAsString(pojo);
		assertEquals(expected, output);

		final Pojo deserialized = objectMapper.readValue(output, Pojo.class);
		assertEquals(foo, deserialized.getA());
		assertEquals(b, deserialized.getB());
	}
}
