package org.linux.moonserver;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSet {
	Set<String> set;
	
	@Before
	public void setUp() {
		set = new HashSet<String>();
	}
	
	@Test
    public void testSize() throws Exception {
		set.add("a");
		set.add("b");
		Assert.assertEquals(2, set.size());
    }
}
