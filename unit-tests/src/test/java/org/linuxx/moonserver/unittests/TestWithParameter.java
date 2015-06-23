package org.linuxx.moonserver.unittests;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

/*
 * Wir müssen sagen, das es ein parametrisierter Test ist durch RunWith
 */
@RunWith(Parameterized.class)
public class TestWithParameter {

	/*
	 * Parameter die getestet werden sollen
	 */
	@Parameters(name = "{1}")
	public static Collection<Object[]> findAllTests() {
		final List<Object[]> list = Lists.newArrayList();
		list.add(new Object[] {"a", "a"});
		list.add(new Object[] {"b", "be"});
		list.add(new Object[] {"c", "ce"});
		list.add(new Object[] {"d", "de"});
		list.add(new Object[] {"e", "e"});
		list.add(new Object[] {"f", "eff"});
		list.add(new Object[] {"g", "ge"});
		list.add(new Object[] {"h", "ha"});
		list.add(new Object[] {"i", "i"});
		list.add(new Object[] {"j", "jot"});
		list.add(new Object[] {"k", "ka"});
		list.add(new Object[] {"l", "el"});
		list.add(new Object[] {"m", "em"});
		list.add(new Object[] {"n", "en"});
		list.add(new Object[] {"o", "o"});
		list.add(new Object[] {"p", "pe"});
		list.add(new Object[] {"q", "qu"});
		list.add(new Object[] {"r", "er"});
		list.add(new Object[] {"s", "es"});
		list.add(new Object[] {"t", "te"});
		list.add(new Object[] {"u", "u"});
		list.add(new Object[] {"v", "vau"});
		list.add(new Object[] {"w", "we"});
		list.add(new Object[] {"x", "ix"});
		list.add(new Object[] {"y", "ypsilon"});
		list.add(new Object[] {"z", "zet"});
		return list;
	}

	/**
	 * C'Tor, der die zu testenden Parameter entgegen nimmt, für jeden Parameter
	 * der zu testen ist, wird ein TestObjekt erstellt
	 * 
	 * @param listValue
	 *          ist der {1} erste Parameter
	 * 
	 * @param testName
	 *          ist der Name des Tests, der ausgegeben wird
	 */

	public TestWithParameter(final String listValue, final String testName) {
		this.currentTestParmeterValue = listValue;
	}

	private String currentTestParmeterValue;

	/*
	 * Der eigentliche Test, der mit den Parametern zurecht kommen sollte.
	 */
	@Test
	public void test() {
		Assert.assertFalse(currentTestParmeterValue.isEmpty());
	}

}
