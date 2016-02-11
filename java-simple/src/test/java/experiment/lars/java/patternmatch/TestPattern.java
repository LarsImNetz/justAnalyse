package experiment.lars.java.patternmatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Learning tests for pattern usage
 */
public class TestPattern {

	Pattern pattern;

	@Before
	public void setUp() {
		final String classToCheck = "(.*)?class-2(.*)?";
		pattern = Pattern.compile(classToCheck);
	}
	
	@Test
	public void testContains() {
		final String twoCssClasses = "class-1     class-2 class-3";
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());

		final String match0 = matcher.group(0);
		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals(twoCssClasses, match0);
		Assert.assertEquals("class-1     ", match1);
		Assert.assertEquals(" class-3", match2);
	}

	@Test
	public void testIsAtStart() {
		final String twoCssClasses = "class-2 class-3";
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());
	}

	@Test
	public void testIsAtEnd() {
		final String twoCssClasses = "class-1 class-2";
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());
	}

	@Test
	public void testIsInWithoutSpace() {
		final String twoCssClasses = "abcdeclass-2abcde";
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());
	}

	@Test
	public void testContainsTwiceGreedy() {
		final String twoCssClasses = "class-1 class-2 class-2 class-3";
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());

		final String match0 = matcher.group(0);
		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals(twoCssClasses, match0);
		Assert.assertEquals("class-1 class-2 ", match1);
		Assert.assertEquals(" class-3", match2);
	}

	@Test
	public void testContainsTwiceNotGreedy() {
		final String classToCheck = "(.*)class-2(.*)";
		pattern = Pattern.compile(classToCheck);

		final String twoCssClasses = "class-1 class-2 class-2 class-3";
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());

		final String match0 = matcher.group(0);
		final String match1 = matcher.group(1);
		final String match2 = matcher.group(2);
		Assert.assertEquals(twoCssClasses, match0);
		Assert.assertEquals("class-1 class-2 ", match1);
		Assert.assertEquals(" class-3", match2);
	}

}
