package experiment.lars.java.patternmatch;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

@RunWith(Parameterized.class)
public class TestMorePattern {

	/*
	 * Parameter die getestet werden sollen
	 */
	@Parameters(name = "{3}")
	public static Collection<Object[]> findAllTests() {
		final List<Object[]> list = Lists.newArrayList();
		list.add(new Object[] {"X", "X", true, "contains X"});
		list.add(new Object[] {"X", "Y", false, "do not contain X"});
		list.add(new Object[] {"XYZ", "XYZ", true, "contain XYZ"});
		list.add(new Object[] {"XYZ", "ABC", false, "do not contain XYZ"});
		list.add(new Object[] {"X?", "", true, "X kommt einmal oder keinmal vor: leer"});
		list.add(new Object[] {"X?", "X", true, "X kommt einmal oder keinmal vor: 1X"});
		list.add(new Object[] {"X*", "X", true, "X kommt keinmal oder beliebig oft vor: 1X"});
		list.add(new Object[] {"X*", "XX", true, "X kommt keinmal oder beliebig oft vor: 2X"});
		list.add(new Object[] {"X*", "XXX", true, "X kommt keinmal oder beliebig oft vor: 3X"});
		list.add(new Object[] {"X*", "XXXY", false, "X kommt keinmal oder beliebig oft vor aber String enthaelt noch mehr"});
		list.add(new Object[] {"X*(.*)", "XXXY", true, "X kommt keinmal oder beliebig oft vor und da kommt noch mehr"});
		list.add(new Object[] {"X*", "", true, "X kommt keinmal oder beliebig oft vor: leer"});
		list.add(new Object[] {"X+", "", false, "X kommt einmal oder beliebig oft vor: leer"});
		list.add(new Object[] {"X+", "X", true, "X kommt keinmal oder beliebig oft vor: 1X"});
		list.add(new Object[] {"X+", "XX", true, "X kommt keinmal oder beliebig oft vor: 2X"});
		list.add(new Object[] {"X+", "XXX", true, "X kommt keinmal oder beliebig oft vor: 3X"});
		list.add(new Object[] {"X+Y+", "XXXY", true, "X kommt keinmal oder beliebig oft vor: 3X und 1Y"});

		list.add(new Object[] {"\\d", "1", true, "a digit 1"});
		list.add(new Object[] {"\\d", "2", true, "a digit 2"});
		list.add(new Object[] {"\\d", "3", true, "a digit 3"});
		list.add(new Object[] {"\\d", "4", true, "a digit 4"});
		list.add(new Object[] {"\\d", "5", true, "a digit 5"});
		list.add(new Object[] {"\\d", "6", true, "a digit 6"});
		list.add(new Object[] {"\\d", "7", true, "a digit 7"});
		list.add(new Object[] {"\\d", "8", true, "a digit 8"});
		list.add(new Object[] {"\\d", "9", true, "a digit 9"});
		list.add(new Object[] {"\\d", "0", true, "a digit 0"});

		return list;
	}

	public TestMorePattern(final String regex, final String input, final boolean result, final String testName) {
		this.regex = regex;
		this.input = input;
		this.result = result;
	}

	private final String regex;
	private final String input;
	private final boolean result;

	/*
	 * Der eigentliche Test, der mit den Parametern zurecht kommen sollte.
	 */
	@Test
	public void test() {
		final Pattern pattern = Pattern.compile(regex);

		final Matcher matcher = pattern.matcher(input);

		Assert.assertEquals(result, matcher.matches());
	}

}
