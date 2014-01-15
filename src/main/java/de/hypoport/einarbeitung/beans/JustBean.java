package de.hypoport.einarbeitung.beans;

public class JustBean {
	public JustBean() {}
/*
	  @NotNull
	  @NotEmpty
	  @Length(max=32)
	  */
	  public String name;
	public String vorname;

	public String telefonnummer;
	public String mobilnummer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
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
