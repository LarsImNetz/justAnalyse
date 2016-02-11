package experiment.lars.java.patternmatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * Learning tests for pattern usage
 */
public class TestPatternZeichenklassen {

	@Test
	public void testContainNoX() {
		final String vokale = "X";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "Y";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertFalse(matcher.matches());
	}

	@Test
	public void testContainX() {
		final String vokale = "X";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "X";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches());
	}

	@Test
	public void testContainMoreX() {
		final String vokale = "X";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "XXX";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertFalse(matcher.matches()); // das Pattern ist nicht vollständig
	}

	@Test
	public void testContainMoreXFullAtleast2() {
		final String vokale = "(.+)X";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "X";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertFalse(matcher.matches());
	}

	@Test
	public void testContainMoreXFull() {
		final String vokale = "(.+)X";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "XXX";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches());

		final String match0 = matcher.group(0);
		final String match1 = matcher.group(1);
		Assert.assertEquals("XXX", match0);
		Assert.assertEquals("XX", match1);
	}

	@Test
	public void testContainMoreXFullWithGroup() {
		final String vokale = "(.*)X(.*)";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "XXX";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches());

		final String match1 = matcher.group(1);
		Assert.assertEquals("XX", match1);
	}

	// X? X kommt einmal oder keinmal vor
	// X* X kommt keinmal oder beliebig oft vor
	// X+ X kommt einmal oder beliebig oft vor

	@Test
	public void testContainMoreX2() {
		final String vokale = "(.*)X?(.*)";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "YXZ";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches()); // mehr als ein X

		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals("YXZ", match1); // der erste (.*) ist Greedy!
		Assert.assertEquals("", match2);
	}

	@Test
	public void testContainMoreX3() {
		final String vokale = "(.*)X+(.*)";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "YXZ";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches()); // mehr als ein X

		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals("Y", match1); // der erste (.*) ist Greedy!
		Assert.assertEquals("Z", match2);
	}

	@Test
	public void testContainMoreXNotGreedy() {
		final String vokale = "(.*)?X+(.*)";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "YXZ";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches()); // mehr als ein X

		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals("Y", match1); // der erste (.*) ist Greedy!
		Assert.assertEquals("Z", match2);
	}

	@Test
	public void testContainMoreX4() {
		final String vokale = "(.*)X*?(.*)";
		final Pattern pattern = Pattern.compile(vokale);

		final String input = "YXXZ";
		final Matcher matcher = pattern.matcher(input);

		Assert.assertTrue(matcher.matches()); // mehr als ein X

		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals("YXXZ", match1); // der erste (.*) ist Greedy!
		Assert.assertEquals("", match2);
	}

}
