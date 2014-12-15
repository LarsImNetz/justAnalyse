package org.linuxx.moonserver.java7;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestDiamontOperator {

	@Test
	public void test() {
		List<Double> listOfDouble = new ArrayList<>(); // Der Generic muss rechts nicht mehr angegeben werden
		listOfDouble.add(1.2d);

		Assert.assertEquals(1.2d, listOfDouble.get(0), 0.01d);
	}

}
