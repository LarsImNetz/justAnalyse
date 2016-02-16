package eightladies;

public class EightLadies {

	int[][] field;
	int nSolutions = 0;
	
	public EightLadies() {
		field = new int[8][8];
		
	}

	public void findSolution() {
		for (int a = 0; a < 8; a++) {
			if (checkLady(0, a)) {
				set(0, a);
				for (int b = 0; b < 8; b++) {
					if (checkLady(1, b)) {
						set(1, b);
						for (int c = 0; c < 8; c++) {
							if (checkLady(2, c)) {
								set(2, c);
								for (int d = 0; d < 8; d++) {
									if (checkLady(3, d)) {
										set(3, d);
										for (int e = 0; e < 8; e++) {
											if (checkLady(4, e)) {
												set(4, e);
												for (int f = 0; f < 8; f++) {
													if (checkLady(5, f)) {
														set(5, f);
														for (int g = 0; g < 8; g++) {
															if (checkLady(6, g)) {
																set(6, g);
																for (int h = 0; h < 8; h++) {
																	if (checkLady(7, h)) {
																		set(7, h);
																		// 8 Damen richtig gesetzt!
																		nSolutions++;
																		showField();
																		unset(7,h);
																	}
																	else {
																		unset(7, h);
																	}
																}
																unset(6,g);
															}
															else {
																unset(6, g);
															}
														}
														unset(5,f);
													}
													else {
														unset(5, f);
													}
												}
												unset(4,e);
											}
											else {
												unset(4, e);
											}
										}
										unset(3,d);
									}
									else {
										unset(3, d);
									}
								}
								unset(2,c);
							}
							else {
								unset(2, c);
							}
						}
						unset(1,b);
					}
					else {
						unset(1, b);
					}
				}
				unset(0,a);
			}
			else {
				unset(0, a);
			}
		}
	}

	public void showField() {
		System.out.println("Solution: " + nSolutions);
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
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

	public boolean checkLady(final int xl, final int yl) {
		// check horizontal
		for (int x = 0; x < 8; x++) {
			if (field[x][yl] != 0) {
				return BELEGT;
			}
		}
		// check vertical
		for (int y = 0; y < 8; y++) {
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
		for (int x = x1; x < 8; x++) {
			if (field[x][y++] != 0) {
				return BELEGT;
			}
			if (y >= 8) {
				break;
			}
		}
		// check diagonal right to left
		int x2 = xl + yl;
		y = 0;
		if (x2 >= 8) {
			y = x2 - 7;
			x2 = 7;
		}
		for (int x = x2; x >= 0; --x) {
			if (field[x][y++] != 0) {
				return BELEGT;
			}
			if (y >= 8) {
				break;
			}
		}
		return FREI;
	}
}
