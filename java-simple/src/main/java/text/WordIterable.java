package text;

import java.util.Iterator;

public class WordIterable implements Iterable<String> {

	private final Iterator<String> wordIterator;
	
	public WordIterable(String sentence) {
		wordIterator = new WordIterator(sentence);
	}

	@Override
	public Iterator<String> iterator() {
		return wordIterator;
	}

}
