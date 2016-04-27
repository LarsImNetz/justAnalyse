package experiment.lars.java;

import java.util.Locale;
import java.util.Locale.Builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFail {

	@Before
	public void before() {
		Locale.setDefault(Locale.GERMANY);
	}

	@Test
	public void testLocale_GERMANY() {
		Locale l;
		l = Locale.GERMANY;
		Assert.assertEquals(Locale.GERMANY, l);
		Assert.assertEquals("Deutschland", l.getDisplayCountry());
		Assert.assertEquals("de", l.getLanguage()); // we want that this will fail!
		// Assert.assertEquals("DE", l.getCountry());
		// Assert.assertEquals("", l.getVariant());
	}

}
