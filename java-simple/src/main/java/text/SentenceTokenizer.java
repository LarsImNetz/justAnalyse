package text;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * SentenceTokenizer zerpflückt einen Satz in seine Bestandteile
 * Ein Word
 * Eine Zahl (nur Ziffern!)
 * Ein Zeichen
 * 
 * Guava Usage Examples
 * https://github.com/leveluplunch/levelup-java-examples/tree/master/src/test/java/com/levelup/java/guava
 */
public class SentenceTokenizer implements Enumeration<String> {

	private final String sentence;

	private int cursorPosition = 0;
	private int maxCursorPosition;

	public enum Type {
		WORD,
		NUMBER,
		OTHER,
		NOT_INITIALISED
	};

	private Type elementType;
	
	public SentenceTokenizer(String sentence) {
		Preconditions.checkNotNull(sentence);

		this.elementType = Type.NOT_INITIALISED;
		this.sentence = sentence;
		this.maxCursorPosition = sentence.length();
	}

	public Type getElementType() {
		return elementType;
	}

	public boolean isWord() {
		return elementType.equals(Type.WORD);
	}
	
	@Override
	public boolean hasMoreElements() {
		return cursorPosition < maxCursorPosition;
	}

	@Override
	public String nextElement() {
		if (!hasMoreElements()) {
			throw new NoSuchElementException("There are no more items");
		}

		char buchstabe = sentence.charAt(cursorPosition);
		if (CharMatcher.javaLetter().matches(buchstabe)) {
			elementType = Type.WORD;
			return findWord();
		}
		if (CharMatcher.javaDigit().matches(buchstabe)) {
			elementType = Type.NUMBER;
			return findDigit();
		}
		elementType = Type.OTHER;
		return findRest();
	}

	// TODO: findWord, findDigit, findRest zusammenfassen, nur die Abbruchbedingung ist anders
	private String findWord() {
		int startPosition = cursorPosition;

		// find words end
		while (cursorPosition < maxCursorPosition) {
			char buchstabe = sentence.charAt(cursorPosition);
			if (!CharMatcher.javaLetter().matches(buchstabe)) {
				break;
			}
			cursorPosition++;
		}
		final String word = sentence.substring(startPosition, cursorPosition);
		return word;
	}

	private String findDigit() {
		int startPosition = cursorPosition;

		// find words end
		while (cursorPosition < maxCursorPosition) {
			char buchstabe = sentence.charAt(cursorPosition);
			if (!CharMatcher.javaDigit().matches(buchstabe)) {
				break;
			}
			cursorPosition++;
		}
		final String word = sentence.substring(startPosition, cursorPosition);
		return word;
	}

	private String findRest() {
		int startPosition = cursorPosition;

		// find words end
		while (cursorPosition < maxCursorPosition) {
			char buchstabe = sentence.charAt(cursorPosition);
			if (CharMatcher.javaLetterOrDigit().matches(buchstabe)) {
				break;
			}
			cursorPosition++;
		}
		final String word = sentence.substring(startPosition, cursorPosition);
		return word;
	}

}
