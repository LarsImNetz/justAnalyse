package org.linux.moonserver;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMap {

	Map<String, String> map;

	@Before
	public void setUp() {
		map = new HashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
	}

	@Test
	public void testCreateHash() {
		Assert.assertEquals(3, map.size());
	}

	@Test
	public void testAccess3() throws Exception {
		String value = map.get("3");
		Assert.assertEquals("c", value);
	}
	@Test
	public void testAccess2() throws Exception {
		String value = map.get("2");
		Assert.assertEquals("b", value);
	}
	@Test
	public void testAccess1() throws Exception {
		String value = map.get("1");
		Assert.assertEquals("a", value);
	}

	@Test
    public void testOnlyOneKey() throws Exception {
		// wir überschreiben den Key "1"
		map.put("1", "auch eins");
	    
		String value = map.get("1");
		Assert.assertEquals("auch eins", value);
    }
	
	@Test
	public void testAccessForeachValues() throws Exception {
		String values = "";
		for (String value : map.values()) {
			values += value;
		}
		// Da wir die Reihenfolge nicht kennen, testen wir einfach auf jedes Element
		Assert.assertTrue(values.contains("a"));
		Assert.assertTrue(values.contains("b"));
		Assert.assertTrue(values.contains("c"));
		Assert.assertFalse(values.contains("d"));
		Assert.assertFalse(values.contains("e"));
		Assert.assertFalse(values.contains("f"));
	}

	@Test
	public void testAccessForeachValuesViaKey() throws Exception {
		String values = "";
		for (String key : map.keySet()) {
			values += map.get(key);
		}
		// Da wir die Reihenfolge nicht kennen, testen wir einfach auf jedes Element
		Assert.assertTrue(values.contains("a"));
		Assert.assertTrue(values.contains("b"));
		Assert.assertTrue(values.contains("c"));
		Assert.assertFalse(values.contains("d"));
		Assert.assertFalse(values.contains("e"));
		Assert.assertFalse(values.contains("f"));
	}

	@Test
	public void testAccessForeachKeys() throws Exception {
		String keys = "";
		for (String key : map.keySet()) {
			keys += key;
		}
		// Da wir die Reihenfolge nicht kennen, testen wir einfach auf jedes Element
		Assert.assertTrue(keys.contains("1"));
		Assert.assertTrue(keys.contains("2"));
		Assert.assertTrue(keys.contains("3"));
		Assert.assertFalse(keys.contains("4"));
		Assert.assertFalse(keys.contains("5"));
		Assert.assertFalse(keys.contains("6"));
	}
}
