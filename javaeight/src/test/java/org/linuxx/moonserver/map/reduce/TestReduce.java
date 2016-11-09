package org.linuxx.moonserver.map.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class TestReduce {

	final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);

	@Test
	public void testReduceAsSum() {
		final Stream<Integer> stream = asList.stream();
		final Integer summe = stream.reduce(0, (a, b) -> a + b);

		Assert.assertEquals(Integer.valueOf(10 + 20 + 30 + 40 + 50 + 60 + 70 + 80), summe);
	}

	@Test
	public void testReduceAsSum2() {
		final Stream<Integer> stream = asList.stream();
		Integer count = stream.reduce(0, Integer::sum);

		Assert.assertEquals(Integer.valueOf(10 + 20 + 30 + 40 + 50 + 60 + 70 + 80), count);
	}

	@Test
	public void testReduceAsCount() {
		final Stream<Integer> stream = asList.stream();
		final Integer count = stream.reduce(0, (a, b) -> a + 1);

		Assert.assertEquals(Integer.valueOf(8), count);
	}

	@Test
	public void testReduceAsCount2() {
		final Stream<Integer> stream = asList.stream();
		final Integer countValue = stream.reduce(0, TestReduce::count);

		Assert.assertEquals(Integer.valueOf(8), countValue);
	}

	private static int count(int a, int b) {
		return a + 1;
	}

	@Test
	public void testCount() {
		final Stream<Integer> stream = asList.stream();
		final long countValue = stream.count();

		Assert.assertEquals(8L, countValue);
	}

}
