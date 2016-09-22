package text;

import com.google.common.base.Preconditions;

/**
 * SatzDreher verdreht in einem gegebenen Satz nur die Wörter, nicht aber die Satzzeichen und die Wortreihenfolge. 
 *
 */
public class SatzDreher {
	private final String satz;

	private final WordDreher dreher;
	
	public SatzDreher(String satz) {
		// Guava Preconditions
		// @see https://github.com/google/guava/wiki/PreconditionsExplained
		Preconditions.checkNotNull(satz);
		dreher = new WordDreher();
		this.satz = satz;
	}
	
	public String getSatz() {
		return satz;
	}
	
	public String getVerdrehtenSatz() {
		SentenceTokenizer tokenizer = new SentenceTokenizer(satz);
		StringBuilder verdreherSatz = new StringBuilder();
		while(tokenizer.hasMoreElements()) {
			String token = tokenizer.nextElement();
			if (tokenizer.isWord()) {
				dreher.setWord(token);
				dreher.verdrehen();
				// dreher.verwuerfeln();
				token = dreher.getWord();
			}
			verdreherSatz.append(token);
		}
		return verdreherSatz.toString();
	}
}
