package text;

/*
 * Manöverkritik:
 * - Es gibt zu viel doppelten Code
 * - Die Funktionen sind nicht kombinierbar
 */
public class BuchstabenDreher {

	private String word;

	public BuchstabenDreher(String word) {
		this.word = word;
	}

	public String verdrehen() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht verdrehen.
		if (word.length() < 4) {
			return word;
		}

		char[] buchstaben = word.toCharArray();

		// Immer zwei aufeinander folgende Buchstaben verdrehen
		
		for (int position = 1; position < buchstaben.length - 2; position += 2) {
			swap(buchstaben, position, position + 1);
		}

		String newWord = new String(buchstaben);
		return newWord;
	}

	public String verwuerfeln() {
		// Wörter mit weniger als 4 Buchstaben lassen sich nicht verdrehen.
		if (word.length() < 5) {
			return word;
		}

		char[] buchstaben = word.toCharArray();
		
		// Immer den 2 und den vor letzen Buchstaben tauschen
		int position = 1;
		swap(buchstaben, position, buchstaben.length - 2);

		String newWord = new String(buchstaben);
		return newWord;
	}
	
	private void swap(char[] buchstaben, int position, int nextPosition) {
		// swap
		char tmp = buchstaben[nextPosition];
		buchstaben[nextPosition] = buchstaben[position];
		buchstaben[position] = tmp;
	}
}
