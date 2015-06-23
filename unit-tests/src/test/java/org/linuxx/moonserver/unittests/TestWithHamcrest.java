package org.linuxx.moonserver.unittests;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TestWithHamcrest {

	/*
	 * Mehr unter http://www.tutego.de/blog/javainsel/2010/04/junit-4-tutorial-java-tests-mit-junit/
	 */
	@Test
	public void testSubString_with_start_end_param() {
		String value = "subStringTest";

		String expected = "bStr";
		String actual = value.substring(2, 4 + 2);

		Assert.assertThat(actual, CoreMatchers.is(CoreMatchers.equalTo(expected)));
	}

	@Test
	public void testSubString_with_start_param() {
		String value = "subStringTest";

		String actual = value.substring(9);

		Assert.assertThat(value, CoreMatchers.containsString(actual));
	}

	@Test
	public void testThatListHas3Element() {
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, "a", "b", "c", "d", "e");
		list.removeAll(Arrays.asList("b", "d"));

		Assert.assertThat(list, hasSize(3));
		Assert.assertThat(list, both(hasItems("a", "c", "e")).and(not(hasItems("b", "d"))));
	}
}
