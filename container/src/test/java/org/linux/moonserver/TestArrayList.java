package org.linux.moonserver;

import java.util.ArrayList;
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
	public void testAllElements() {
		assertThat(list, hasItems("a", "b", "c"));
	}
}
