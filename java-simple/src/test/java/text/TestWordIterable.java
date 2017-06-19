package text;

import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestWordIterable {
	private WordIterable streamableWordIterableSUT;

	@Before
	public void setUp() {
		streamableWordIterableSUT = new WordIterable("Auge um Auge");
	}
	
	@Test
	public void test() {
		Consumer<? super String> consumer = new MyConsumer();
		streamableWordIterableSUT.iterator().forEachRemaining(consumer);
	}
	
	private static class MyConsumer implements Consumer<String> {
		@Override
		public void accept(String arg0) {
			System.out.println(arg0);		
		}		
	}
	
	@Test
	public void testBuildSentence() {
		StringBuilder buffer = new StringBuilder();
		
		streamableWordIterableSUT.iterator().forEachRemaining(n -> buffer.append(n).append(" "));

		Assert.assertEquals("Auge um Auge ", buffer.toString());
	}
}
