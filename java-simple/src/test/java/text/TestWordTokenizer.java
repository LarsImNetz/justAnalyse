package text;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

import com.google.common.base.CharMatcher;

import org.junit.Assert;

public class TestWordTokenizer {

	@Test
	public void testStringTokenizer_ein_Satz() {
		String satz = "Heute ist Montag.";
		StringTokenizer token = new StringTokenizer(satz);
		Assert.assertEquals("Heute", token.nextToken());
		Assert.assertEquals("ist", token.nextToken());
		Assert.assertEquals("Montag.", token.nextToken());
	}

	@Test(expected = NoSuchElementException.class)
	public void testStringTokenizer_nix() {
		String satz = "";
		StringTokenizer token = new StringTokenizer(satz);
		token.nextToken();
	}
	
	@Test
	public void testScanner() {
		Scanner scan = new Scanner("Heute ist Montag.");
		Assert.assertEquals("Heute", scan.next());
		Assert.assertEquals("ist", scan.next());
		Assert.assertEquals("Montag.", scan.next());
		scan.close();
	}
	
	@Test
	public void testCharMatcher() {
		Assert.assertTrue(CharMatcher.javaLetter().matches('A'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('Z'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('a'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('z'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('Ä'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('Ö'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('Ü'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('ä'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('ö'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('ü'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('ß'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('á'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('à'));
		Assert.assertTrue(CharMatcher.javaLetter().matches('â'));
		
		Assert.assertFalse(CharMatcher.javaLetter().matches('0'));
		Assert.assertFalse(CharMatcher.javaLetter().matches('.'));
	}
	
	@Test
	public void testWordTokenizer_first() {
		WordTokenizer token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
	}
	@Test
	public void testWordTokenizer_allWords() {
		WordTokenizer token = new WordTokenizer("Heute ist Montag.");
		Assert.assertEquals("Heute", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("ist", token.nextElement());
		Assert.assertEquals(" ", token.nextElement());
		Assert.assertEquals("Montag", token.nextElement());
		Assert.assertEquals(".", token.nextElement());
	}
}
