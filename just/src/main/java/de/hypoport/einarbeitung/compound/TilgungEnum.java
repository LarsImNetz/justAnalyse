package de.hypoport.einarbeitung.compound;

import de.hypoport.einarbeitung.toolkit.Zins;

public enum TilgungEnum {
	EIN_PROZENT(1),
	ZWEI_PROZENT(2),
	DREI_PROZENT(3),
	VIER_PROZENT(4),
	FUENF_PROZENT(5),
	INVALID(-1);

	private final int tilgung;

	private TilgungEnum(final int tilgung) {
		this.tilgung = tilgung;
	}

	public int getInt() {
		return tilgung;
	}

	public Zins getZins() {
		return Zins.valueOf((float) tilgung);
	}

	public static TilgungEnum forInt(int val) {
		for (TilgungEnum tilgung : values()) {
			if (tilgung.getInt() == val) {
				return tilgung;
			}
		}
		return TilgungEnum.INVALID;
	}

}
