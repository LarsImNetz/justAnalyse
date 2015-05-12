package experiment.lars.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class TestSimpleCodehausJacksonJson {

	public static class Pojo {

		@JsonIgnore
		public String egal = "egal";

		public String foo;
	}

	@Test
	public void testWriteAndDeserialize() throws JsonGenerationException, JsonMappingException, IOException {

		final String foo = "one";

		final Pojo pojo = new Pojo();
		pojo.foo = foo;

		final String expected = "{\"foo\":\"" + foo + "\"}";

		final ObjectMapper objectMapper = new ObjectMapper();
		final String output = objectMapper.writeValueAsString(pojo);
		assertEquals(expected, output);

		final Pojo deserialized = objectMapper.readValue(output, Pojo.class);
		assertEquals(foo, deserialized.foo);
	}
}
