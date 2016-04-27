package org.linuxx.moonserver.map.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class TestReduce {

	@Test
	public void testReduce() {
		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream();
		final Integer summe = stream.reduce(0, (a, b) -> a + b);

		Assert.assertEquals(Integer.valueOf(10 + 20 + 30 + 40 + 50 + 60 + 70 + 80), summe);
	}

}
