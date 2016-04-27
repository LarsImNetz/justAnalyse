package org.linuxx.moonserver.lambda;

import org.junit.Assert;
import org.junit.Test;

public class TestDefaultMethodsMitParameter {

	/**
	 * Es gibt eine Klasse NutzeDefaultAlt, die ein Interface implementiert
	 * Das Interface wird in getUserName() zurückgegeben
	 */
	@Test
	public void testNameAlt() {
		final IName nameFkt = new NutzeDefaultAlt().getUserName();

		Assert.assertEquals("Ich in alt", nameFkt.getName("", ""));
	}

	private interface IName {

		public String getName(String additional, String second);
	}

	private static class NutzeDefaultAlt {

		public IName getUserName() {
			return new IName() {

				@Override
				public String getName(final String additional, final String second) {
					return "Ich in alt" + additional + second;
				}
			};
		}
	}

	/**
	 * Jetzt das gleiche in Funktional
	 * Es gibt eine Klasse NutzeDefault, die ein Interface implementiert
	 * Das Interface wird in getUserName() zurückgegeben, diesmal wird ausgenutzt, dass das Interface nur eine Funktion enthält
	 */
	@Test
	public void testName() throws Exception {
		final IName nameFkt = new NutzeDefault().getUserName();

		Assert.assertEquals("Ich&Ich&Du", nameFkt.getName("&Ich", "&Du"));
	}

	private static class NutzeDefault {

		public IName getUserName() {
			return (additional, schnubbel) -> "Ich" + additional + schnubbel;
		}
	}

	@Test
	public void testNameMitTyp() throws Exception {
		final IName nameFkt = new NutzeDefaultOhneTyp().getUserName();

		Assert.assertEquals("Ich&Ich&Du", nameFkt.getName("&Ich", "&Du"));
	}

	private static class NutzeDefaultOhneTyp {

		public IName getUserName() {
			return (final String additional, final String schnubbel) -> "Ich" + additional + schnubbel;
		}
	}

	@Test
	public void testNameOhneTypMitStringBuilder() throws Exception {
		final IName nameFkt = new NutzeDefaultOhneTypMitStringBuilder().getUserName();

		Assert.assertEquals("Ich&Ich&Du", nameFkt.getName("&Ich", "&Du"));
	}

	private static class NutzeDefaultOhneTypMitStringBuilder {

		public IName getUserName() {
			return (additional, schnubbel) -> {
				final StringBuilder builder = new StringBuilder();
				builder.append("Ich").append(additional).append(schnubbel);
				return builder.toString();
			};
		}
	}

}
