package text;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class TestWordTokenizer {

	@Test(expected = NoSuchElementException.class)
	public void testWordTokenizer_EnumerationAPI_nix() {
		WordTokenizer token = new WordTokenizer("");
		token.nextElement();
	}

	@Test()
	public void testWordTokenizer_EnumerationAPI_ein_Element() {
		WordTokenizer token = new WordTokenizer("eins");

		Assert.assertTrue(token.hasMoreElements());

		token.nextElement();
		Assert.assertFalse(token.hasMoreElements());
	}

	@Test
	public void testWordTokenizer_EnumerationAPI_first() {
		WordTokenizer token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
	}

	@Test
	public void testWordTokenizer_EnumerationAPI_allWords() {
		WordTokenizer token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("ist", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("Montag", token.nextElement());
		Assert.assertEquals(".", token.nextElement());
	}
}
