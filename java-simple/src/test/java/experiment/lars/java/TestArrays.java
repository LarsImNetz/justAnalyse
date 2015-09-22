package experiment.lars.java;

import org.junit.Assert;
import org.junit.Test;

public class TestArrays {

	@Test
	public void testOneElementArray() {
		final String[] str = {"eins"};

		Assert.assertEquals(1, str.length);
		Assert.assertEquals("eins", str[0]);
	}

	@Test
	public void testOneElementArray2() {
		final String[] str = {"eins", "zwei"};

		Assert.assertEquals(2, str.length);
		Assert.assertEquals("eins", str[0]);
		Assert.assertEquals("zwei", str[1]);
	}

	@Test
	public void testOneElementArray3() {
		final String[] str = {"eins", "zwei", "drei"};

		final String[] str2 = new StringHelper().cdr(str);
		
		Assert.assertEquals(2, str2.length);
		Assert.assertEquals("zwei", str2[0]);
		Assert.assertEquals("drei", str2[1]);
	}
	
	private static class StringHelper {
		public StringHelper() {}
		
		public String[] cdr(final String... strings) {
			if (strings == null || strings.length == 0) {
				throw new IllegalArgumentException("Array sollte mindestens ein Element enthalten");
			}

			final String[] newStrings = new String[strings.length - 1];
			for(int i=1;i<strings.length;i++) {
				newStrings[i - 1] = strings[i];
			}
			return newStrings;
		}
	}
}
