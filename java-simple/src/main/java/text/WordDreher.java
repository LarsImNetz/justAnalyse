package text;

import com.google.common.base.Preconditions;

/*
 * Buchstabendreher
 * Verdreht und Vertauscht buchstaben in einer beliebigen Reihenfolge
 */
public class WordDreher {

	private String word;
	private final BuchstabenManipulator manipulator;
	
	public WordDreher() {		
		// TODO: per injection
		manipulator = new BuchstabenManipulator();
	}

	public void setWord(String word) {
		Preconditions.checkNotNull(word, "Bitte ein Wort angeben.");
		Preconditions.checkArgument(word.indexOf(" ") == -1, "Bitte nur einzelne Wörter angeben!");
		this.word = word;
		this.manipulator.setWord(word);
	}
	
	public String getWord() {
		return manipulator.getWord();
	}
	
	public WordDreher verdrehen() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht verdrehen.
		if (word.length() < 4) {
			return this;
		}

		manipulator.buchstabenNachbarnTauschen();
		return this;
	}

	public WordDreher verwuerfeln() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht tauschen.
		if (word.length() < 4) {
			return this;
		}
	
		manipulator.buchstabenZweitenMitLetztemTauschen();
		return this;
	}
	
}
