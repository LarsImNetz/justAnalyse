package org.linux.moonserver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals(3, list.size());
	}

	@Test
	public void testGet() {
		String first = list.get(0);
		Assert.assertEquals("a", first);
	}
	
	@Test
	public void testMoreSize() throws Exception {
		list.add("d");
		Assert.assertEquals(4, list.size());
	}
}
