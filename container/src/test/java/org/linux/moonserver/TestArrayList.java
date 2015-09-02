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
	public void testAllElements() {
		assertThat(list, hasItems("a", "b", "c"));
	}
}
