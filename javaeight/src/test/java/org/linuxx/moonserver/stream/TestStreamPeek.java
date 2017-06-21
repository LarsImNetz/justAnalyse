package org.linuxx.moonserver.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStreamPeek {

	private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

	private int count;
	@Before
	public void setUp() {
		count = 0;
	}
	
	@Test
	public void testPeek() {	
		numbers.stream().peek(n -> called(n)).collect(Collectors.toList());
		Assert.assertEquals(8,  count);
	}

	/*
	 * interessant, das ein Stream ohne collection nicht durchlaufen wird
	 */
	@Test
	public void testPeekNotCalled() {
		numbers.stream().peek(n -> called(n));
		Assert.assertEquals(0,  count);
	}

	private Object called(Integer n) {
		count++;
		return this;
	}

}
