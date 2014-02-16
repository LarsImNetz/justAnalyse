package de.hypoport.einarbeitung.beans;

import net.sf.oval.configuration.annotation.IsInvariant;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class JustBean {
	public JustBean() {
	}

	@NotNull
	@NotEmpty
	@Length(max = 32)
	public String name;

	/**
	 * Länderkennung nach ISO 3166
	 */
	@NotNull
	@NotEmpty
	@Length(max = 2)
	public String land;

	public String telefonnummer;
	public String mobilnummer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	@IsInvariant
	@NotNull
	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getMobilnummer() {
		return mobilnummer;
	}

	public void setMobilnummer(String mobilnummer) {
		this.mobilnummer = mobilnummer;
	}

}
