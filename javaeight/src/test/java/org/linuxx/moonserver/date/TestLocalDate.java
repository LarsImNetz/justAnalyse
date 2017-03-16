package org.linuxx.moonserver.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

public class TestLocalDate {
	@Test
	public void testGermanFormat() {
		final String date = "04.01.1970";
		final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		final LocalDate ldt = LocalDate.parse(date, FORMATTER);

		Assert.assertEquals(1970, ldt.getYear());
		Assert.assertEquals(1, ldt.getMonthValue());
		Assert.assertEquals(4, ldt.getDayOfMonth());
	}

	@Test
	public void testISO() {
		final String date = "1970-01-04";
		final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		final LocalDate ldt = LocalDate.parse(date, FORMATTER);

		Assert.assertEquals(1970, ldt.getYear());
		Assert.assertEquals(1, ldt.getMonthValue());
		Assert.assertEquals(4, ldt.getDayOfMonth());
	}
	
	@Test
	public void testInitOf_withYearMonthDay() {
		LocalDate ldt = LocalDate.of(1968, 1, 4);

		Assert.assertEquals(1968, ldt.getYear());
		Assert.assertEquals(1, ldt.getMonthValue());
		Assert.assertEquals(4, ldt.getDayOfMonth());
		Assert.assertEquals(DayOfWeek.THURSDAY, ldt.getDayOfWeek());		
	}

	@Test
	public void testInitOf_withYearMonthDay2() {
		// Auf Donnerstag 4.10.1582 folgt Freitag der 15. Oktober 1582
		LocalDate ldt = LocalDate.of(1582, 10, 15);

		Assert.assertEquals(1582, ldt.getYear());
		Assert.assertEquals(10, ldt.getMonthValue());
		Assert.assertEquals(15, ldt.getDayOfMonth());
		Assert.assertEquals(DayOfWeek.FRIDAY, ldt.getDayOfWeek());

		ldt = ldt.minusDays(1);

		/* So gut scheint das LocalDate auch nicht zu funktionieren.  ;-) */
		Assert.assertEquals(1582, ldt.getYear());
		Assert.assertEquals(10, ldt.getMonthValue());
		Assert.assertEquals(14, ldt.getDayOfMonth());
		Assert.assertEquals(DayOfWeek.THURSDAY, ldt.getDayOfWeek());		
	}
	
	@Test
	public void testInitgetDayOfYear() {
		LocalDate ldt = LocalDate.of(2001, 6, 1);

		Assert.assertEquals(2001, ldt.getYear());
		Assert.assertEquals(152, ldt.getDayOfYear());
	}

	@Test
	public void testInitgetDayOfYearInaLeapYear() {
		LocalDate ldt = LocalDate.of(2004, 6, 1);

		Assert.assertEquals(2004, ldt.getYear());
		Assert.assertEquals(153, ldt.getDayOfYear());
	}
}
