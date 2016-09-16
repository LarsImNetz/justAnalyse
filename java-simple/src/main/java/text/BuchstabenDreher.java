package text;

/*
 * Buchstabendreher
 * Verdreht und Vertauscht buchstaben in einer beliebigen Reihenfolge
 */
public class BuchstabenDreher {

	private String word;
	private BuchstabenManipulator manipulator;
	
	public BuchstabenDreher(String word) {
		this.word = word;
		manipulator = new BuchstabenManipulator(word);
	}

	public String getWord() {
		return manipulator.getWord();
	}
	
	public void verdrehen() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht verdrehen.
		if (word.length() < 4) {
			return;
		}

		manipulator.buchstabenNachbarnTauschen();
	}

	public void verwuerfeln() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht tauschen.
		if (word.length() < 4) {
			return;
		}
	
		manipulator.buchstabenZweitenMitLetztemTauschen();
	}
	
}
