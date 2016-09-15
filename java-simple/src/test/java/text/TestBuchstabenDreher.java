package text;

import org.junit.Assert;
import org.junit.Test;

public class TestBuchstabenDreher {

	@Test
	public void testVerdrehen_ein() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("ein");
		Assert.assertEquals("ein", word.verdrehen());
	}

	@Test
	public void testVerdrehen_zwei() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("zwei");
		Assert.assertEquals("zewi", word.verdrehen());
	}

	// Word verdrehen mit ungerader Anzahl Buchstaben
	@Test
	public void testVerdrehen_gehen() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("gehen");
		Assert.assertEquals("gheen", word.verdrehen());
	}

	// Word mit 6 Buchstaben verdrehen
	@Test
	public void testVerdrehen_laufen() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("laufen");
		Assert.assertEquals("luaefn", word.verdrehen());
	}

	// Word mit 6 Buchstaben verdrehen
	@Test
	public void testVerdrehen_vergleich() throws Exception {
		BuchstabenDreher word = new BuchstabenDreher("vergleich");
		Assert.assertEquals("vrelgiech", word.verdrehen());
	}

	@Test
	public void testVerwuerfeln_zwei() {
		BuchstabenDreher word = new BuchstabenDreher("zwei");
		Assert.assertEquals("zwei", word.verwuerfeln());
	}

	@Test
	public void testVerwuerfeln_rennt() {
		BuchstabenDreher word = new BuchstabenDreher("rennt");
		Assert.assertEquals("rnnet", word.verwuerfeln());
	}
}
