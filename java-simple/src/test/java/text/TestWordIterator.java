package text;

import org.junit.Assert;
import org.junit.Test;


public class TestWordIterator {

	private WordIterator wordIteratorSUT;

	@Test
	public void testIterator() {
		String sentence = "Hello World";
		wordIteratorSUT = new WordIterator(sentence);
		Assert.assertTrue(wordIteratorSUT.hasNext());
		Assert.assertEquals("Hello", wordIteratorSUT.next());
		Assert.assertTrue(wordIteratorSUT.hasNext());
		Assert.assertEquals("World", wordIteratorSUT.next());
		Assert.assertFalse(wordIteratorSUT.hasNext());
	}
	
	@Test
	public void testIterator_Empty() {
		wordIteratorSUT = new WordIterator("");
		Assert.assertFalse(wordIteratorSUT.hasNext());		
	}

	@Test
	public void testIterator_Null() {
		wordIteratorSUT = new WordIterator(null);
		Assert.assertFalse(wordIteratorSUT.hasNext());		
	}
}
