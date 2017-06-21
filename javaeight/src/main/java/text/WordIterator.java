package text;

import java.util.Iterator;

class WordIterator implements Iterator<String> {

	private final String[] words;
	private int cursor = 0;

	public WordIterator(final String sentence) {
		if (sentence == null || sentence.isEmpty()) {
			words = new String[0];
		}
		else {
			words = sentence.split(" ");
		}
	}
	@Override
	public boolean hasNext() {
		return cursor < words.length;
	}

	@Override
	public String next() {
		return words[cursor++];
	}

}
