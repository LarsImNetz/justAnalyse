package org.linuxx.moonserver.map.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class TestSum {

	@Test
	public void testSumWithFilter() {

		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream();
		final double sum = stream.filter(value -> value > 40).mapToDouble(value -> value * 1.0).sum();

		Assert.assertEquals(50 + 60 + 70 + 80d, sum, 0.01);
		// System.out.println("Summe: " + sum);
	}

	@Test
	public void testSum() {

		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream();
		final double sum = stream.mapToDouble(value -> value * 1.0).sum();

		Assert.assertEquals(10 + 20 + 30 + 40 + 50 + 60 + 70 + 80d, sum, 0.01);
	}

	@Test
	public void testSumAsCountWithReturn() {

		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream();
		final int n = stream.mapToInt(value -> {
			return 1;
		}).sum();

		Assert.assertEquals(8, n);
	}

	@Test
	public void testSumAsCount() {

		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream();
		final int n = stream.mapToInt(value -> 1).sum();

		Assert.assertEquals(8, n);
	}
}
