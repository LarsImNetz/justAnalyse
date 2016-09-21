package text;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * WordTokenizer zerpflückt einen Satz in seine Bestandteile
 * Ein Zeichen
 * Ein Word
 * Eine Zahl
 * 
 * Idee: Wir können in die Zukunft gucken und wissen was als nächstes kommt, dann kann man leichter auf das Ergebnis reagieren
 *
 * Guava Usage Examples
 * https://github.com/leveluplunch/levelup-java-examples/tree/master/src/test/java/com/levelup/java/guava
 */
public class WordTokenizer implements Enumeration<String> {

	private final String sentence;

	private int cursorPosition = 0;
	private int maxCursorPosition;

	private boolean hasNextElements;
	private String nextElement;

	public enum Type {
		WORD,
		DIGIT,
		PUNCTUATION
	};

	private Type elementType;
	
	public WordTokenizer(String sentence) {
		Preconditions.checkNotNull(sentence);

		this.sentence = sentence;
		this.maxCursorPosition = sentence.length();

		this.hasNextElements = lookForMoreElement();
		peekElement();
	}

	private boolean lookForMoreElement() {
		return cursorPosition < maxCursorPosition;
	}

	private void peekElement() {
		if (!hasNextElements) {
			return;
		}

		if (!lookForMoreElement()) {
			hasNextElements = false;
			return;
		}

		char buchstabe = sentence.charAt(cursorPosition);
		if (CharMatcher.javaLetter().matches(buchstabe)) {
			elementType = Type.WORD;
			nextElement = findWord();
			return;
		}
		if (CharMatcher.javaDigit().matches(buchstabe)) {
			elementType = Type.DIGIT;
			nextElement = findDigit();
			return;
		}
		elementType = Type.PUNCTUATION;
		nextElement  = findRest();
	}

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

	public Type getNextElementType() {
		return elementType;
	}
	
	// Enumeration API
	@Override
	public boolean hasMoreElements() {
		return hasNextElements;
	}

	@Override
	public String nextElement() {
		if (!hasNextElements) {
			throw new NoSuchElementException("There are no more items");
		}
		final String result = nextElement;
		peekElement();
		return result;
	}
}
