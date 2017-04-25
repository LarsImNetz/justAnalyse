
package eightladies;

public class TenLadies {

	private final int size = 10;

	int[][] field;
	int nSolutions = 0;

	public TenLadies() {
		field = new int[size][size];
	}

	public void findSolution() {
		for (int a = 0; a < size; a++) {
			if (checkLady(0, a)) {
				set(0, a);
				for (int b = 0; b < size; b++) {
					if (checkLady(1, b)) {
						set(1, b);
						for (int c = 0; c < size; c++) {
							if (checkLady(2, c)) {
								set(2, c);
								for (int d = 0; d < size; d++) {
									if (checkLady(3, d)) {
										set(3, d);
										for (int e = 0; e < size; e++) {
											if (checkLady(4, e)) {
												set(4, e);
												for (int f = 0; f < size; f++) {
													if (checkLady(5, f)) {
														set(5, f);
														for (int g = 0; g < size; g++) {
															if (checkLady(6, g)) {
																set(6, g);
																for (int h = 0; h < size; h++) {
																	if (checkLady(7, h)) {
																		set(7, h);
																		for (int i = 0; i < size; i++) {
																			if (checkLady(8, i)) {
																				set(8, i);
																				for (int j = 0; j < size; j++) {
																					if (checkLady(9, j)) {
																						set(9, j);
																						// 10 Damen richtig gesetzt!
																						nSolutions++;
																						showField();
																						unset(9, j);
																					}
																				}
																				unset(8, i);
																			}
																		}
																		unset(7, h);
																	}
																}
																unset(6, g);
															}
														}
														unset(5, f);
													}
												}
												unset(4, e);
											}
										}
										unset(3, d);
									}
								}
								unset(2, c);
							}
						}
						unset(1, b);
					}
				}
				unset(0, a);
			}
		}

	}

	public void showField() {
		showField2();

		// Schicker Output für PmWiki
		//		final EightLadiesTable table = new EightLadiesTable(field);
		//			System.out.println(table.output());
	}

	public void showField2() {
		System.out.println("Solution: " + nSolutions);
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				String output = ".";
				if (field[x][y] != 0) {
					output = "#";
				}
				System.out.print(output + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void set(final int x, final int y) {
		field[x][y] = 1;
	}

	public void unset(final int x, final int y) {
		field[x][y] = 0;
	}

	private static boolean BELEGT = false;
	private static boolean FREI = true;

	/**
	 * Check if a Lady can set to xl, yl one a Chess Field
	 * 
	 * @param xl
	 * @param yl
	 * @return
	 */
	public boolean checkLady(final int xl, final int yl) {
		// check horizontal
		for (int x = 0; x < size; x++) {
			if (field[x][yl] != 0) {
				return BELEGT;
			}
		}
		// check vertical
		for (int y = 0; y < size; y++) {
			if (field[xl][y] != 0) {
				return BELEGT;
			}
		}
		// check diagonal left to right
		int x1 = xl - yl;
		int y = 0;
		if (x1 < 0) {
			y = Math.abs(x1);
			x1 = 0;
		}
		for (int x = x1; x < size; x++) {
			if (field[x][y++] != 0) {
				return BELEGT;
			}
			if (y >= size) {
				break;
			}
		}
		// check diagonal right to left
		int x2 = xl + yl;
		y = 0;
		if (x2 >= size) {
			y = x2 - (size - 1);
			x2 = (size - 1);
		}
		for (int x = x2; x >= 0; --x) {
			if (field[x][y++] != 0) {
				return BELEGT;
			}
			if (y >= size) {
				break;
			}
		}
		return FREI;
	}
}
