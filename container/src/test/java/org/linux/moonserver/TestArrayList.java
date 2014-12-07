package org.linux.moonserver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestArrayList {

	@Test
	public void testListSize() {
		List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Assert.assertEquals(2, list.size());
	}

}
