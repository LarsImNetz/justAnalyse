package org.linux.moonserver.stringformatter;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class TestStringFormatterWithCalendar {

	@Test
	public void testStringFormatDate() {
		Assert.assertEquals("12", String.format("%tm", new GregorianCalendar(2015, 11, 31)));
		Assert.assertEquals("31.12.2015", String.format("%1$td.%1$tm.%1$tY", new GregorianCalendar(2015, 11, 31)));
		Assert.assertEquals("2015-12-31", String.format(Locale.GERMANY, "%tF", new GregorianCalendar(2015, 11, 31)));
		Assert.assertEquals("2016-02-29", String.format(Locale.GERMANY, "%tF", new GregorianCalendar(2016, 01, 29)));
	}

}
