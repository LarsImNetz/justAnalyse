package experiment.lars.java.list;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayList {

	private ArrayList<String> list;

	@Before
	public void setUp() {
		list = new ArrayList<>();
		list.add("eins");
		list.add("zwo");
		list.add("drei");
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testEmpty() {
		Assert.assertFalse(list.isEmpty());

		ArrayList<String> emptyList = new ArrayList<>();
		Assert.assertTrue(emptyList.isEmpty());
	}

	@Test
	public void testContains() throws Exception {
		Assert.assertTrue(list.contains("eins"));
	}

	@Test
	public void testName() throws Exception {
		Assert.assertFalse(list.isEmpty());
		list.clear();
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	public void testGet() throws Exception {
		Assert.assertEquals("eins", list.get(0));
		Assert.assertEquals("zwo", list.get(1));
		Assert.assertEquals("drei", list.get(2));
	}
}
