package experiment.lars.java.parameter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestVarargsParameter {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSingle() throws Exception {
		Assert.assertEquals("Eins", testMethod("Eins"));
	}

	@Test
	public void testMoreStrings() throws Exception {
		Assert.assertEquals("EinsZweiDrei", testMethod("Eins", "Zwei", "Drei"));
	}

	@Test
	public void testWithStringArray() throws Exception {
		Assert.assertEquals("EinsZweiDrei",
				testMethod(new String[]{"Eins", "Zwei", "Drei"}));
	}

	@Test
	public void testWithStringArray2() throws Exception {
		final String[] strArray = {"Eins", "Zwei", "Drei"};

		Assert.assertEquals("EinsZweiDrei", testMethod(strArray));
	}

	@Test
	public void testIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Array leer");

		testMethod();
	}

	private String testMethod(final String... args) {
		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("Array leer");
		}
		final StringBuilder buf = new StringBuilder();
		for (final String s : args) {
			buf.append(s);
		}
		return buf.toString();
	}
}
