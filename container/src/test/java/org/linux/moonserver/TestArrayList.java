package org.linux.moonserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.hasItems;

public class TestArrayList {

	List<String> list;

	@Before
	public void setUp() {
		list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
	}

	@Test
	public void testSize() {
		assertEquals(3, list.size());
	}

	@Test
	public void testGet() {
		final String first = list.get(0);
		assertEquals("a", first);
	}

	@Test
	public void testMoreSize() throws Exception {
		list.add("d");
		Assert.assertEquals(4, list.size());
	}

	@Test
	public void testAddWithPosition() throws Exception {
		list.add(0, "eins");
		Assert.assertEquals(4, list.size());
		Assert.assertEquals("eins", list.get(0));
	}

	@Test
	public void testAddAll() throws Exception {
		final List<String> asList = Arrays.asList("eins", "zwei", "drei");
		list.addAll(asList);
		Assert.assertEquals(6, list.size());
		Assert.assertEquals("eins", list.get(3));
	}

	@Test
	public void testSet() {
		list.set(0, "neu");
		final String first = list.get(0);
		assertEquals("neu", first);
	}

	@Test
	public void testContains() {
		Assert.assertTrue(list.contains("a"));
		Assert.assertFalse(list.contains("d"));
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(new ArrayList<String>().isEmpty());
		Assert.assertFalse(list.isEmpty());
	}

	@Test
	public void testIndexOf() {
		Assert.assertEquals(0, list.indexOf("a"));
		Assert.assertEquals(1, list.indexOf("b"));
		Assert.assertEquals(2, list.indexOf("c"));
	}

	@Test
	public void testRemove() throws Exception {
		list.remove(0);
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void testRemoveAll() throws Exception {
		list.removeAll(Arrays.asList("a", "b"));
		Assert.assertEquals(1, list.size());
	}

	@Test
	public void testClear() throws Exception {
		list.clear();
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	public void testListErstellen() throws Exception {
		final List<String> list = new ArrayList<String>(Arrays.asList( "0 1 2 3 4 5 6 7 8 9".split( " " ) ));
		Assert.assertEquals(10, list.size());
	}
	
	@Test
	public void testAllElements() {
		assertThat(list, hasItems("a", "b", "c"));
	}
}
