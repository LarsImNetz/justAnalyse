package text;

import org.junit.Test;

import org.junit.Assert;

public class TestBuchstabenManipulator {

	@Test(expected = IllegalArgumentException.class)
	public void testBuchstabenNachbarnTauschen_null() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator();
		manipulator.setWord(null);
	}

	@Test
	public void testBuchstabenNachbarnTauschen_empty() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator();
		manipulator.setWord("");
		manipulator.buchstabenNachbarnTauschen();
		Assert.assertEquals("", manipulator.getWord());
	}

	@Test
	public void testBuchstabenNachbarnTauschen_abcd() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator();
		manipulator.setWord("abcd");
		manipulator.buchstabenNachbarnTauschen();
		Assert.assertEquals("acbd", manipulator.getWord());
	}

	@Test
	public void testBuchstabenZweitenMitLetztemTauschen_abc() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator();
		manipulator.setWord("abc");
		manipulator.buchstabenZweitenMitLetztemTauschen();
		Assert.assertEquals("abc", manipulator.getWord());
	}

	@Test
	public void testBuchstabenZweitenMitLetztemTauschen_abcd() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator();
		manipulator.setWord("abcd");
		manipulator.buchstabenZweitenMitLetztemTauschen();
		Assert.assertEquals("acbd", manipulator.getWord());
	}
}
