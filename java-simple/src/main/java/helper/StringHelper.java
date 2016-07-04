package helper;

public class StringHelper {

	/**
	 * ist dem cdr aus Scheme nachempfunden
	 * 
	 * @param strings
	 * @return
	 */
	public String[] cdr(final String... strings) {
		if (strings == null || strings.length == 0) {
			throw new IllegalArgumentException("Array sollte mindestens ein Element enthalten");
		}

		final String[] newStrings = new String[strings.length - 1];
		for (int i = 1; i < strings.length; i++) {
			newStrings[i - 1] = strings[i];
		}
		return newStrings;
	}

	/**
	 * Nur der Vollständigkeit halber implementiert
	 * 
	 * @param strings
	 * @return
	 */
	public String car(final String... strings) {
		return strings[0];
	}
}
