package de.vergleich.toolkit.type.enumeration;

public enum LaufzeitEnum {
	FUENF_JAHRE(5),
	ACHT_JAHRE(8),
	ZEHN_JAHRE(10),
	ZWOELF_JAHRE(12),
	FUENFZEHN_JAHRE(15),
	ZWANZIG_JAHRE(20);

	private final Integer laufzeit;

	private LaufzeitEnum(final Integer laufzeit) {
		this.laufzeit = laufzeit;
	}

	public Integer getInt() {
		return this.laufzeit;
	}

	public static LaufzeitEnum forInt(int val) {
		for (LaufzeitEnum laufzeit : LaufzeitEnum.values()) {
			if (laufzeit.getInt().equals(val)) {
				return laufzeit;
			}
		}
		return null;
	}

}
