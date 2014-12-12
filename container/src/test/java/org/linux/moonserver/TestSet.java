package org.linux.moonserver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSet {
	Set<String> set;
	
	@Before
	public void setUp() {
		set = new HashSet<String>();
	    set.add("a");
	    set.add("b");
	    set.add("c");
	}
	
	@Test
    public void testSize() throws Exception {
		Assert.assertEquals(3, set.size());
    }
	
	@Test
    public void testContains() throws Exception {
	    Assert.assertTrue(set.contains("a"));
	    Assert.assertFalse(set.contains("d"));
	}
	
	@Test
    public void testIterator_StupidTestWay() throws Exception {
		Iterator<String> iterator = set.iterator();
		String result = "";
		while(iterator.hasNext()) {
			result += iterator.next();
		}
		// Die Reihenfolge ist durch den Hash nicht gegeben
		Assert.assertTrue(result.contains("a"));
		Assert.assertTrue(result.contains("b"));
		Assert.assertTrue(result.contains("c"));
	}
	
	@Test
    public void testIsEmpty() throws Exception {
	    Assert.assertFalse(set.isEmpty());
	}
	
	@Test
    public void testRemove() throws Exception {
		set.remove("a");
		
	    Assert.assertTrue(set.contains("b"));
	    Assert.assertTrue(set.contains("c"));
	    Assert.assertFalse(set.contains("a"));		
    }
}
