package experiment.lars.java;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestArrays {

	@Test
	public void testOneElementArray() {
		final String[] str = {"eins"};

		Assert.assertEquals(1, str.length);
		Assert.assertEquals("eins", str[0]);
	}

	@Test
	public void testOneElementArray2() {
		final String[] str = {"eins", "zwei"};

		Assert.assertEquals(2, str.length);
		Assert.assertEquals("eins", str[0]);
		Assert.assertEquals("zwei", str[1]);
	}

	@Test
	public void testArrayToArrayList() throws Exception {
	  final String[] digits = {"one", "two", "three", "for", "five"};
	  
    final List<String> digitList = Arrays.asList(digits);
    Assert.assertEquals(5,  digitList.size());
    Assert.assertEquals("one", digitList.get(0));
    Assert.assertEquals("two", digitList.get(1));
    Assert.assertEquals("five", digitList.get(4));
	}

}
