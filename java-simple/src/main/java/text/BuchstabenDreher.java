package text;

import com.google.common.base.Preconditions;

/*
 * Buchstabendreher
 * Verdreht und Vertauscht buchstaben in einer beliebigen Reihenfolge
 */
public class BuchstabenDreher {

	private String word;
	private BuchstabenManipulator manipulator;
	
	public BuchstabenDreher(String word) {
		Preconditions.checkNotNull(word, "Bitte ein Wort angeben.");
		Preconditions.checkArgument(word.indexOf(" ") == -1, "Bitte nur einzelne Wörter angeben!");
		
		this.word = word;
		manipulator = new BuchstabenManipulator(word);
	}

	public String getWord() {
		return manipulator.getWord();
	}
	
	public BuchstabenDreher verdrehen() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht verdrehen.
		if (word.length() < 4) {
			return this;
		}

		manipulator.buchstabenNachbarnTauschen();
		return this;
	}

	public BuchstabenDreher verwuerfeln() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht tauschen.
		if (word.length() < 4) {
			return this;
		}
	
		manipulator.buchstabenZweitenMitLetztemTauschen();
		return this;
	}
	
}
