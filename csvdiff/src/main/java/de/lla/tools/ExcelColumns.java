package de.lla.tools;

public class ExcelColumns {

	public ExcelColumns() {
	}

	/*
	 * 'A' - 'Z' 'AA', 'AB','AC' - 'ZZ'
	 */
	public String get(int column) {
		if (column < 26) {
			return getOne(column);
		}

		int first = column % 26;
		int second = column / 26;
		return getOne(second - 1) + getOne(first);
	}

	private String getOne(int column) {
		char first = 'A';
		first += column;
		return new Character(first).toString();
	}
}
