package org.linuxx.moonserver;

import org.junit.Assert;
import org.junit.Test;


public class TestPalindrome {

	@Test
	public void isPalindromeTest() {
		Assert.assertTrue("Ist kein Palindrome", Palindrome.isPalindrome("Otto"));
	}

	@Test
	public void isNoPalindromeTest() {
		Assert.assertFalse("Ist ein Palindrome",Palindrome.isPalindrome("Test"));
	}


}
