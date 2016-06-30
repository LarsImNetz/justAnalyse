package org.lla.phrasendrescher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestDiamontOperator {

	@Test
	public void test() {
		final List<String> listOfString = new ArrayList<>(); // Der Generic muss
		// rechts nicht mehr
		// angegeben werden
		listOfString.add("Hallo");
		listOfString.addAll(Arrays.asList("schöne", "Welt"));
		Assert.assertEquals("Hallo", listOfString.get(0));
		Assert.assertEquals("Welt", listOfString.get(2));
	}

}
