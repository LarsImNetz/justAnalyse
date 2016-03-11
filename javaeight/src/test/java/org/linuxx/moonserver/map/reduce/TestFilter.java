package org.linuxx.moonserver.map.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;


public class TestFilter {

	@Test
	public void test() {
		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream(	);
		final Object[] array = stream.filter(value -> value > 40).toArray();
		
		Assert.assertTrue(array.length == 4);
	}

}
