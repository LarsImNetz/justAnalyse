package helper;

import org.junit.Assert;
import org.junit.Test;

public class TestStringHelper {

	private static final StringHelper stringHelper = new StringHelper();

	@Test
	public void testCdrOn3Elements() {
		final String[] str = {"eins", "zwei", "drei"};

		final String[] str2 = stringHelper.cdr(str);

		Assert.assertEquals(2, str2.length);
		Assert.assertEquals("zwei", str2[0]);
		Assert.assertEquals("drei", str2[1]);
	}

	@Test
	public void testCarOn3Elements() {
		final String[] str = {"eins", "zwei", "drei"};

		final String str2 = stringHelper.car(str);

		Assert.assertEquals("eins", str2);
	}

}
