package experiment.lars.java.maps;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestHashMapLearning {

	// Der letzte gewinnt
	@Test
	public void testPut() {
		final Map<Integer, String> map = new HashMap<>();

		map.put(Integer.valueOf(1), "eins");
		map.put(Integer.valueOf(1), "auch eins");
		map.put(Integer.valueOf(1), "erstrecht eins");

		Assert.assertEquals(1, map.size());
		Assert.assertEquals("erstrecht eins", map.get(Integer.valueOf(1)));
	}

	// Der erste gewinnt
	@Test
	public void testPutIfAbsent() {
		final Map<Integer, String> map = new HashMap<>();

		map.putIfAbsent(Integer.valueOf(1), "eins");
		map.putIfAbsent(Integer.valueOf(1), "auch eins");
		map.putIfAbsent(Integer.valueOf(1), "erstrecht eins");

		Assert.assertEquals(1, map.size());
		Assert.assertEquals("eins", map.get(Integer.valueOf(1)));
	}

}
