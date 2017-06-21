package org.linuxx.moonserver.stream;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Please insert only filter tests here
 *
 */
public class TestStreamFiltering {

	/*
	 * http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-
	 * 2177646.html
	 */
	private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

	@Ignore
	@Test
	public void testFilterMapLimitCollect() {
		List<Integer> twoEvenSquares = numbers.stream().filter(n -> {
			System.out.println("filtering " + n);
			return n % 2 == 0;
		}).map(n -> {
			System.out.println("mapping " + n);
			return n * n;
		}).limit(2).collect(Collectors.toList());
	}

	@Test
	public void testStreamCollect() {
		List<Integer> newList = numbers.stream().collect(Collectors.toList());

		Assert.assertEquals(8, newList.size());
	}

	@Test
	public void testStreamSkipCollect() {

		List<Integer> newList = numbers.stream().skip(4).collect(Collectors.toList());

		Assert.assertEquals(4, newList.size());
		Assert.assertThat(newList, hasSize(4));
		Assert.assertThat(newList, both(hasItems(5, 6, 7, 8)).and(not(hasItems(1, 2, 3, 4))));
	}

	@Test
	public void testStreamLimitCollect() {

		List<Integer> newList = numbers.stream().limit(4).collect(Collectors.toList());

		Assert.assertThat(newList, hasSize(4));
		Assert.assertThat(newList, both(hasItems(1, 2, 3, 4)).and(not(hasItems(5, 6, 7, 8))));
	}

	@Test
	public void testStreamSkipLimitCollect() {

		List<Integer> newList = numbers.stream().skip(2).limit(4).collect(Collectors.toList());

		Assert.assertThat(newList, hasSize(4));
		Assert.assertThat(newList, both(hasItems(3, 4, 5, 6)).and(not(hasItems(1, 2, 7, 8))));
	}

	@Test
	public void testStreamFilterWithValueEqual3Collect() {

		List<Integer> newList = numbers.stream().filter(n -> n == 3).collect(Collectors.toList());

		Assert.assertThat(newList, hasSize(1));
		Assert.assertThat(newList, both(hasItems(3)).and(not(hasItems(1, 2, 4, 5, 6, 7, 8))));
	}

	@Test
	public void testStreamFilterWithEvenValueCollect() {

		List<Integer> newList = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		Assert.assertThat(newList, hasSize(4));
		Assert.assertThat(newList, both(hasItems(2, 4, 6, 8)).and(not(hasItems(1, 3, 5, 7))));
	}


}
