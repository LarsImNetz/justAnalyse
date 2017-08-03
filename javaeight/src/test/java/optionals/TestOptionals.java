package optionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestOptionals {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestOptionals.class);

	@Test
	public void testOptional_isPresent() {
		String helloWorld = null;
		Optional<String> string = Optional.ofNullable(helloWorld);
		
		Assert.assertFalse(string.isPresent());
	}

	@Test
	public void testOptional_orElse() {
		List<String> list = Arrays.asList("Hello", null, "World");
		String actual = list.stream().reduce("", TestOptionals::concat);
		
		Assert.assertEquals("Hello-World", actual);
	}

	private static String quote(String a) {
		return "'" + a + "'";
	}

	private static String concat(String a, String b) {
		Optional<String> optionalB = Optional.ofNullable(b);
		LOGGER.info("a: " + quote(a) + " b: " + quote(b));
		return a + optionalB.orElse("-");
	}	
}
