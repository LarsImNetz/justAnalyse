package de.hypoport.einarbeitung.compound;



public class CompoundKey {

	private LaufzeitEnum laufzeit;
	private TilgungEnum tilgung;

	public CompoundKey(LaufzeitEnum laufzeit, TilgungEnum tilgung) {
		this.laufzeit = laufzeit;
		this.tilgung = tilgung;
	}

	public LaufzeitEnum getLaufzeit() {
		return laufzeit;
	}

	public void setLaufzeit(LaufzeitEnum laufzeit) {
		this.laufzeit = laufzeit;
	}

	public TilgungEnum getTilgung() {
		return tilgung;
	}

	public void setTilgung(TilgungEnum tilgung) {
		this.tilgung = tilgung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((laufzeit == null)
				? 0
				: laufzeit.hashCode());
		result = prime * result + ((tilgung == null)
				? 0
				: tilgung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompoundKey other = (CompoundKey) obj;
		if (laufzeit != other.laufzeit)
			return false;
		if (tilgung != other.tilgung)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompoundKey [laufzeit=" + laufzeit + ", tilgung=" + tilgung + "]";
	}

}
