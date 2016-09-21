package text;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class TestWordTokenizer {

	Enumeration<String> token;

	@Test(expected = NoSuchElementException.class)
	public void testWordTokenizer_EnumerationAPI_nix() {
		token = new WordTokenizer("");
		token.nextElement();
	}

	@Test(expected = NullPointerException.class)
	public void testWordTokenizer_null() {
		new WordTokenizer(null);
	}

	@Test()
	public void testWordTokenizer_EnumerationAPI_ein_Element() {
		token = new WordTokenizer("eins");

		Assert.assertTrue(token.hasMoreElements());

		token.nextElement();
		Assert.assertFalse(token.hasMoreElements());
	}

	@Test
	public void testWordTokenizer_EnumerationAPI_first() {
		token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
	}

	@Test
	public void testWordTokenizer_EnumerationAPI_allWords() {
		token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("ist", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("Montag", token.nextElement());
		Assert.assertEquals(".", token.nextElement());
	}

	@Test
	public void testWordTokenizer_getElementType_only() {
		WordTokenizer token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals(WordTokenizer.Type.NOT_INITIALISED, token.getElementType());
	}

	@Test
	public void testWordTokenizer_getElementType() {
		WordTokenizer token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
		Assert.assertEquals(WordTokenizer.Type.WORD, token.getElementType());
	}

}
