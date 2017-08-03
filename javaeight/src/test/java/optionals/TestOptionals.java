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
	public void testOptional_orElse_A() {
		Optional<String> optionalRight = Optional.ofNullable("A");
		String actual = optionalRight.orElse("B");

		Assert.assertEquals("A", actual);
	}

	@Test
	public void testOptional_orElse_Null() {
		Optional<String> optionalRight = Optional.ofNullable(null);
		String actual = optionalRight.orElse("B");

		Assert.assertEquals("B", actual);
	}
	
	@Test
	public void testOptional_orElse_in_reduce() {
		List<String> list = Arrays.asList("Hello", null, "World");
		String actual = list.stream().reduce("", TestOptionals::concat);
		
		Assert.assertEquals("Hello-World", actual);
	}

	private static String quote(String a) {
		return "'" + a + "'";
	}

	private static String concat(String left, String right) {
		LOGGER.info("a: " + quote(left) + " b: " + quote(right));

		Optional<String> optionalRight = Optional.ofNullable(right);
		return left + optionalRight.orElse("-");
	}	
}
