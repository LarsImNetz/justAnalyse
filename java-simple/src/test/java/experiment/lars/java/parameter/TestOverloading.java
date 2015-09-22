package experiment.lars.java.parameter;

import org.junit.Assert;
import org.junit.Test;

public class TestOverloading {

	@Test
	public void testInteger() throws Exception {
		Assert.assertEquals("integer", zahl(1));
	}

	@Test
	public void testCharacterr() throws Exception {
		Assert.assertEquals("character", zahl('1'));
	}

	@Test
	public void testShort() throws Exception {
		Assert.assertEquals("short", zahl((short) 1));
	}

	@Test
	public void testLong() throws Exception {
		Assert.assertEquals("long", zahl(1L));
	}

	@Test
	public void testFloat() throws Exception {
		Assert.assertEquals("float", zahl(1.1f));
	}

	@Test
	public void testDouble() throws Exception {
		Assert.assertEquals("double", zahl(1.2));
	}

	@Test
	public void testString() throws Exception {
		Assert.assertEquals("nix zahl, String!", zahl("eins"));
	}

	// Die Funktion heißt immer gleich, nur der Parameter unterscheidet sich
	// was leider fest steht ist die Reihenfolge
	private String zahl(final int i) {
		return "integer";
	}

	private String zahl(final double i) {
		return "double";
	}
	
	private String zahl(final float i) {
		return "float";
	}
	
	private String zahl(final long i) {
		return "long";
	}
	
	private String zahl(final short i) {
		return "short";
	}
	
	private String zahl(final char zahl) {
		return "character";
	}

	private String zahl(final String zahl) {
		return "nix zahl, String!";
	}
}
