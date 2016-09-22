package text;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class TestSentenceTokenizer {

	Enumeration<String> token;

	@Test(expected = NoSuchElementException.class)
	public void testWordTokenizer_EnumerationAPI_nix() {
		token = new SentenceTokenizer("");
		token.nextElement();
	}

	@Test(expected = NullPointerException.class)
	public void testWordTokenizer_null() {
		new SentenceTokenizer(null);
	}

	@Test()
	public void testWordTokenizer_EnumerationAPI_ein_Element() {
		token = new SentenceTokenizer("eins");

		Assert.assertTrue(token.hasMoreElements());

		token.nextElement();
		Assert.assertFalse(token.hasMoreElements());
	}

	@Test
	public void testWordTokenizer_EnumerationAPI_first() {
		token = new SentenceTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
	}

	@Test
	public void testWordTokenizer_EnumerationAPI_allWords() {
		token = new SentenceTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("ist", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("Montag", token.nextElement());
		Assert.assertEquals(".", token.nextElement());
	}

	@Test
	public void testWordTokenizer_getElementType_only() {
		SentenceTokenizer token = new SentenceTokenizer("Heute ist Montag.");
		Assert.assertEquals(SentenceTokenizer.Type.NOT_INITIALISED, token.getElementType());
	}

	@Test
	public void testWordTokenizer_getElementType_word() {
		SentenceTokenizer token = new SentenceTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
		Assert.assertEquals(SentenceTokenizer.Type.WORD, token.getElementType());
	}

	@Test
	public void testWordTokenizer_getElementType_number() {
		SentenceTokenizer token = new SentenceTokenizer("123 ist eine Zahl.");
		Assert.assertEquals("123", token.nextElement());
		Assert.assertEquals(SentenceTokenizer.Type.NUMBER, token.getElementType());
	}

	@Test
	public void testWordTokenizer_getElementType_other() {
		SentenceTokenizer token = new SentenceTokenizer("!ist ein Satzzeichen.");
		Assert.assertEquals("!", token.nextElement());
		Assert.assertEquals(SentenceTokenizer.Type.OTHER, token.getElementType());
	}

}
