package de.hypoport.einarbeitung.beans;

import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.CheckWithCheck;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotEmpty;

public class CheckWithClassBean {

	public static final String ERROR_1 = "Error 1";
	public static final String ERROR_2 = "Error 2";
	public static final String EMPTY_FIELD_ERROR="Das Feld ist nicht belegt.";

	@NotEmpty(errorCode=EMPTY_FIELD_ERROR)
	@MatchPattern(pattern = "^0[\\d ]+$", errorCode = ERROR_1)
	@CheckWith(TelephoneNumberCheck.class)
	String telefon;

	@CheckWith(TelephoneNumberCheck.class)
	@MatchPattern(pattern = "^0[\\d ]+$", errorCode = ERROR_2)
	String mobilphone;

	private static class TelephoneNumberCheck implements CheckWithCheck.SimpleCheck {
		public boolean isSatisfied(Object validatedObject, Object value) {

			if (((CheckWithClassBean) validatedObject).telefon == null && ((CheckWithClassBean) validatedObject).mobilphone == null) {
				return false;
			}
			return true;
		}
	}

	// @Assert(expr = "_this.telefon != null", lang = "bsh")
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getMobilphone() {
		return mobilphone;
	}

	public void setMobilphone(String mobilphone) {
		this.mobilphone = mobilphone;
	}

}
