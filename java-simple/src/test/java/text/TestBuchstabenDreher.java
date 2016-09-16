package text;

import org.junit.Assert;
import org.junit.Test;

public class TestBuchstabenDreher {

	@Test
	public void testVerdrehen_ein() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("ein");
		word.verdrehen();
		Assert.assertEquals("ein", word.getWord());
	}

	@Test
	public void testVerdrehen_zwei() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("zwei");
		word.verdrehen();
		Assert.assertEquals("zewi", word.getWord());
	}

	// Word verdrehen mit ungerader Anzahl Buchstaben
	@Test
	public void testVerdrehen_gehen() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("gehen");
		word.verdrehen();
		Assert.assertEquals("gheen", word.getWord());
	}

	// Word mit 6 Buchstaben verdrehen
	@Test
	public void testVerdrehen_laufen() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("laufen");
		word.verdrehen();
		Assert.assertEquals("luaefn", word.getWord());
	}

	// Word mit 6 Buchstaben verdrehen
	@Test
	public void testVerdrehen_vergleich() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("vergleich");
		word.verdrehen();
		Assert.assertEquals("vrelgiech", word.getWord());
	}

	@Test
	public void testVerwuerfeln_zwei() {
		BuchstabenDreher word = new BuchstabenDreher("zwei");
		word.verwuerfeln();
		Assert.assertEquals("zwei", word.getWord());
	}

	@Test
	public void testVerwuerfeln_rennt() {
		BuchstabenDreher word = new BuchstabenDreher("rennt");
		word.verwuerfeln();
		Assert.assertEquals("rnnet", word.getWord());
	}
}
