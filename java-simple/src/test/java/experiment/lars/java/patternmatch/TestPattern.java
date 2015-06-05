package experiment.lars.java.patternmatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * Learning tests for pattern usage
 */
public class TestPattern {

	@Test
	public void testContains() {
		final String twoCssClasses = "class-1     class-2 class-3";
		final String classToCheck = "(.* )?class-2( .*)?";

		final Pattern pattern = Pattern.compile(classToCheck);
		final Matcher matcher = pattern.matcher(twoCssClasses);

		Assert.assertTrue(matcher.matches());
	}

}
