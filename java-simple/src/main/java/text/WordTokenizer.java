package text;

import java.util.Enumeration;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * WordTokenizer zerpflückt einen Satz in seine Bestandteile
 * Ein Zeichen
 * Ein Word
 * Eine Zahl
 * 
 * @author lars.langhans
 *
 */
public class WordTokenizer implements Enumeration<String>{

	private final String sentence;

	private int cursorPosition = 0;
	private int maxPosition;
	
	public WordTokenizer(String sentence) {
		Preconditions.checkNotNull(sentence);
		
		this.sentence = sentence;
		this.maxPosition = sentence.length();
	}
	
	
	@Override
	public boolean hasMoreElements() {
		return cursorPosition < maxPosition;
	}

	@Override
	public String nextElement() {
		// TODO Auto-generated method stub
		char buchstabe = sentence.charAt(cursorPosition);
		if (CharMatcher.javaLetter().matches(buchstabe)) {
			return findWord();
		}
		if (CharMatcher.javaDigit().matches(buchstabe)) {
			return findDigit();
		}
		return findRest();
	}

	protected String findWord() {
		int startPosition = cursorPosition;
		
		// find words end
		while (cursorPosition < maxPosition) {
			char buchstabe = sentence.charAt(cursorPosition);
			if (!CharMatcher.javaLetter().matches(buchstabe)) {
				break;
			}
			cursorPosition ++;
		}
		final String word = sentence.substring(startPosition, cursorPosition);
		return word;
	}

	protected String findDigit() {
		int startPosition = cursorPosition;
		
		// find words end
		while (cursorPosition < maxPosition) {
			char buchstabe = sentence.charAt(cursorPosition);
			if (!CharMatcher.javaDigit().matches(buchstabe)) {
				break;
			}
			cursorPosition ++;
		}
		final String word = sentence.substring(startPosition, cursorPosition);
		return word;
	}

	protected String findRest() {
		int startPosition = cursorPosition;
		
		// find words end
		while (cursorPosition < maxPosition) {
			char buchstabe = sentence.charAt(cursorPosition);
			if (CharMatcher.javaLetterOrDigit().matches(buchstabe)) {
				break;
			}
			cursorPosition ++;
		}
		final String word = sentence.substring(startPosition, cursorPosition);
		return word;
	}

}
