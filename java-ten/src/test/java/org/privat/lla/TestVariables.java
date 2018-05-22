package org.privat.lla;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestVariables {

	@Test
	public void testInitialiseAString() {
		var aString = "Ich bin ein String";
		Assert.assertTrue(aString instanceof String);
	}

	@Test
	public void testInitialiseAnInt() {
		var aInt = 12_345;
		Assert.assertEquals(aInt, 12_345);
	}

	@Test
	public void testInitialiseAnLong() {
		var aInt = 12_345_678_901_234_567L;
		Assert.assertEquals(aInt, 12_345_678_901_234_567L);
	}

	@Test
	public void testInitialiseAnDouble() {
		var aDouble = 3.1415;
		Assert.assertEquals(aDouble, Math.PI, 0.0001);
	}

	@Test
	public void testInitialiseAnInteger() {
		var aInteger = Integer.valueOf(12345);
		Assert.assertEquals(aInteger, Integer.valueOf(12345));
	}

	@Test
	public void testInitialiseListWithLeftDeclaration() {
		 List<Integer> list = new ArrayList<>();
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 
		 Assert.assertThat(list, hasItems(1, 2, 3));
	}

	@Test
	public void testInitialiseListWithArrays() {
		 var list = Arrays.asList(1,2,3);
		 Assert.assertThat(list, hasItems(1, 2, 3));
	}

	@Test
	public void testInitialiseListNew() {
		 var list = new ArrayList<Integer>();
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 
		 Assert.assertThat(list, hasItems(1, 2, 3));
	}
}
