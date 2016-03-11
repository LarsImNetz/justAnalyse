package org.linuxx.moonserver.lambda;

import org.junit.Assert;
import org.junit.Test;

public class TestDefaultMethodsOhneParameter {

	/**
	 * Es gibt eine Klasse NutzeDefaultAlt, die ein Interface implementiert
	 * Das Interface wird in getUserName() zurückgegeben 
	 */
	@Test
	public void testNameAlt() {
		final IName nameFkt = new NutzeDefaultAlt().getUserName();

		Assert.assertEquals("Ich bin alt", nameFkt.getName());
	}

	private interface IName {
		public String getName();
	}

	private static class NutzeDefaultAlt {

		public IName getUserName() {
			return new IName() {
				@Override
				public String getName() {
					return "Ich bin alt";
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

		Assert.assertEquals("Ich", nameFkt.getName());
	}

	private static class NutzeDefault {
		public IName getUserName() {
			return () -> "Ich";
		}
	}

}
