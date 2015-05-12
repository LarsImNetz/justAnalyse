package experiment.lars.java.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestStringBuilder {

	@Test
	public void test() {
		StringBuilder builder = new StringBuilder();
		String hallo = builder.append("Hallo").append(" ").append("Welt").toString();

		Assert.assertEquals("Hallo Welt", hallo);
	}

	@Test
	public void testName() {
		StringBuilder builder = new StringBuilder();
		builder.append("hallo");
		builder.reverse();

		Assert.assertEquals("ollah", builder.toString());
	}
}
