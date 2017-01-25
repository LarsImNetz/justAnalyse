package org.lla.phrasendrescher;

import org.junit.Assert;
import org.junit.Test;

public class TestPhrase {

	@Test
	public void testSatz() {
		final Phrase phrase = new Phrase();
		final String satz = phrase.getSatz();

		System.out.println(satz);

		final String expected = "Unter Zuhilfenahme von bilateralen pathologischen Beziehungsprozessen kann die "
				+ "antiserielle Implikation der normativen Inhibitations-dogmen " + "unter Berücksichtigung der psychoanalytischen Stimuli "
				+ "bei gleichzeitiger residualer Dehydriertheit derart abgeleitet werden, so daß eine "
				+ "Inkontinenz des formalhygienischen Retroeffekts weitgehend invertiert wird.";
		Assert.assertEquals(expected, satz);
	}
}
