package org.linuxx.moonserver;


public class Palindrome {
	public static boolean isPalindrome(final String input) {
		final String a = input.toLowerCase();
		final String b = new StringBuilder(a).reverse().toString();
		return a.equals(b);
	}
}
