package text;

import org.junit.Test;

import org.junit.Assert;

public class TestBuchstabenManipulator {

	@Test(expected = IllegalArgumentException.class)
	public void testBuchstabenNachbarnTauschen_null() {
		new BuchstabenManipulator(null);
	}

	@Test
	public void testBuchstabenNachbarnTauschen_empty() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator("");
		manipulator.buchstabenNachbarnTauschen();
		Assert.assertEquals("", manipulator.getWord());
	}

	@Test
	public void testBuchstabenNachbarnTauschen_abcd() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator("abcd");
		manipulator.buchstabenNachbarnTauschen();
		Assert.assertEquals("acbd", manipulator.getWord());
	}

	@Test
	public void testBuchstabenZweitenMitLetztemTauschen_abc() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator("abc");
		manipulator.buchstabenZweitenMitLetztemTauschen();
		Assert.assertEquals("abc", manipulator.getWord());
	}

	@Test
	public void testBuchstabenZweitenMitLetztemTauschen_abcd() {
		BuchstabenManipulator manipulator = new BuchstabenManipulator("abcd");
		manipulator.buchstabenZweitenMitLetztemTauschen();
		Assert.assertEquals("acbd", manipulator.getWord());
	}
}
