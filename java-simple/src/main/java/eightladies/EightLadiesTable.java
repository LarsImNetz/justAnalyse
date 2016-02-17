package eightladies;

public class EightLadiesTable {

	String turm = "&#x265c;";
	String reiter = "&#x265e;";
	String springer = "&#x265d;";
	String koenig = "&#x265b;";
	String dame = "&#x265a;";
	String bauer = "&#x265f;";

	String turmWeiss = "&#x2656;";
	String reiterWeiss = "&#x2658;";
	String springerWeiss = "&#x2657;";
	String koenigWeiss = "&#x2655;";
	String dameWeiss = "&#x2654;";
	String bauerWeiss = "&#x2659;";

	int[][] field;

	public EightLadiesTable(final int[][] field) {
		this.field = field;
	}

	public String output() {
		final StringBuilder brett = new StringBuilder();
		brett.append("(:table cellpadding=3 cellspacing=0 border=1:)");
		brett.append("\n");
		for (int y = 0; y < 8; y++) {
			brett.append(row(y));
			brett.append("\n");
		}
		brett.append("(:tableend:)");
		brett.append("\n");
		return brett.toString();
	}

	public String row(final int y) {
		final StringBuilder row = new StringBuilder();
		for (int x = 0; x < 8; x++) {
			row.append("(:").append(cell(x, y)).append(" ").append(backgroundColor(x, y)).append(":)");
			if (field[x][y] == 1) {
				row.append("\n");
				row.append(dame);
			}
			row.append("\n");
		}
		return row.toString();
	}

	public String backgroundColor(final int x, final int y) {
		if (x % 2 == 0) {
			if (y % 2 == 0) {
				return "bgcolor=#ffffff";
			}
			else {		
				return "bgcolor=#e0e0e0";
			}
		}
		else {
			if (y % 2 == 0) {
				return "bgcolor=#e0e0e0";
			}
			else {		
				return "bgcolor=#ffffff";
			}			
		}
	}

	public String cell(final int x, final int y) {
		if (x == 0) {
			return "cellnr";
		}
		return "cell";
	}

	/*
	 * (:table cellpadding=3 cellspacing=0 border=1:)
	 * (:cellnr bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * 
	 * (:cellnr bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * 
	 * (:cellnr bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * 
	 * (:cellnr bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * 
	 * (:cellnr bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * 
	 * (:cellnr bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * 
	 * (:cellnr bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * 
	 * (:cellnr bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:cell bgcolor=#e0e0e0:)
	 * (:cell bgcolor=#ffffff:)
	 * (:tableend:)
	 */
}
