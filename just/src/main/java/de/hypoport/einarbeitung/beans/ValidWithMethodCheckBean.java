package de.hypoport.einarbeitung.beans;

import net.sf.oval.constraint.ValidateWithMethod;
import net.sf.oval.guard.Guarded;

@Guarded
public class ValidWithMethodCheckBean {
	// Eins von beiden soll erlaubt sein
	// @NotNull

	@ValidateWithMethod(methodName = "isTelefonNumberValid", parameterType=String.class)
	private String telefon;

	@SuppressWarnings("unused")
    private boolean isTelefonNumberValid(final String telephoneNumber) {
		if (telephoneNumber == null) {return false;}
		if (telephoneNumber.isEmpty()) {return false;}
		if (telephoneNumber.charAt(0) != '0') {return false;}
		return true;
	}


	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}
