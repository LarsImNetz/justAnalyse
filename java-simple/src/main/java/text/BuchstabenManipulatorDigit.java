package text;

import com.google.common.base.Preconditions;

/**
 * Manipuliert eine gegebene Menge von Buchstaben
 * - Es wird nicht geprüft, ob die Menge leer ist (Design by contract)
 * - Es wird nicht geprüft, ob eine gewisse Länge vorhanden ist
 *
 * Der erste und der letze Buchstaben bleiben unberührt, das Gehirn sollte das Word weiter lesen können
 * Zumindest Muttersprachler sollten das nach kurzer eingewöhnung schnell beherrschen.
 * 
 */
public class BuchstabenManipulatorDigit {

	private char[] buchstaben;
	
	public BuchstabenManipulatorDigit() {
	}

	public void setWord(String word) {
		Preconditions.checkArgument(word != null);
		this.buchstaben = word.toCharArray();
	}
	
	public String getWord() {
		return new String(this.buchstaben);
	}
	
	void buchstabenErsetzen() {
		// PRE: Es sollte eine Menge von Buchstaben geben

		// Immer zwei aufeinander folgende Buchstaben verdrehen
		
		for (int position = 0; position < buchstaben.length; position ++) {
			buchstaben[position] = convert(this.buchstaben[position]);			
		}
	}

	private char convert(char buchstabe) {
		String buchstabetoUpper = String.valueOf(buchstabe).toUpperCase();
		switch(buchstabetoUpper) {
			case "I":
				buchstabetoUpper = "1";
				break;
			case "Z":
				buchstabetoUpper = "2";
				break;
			case "E":
				buchstabetoUpper = "3";
				break;
			case "A":
				buchstabetoUpper = "4";
				break;
			case "S":
				buchstabetoUpper = "5";
				break;
//			case "G":
//				buchstabetoUpper = "6";
//				break;
			case "T":
				buchstabetoUpper = "7";
				break;
			case "B":
				buchstabetoUpper = "8";
				break;
			case "O":
				buchstabetoUpper = "0";
				break;
		}
		return buchstabetoUpper.charAt(0);
	}
}
