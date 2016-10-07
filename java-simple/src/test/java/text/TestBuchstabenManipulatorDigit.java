package text;

import org.junit.Test;

import org.junit.Assert;

public class TestBuchstabenManipulatorDigit {

	@Test(expected = IllegalArgumentException.class)
	public void testBuchstabenNachbarnTauschen_null() {
		BuchstabenManipulatorDigit manipulator = new BuchstabenManipulatorDigit();
		manipulator.setWord(null);
	}

	@Test
	public void testBuchstabenNachbarnTauschen_empty() {
		BuchstabenManipulatorDigit manipulator = new BuchstabenManipulatorDigit();
		manipulator.setWord("");
		manipulator.buchstabenErsetzen();
		Assert.assertEquals("", manipulator.getWord());
	}

	@Test
	public void testBuchstabenNachbarnTauschen_abcd() {
		BuchstabenManipulatorDigit manipulator = new BuchstabenManipulatorDigit();
		manipulator.setWord("abcd");
		manipulator.buchstabenErsetzen();
		Assert.assertEquals("48CD", manipulator.getWord());
	}

	@Test
	public void testBuchstabenNachbarnTauschen_gehirn() {
		BuchstabenManipulatorDigit manipulator = new BuchstabenManipulatorDigit();
		manipulator.setWord("gehirn");
		manipulator.buchstabenErsetzen();
		Assert.assertEquals("G3H1RN", manipulator.getWord());
	}

	@Test
	public void testBuchstabenNachbarnTauschen_dieser() {
		BuchstabenManipulatorDigit manipulator = new BuchstabenManipulatorDigit();
		manipulator.setWord("dieser");
		manipulator.buchstabenErsetzen();
		Assert.assertEquals("D1353R", manipulator.getWord());
	}

	@Test
	public void testBuchstabenNachbarnTauschen_text() {
		BuchstabenManipulatorDigit manipulator = new BuchstabenManipulatorDigit();
		manipulator.setWord("text");
		manipulator.buchstabenErsetzen();
		Assert.assertEquals("73X7", manipulator.getWord());
	}
	
	/*
	Diese Mitteilung dient als Beweis dafuer, was fuer erstaunliche Dinge unser Verstand
	leisten kann. Beindruckend.
	am Anfang war's schon schwer, aber jetzt, in dieser Zeile, liest es dein Gehirn
	automatisch. Ohne darueber nachzudenken. Sei stolz drauf.
	Also teile dieses Bild, wenn du es lesen kannst.
	*/
}
