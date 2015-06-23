package org.linuxx.moonserver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class TestEight {

	@Test
	public void test() {

		List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		Stream<Integer> stream = asList.stream();
		double sum = stream.filter(value -> value > 40).mapToDouble(value -> value * 1.0).sum();

		Assert.assertEquals(50 + 60 + 70 + 80d, sum, 0.01);
		System.out.println("Summe: " + sum);
	}

}
