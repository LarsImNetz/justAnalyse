package org.lla.phrasendrescher;

import org.junit.Test;

public class ITestPhrase {
	@Test
	public void testSatz() {
		final Phrase phrase = new Phrase();

		int i = 0;
		while((i++) < 13) {
		final String satz = phrase.getSatz();

		System.out.println(satz);
		}
	}
}
