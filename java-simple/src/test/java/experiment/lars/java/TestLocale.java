package experiment.lars.java;

import java.util.Locale;
import java.util.Locale.Builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLocale {

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
		Assert.assertEquals("de", l.getLanguage());
		Assert.assertEquals("DE", l.getCountry());
		Assert.assertEquals("", l.getVariant());
	}

	@Test
	public void testLocale_GERMAN() {
		Locale l;
		l = Locale.GERMAN;
		Assert.assertEquals(Locale.GERMAN, l);
		Assert.assertEquals("", l.getDisplayCountry());
		Assert.assertEquals("de", l.getLanguage());
		Assert.assertEquals("", l.getCountry());
		Assert.assertEquals("", l.getVariant());
	}

	@Test
	public void testLocale_GERMANY_with_Builder() {
		Locale l = new Builder().setLanguage("de").setScript("Latn").setRegion("DE").setVariant("bayrisch").build();
		Assert.assertEquals("Deutschland", l.getDisplayCountry());
		Assert.assertEquals("de", l.getLanguage());
		Assert.assertEquals("DE", l.getCountry());
		Assert.assertEquals("bayrisch", l.getVariant());
		Assert.assertEquals("deu", l.getISO3Language());
	}

	@Test
	public void testDefault() {
		Locale.setDefault(Locale.ENGLISH);
		Assert.assertEquals(Locale.ENGLISH, Locale.getDefault());

		Locale l = Locale.GERMANY;
		Assert.assertEquals("Germany", l.getDisplayCountry());

		Assert.assertEquals(Locale.ENGLISH, Locale.getDefault());
	}
}
