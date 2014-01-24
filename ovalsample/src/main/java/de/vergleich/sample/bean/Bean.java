package de.vergleich.sample.bean;

import java.io.Serializable;

import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.CheckWithCheck.SimpleCheck;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

public class Bean implements Serializable, BeanErrorCodes {

	//??? @AssertValid
	@NotNull(errorCode = VIOLATION_NOTNULL)
	@MatchPattern(pattern = "^[A-Z].*", errorCode = VIOLATION_GROSSBUCHSTABE)
	@Length(max = 32, errorCode = VIOLATION_LENGTH)
	String name;


	@NotNull
	@Min(value = 50000, errorCode = VIOLATION_DARLEHENSBETRAG_TO_LOW)
	@Max(value = 1000000, errorCode = VIOLATION_DARLEHENSBETRAG_TO_HIGH)
	// ! @Range(min = 50000, max = 1000000)
	Double darlehensbetrag;

	
	@NotNull
	@Range(min = 1, max = 1000000)
	Double immobilienwert;



	/**
	 * Die Monatliche Rate
	 * soll im Bereich darlehensbetrag / 12 / 40 und darlehensbetrag / 12 / 5 liegen
	 *
	 * Weitere Infos
	 * http://oval.sourceforge.net/userguide.html#complex-class-specific-constraints
	 */

	@NotNull
	// @ValidateWithMethod(methodName = "isMonatlicheRateValid", parameterType = Double.class)
	@CheckWith(value = MonatlicheRateCheck.class, errorCode = VIOLATION_MONATLICHE_RATE)
	Double monatlicheRate;

	@SuppressWarnings("unused")
	private boolean isMonatlicheRateValid(final Double rate) {
		// Sinnfrei?
		// if (rate == null) {
		// return false;
		// }
		// if (rate < 0) {
		// return false;
		// }
		//
		// if (darlehensbetrag <= 0) {
		// return false;
		// }

		// Berechnen, welche Rate min. bezahlt werden sollte
		double monatsrate = darlehensbetrag / 12;

		// bei 5 Jahren
		double max = monatsrate / 5;
		if (rate > max) {
			return false;
		}

		// bei 40 Jahren Laufzeit
		double min = monatsrate / 40;
		if (rate < min) {
			return false;
		}
		return true;
	}

	private static class MonatlicheRateCheck implements SimpleCheck {
		public boolean isSatisfied(Object beanObject, Object value) {
			final Bean bean = ((Bean) beanObject);
			Double rate = (Double) value;

			// Berechnen, welche Rate min. bezahlt werden sollte
			double monatsrate = bean.darlehensbetrag / 12;

			// bei 5 Jahren
			double max = monatsrate / 5;
			if (rate > max) {
				return false;
			}

			// bei 40 Jahren Laufzeit
			double min = monatsrate / 40;
			if (rate < min) {
				return false;
			}
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDarlehensbetrag() {
		return darlehensbetrag;
	}

	public void setDarlehensbetrag(Double darlehensbetrag) {
		this.darlehensbetrag = darlehensbetrag;
	}

	public Double getImmobilienwert() {
		return immobilienwert;
	}

	public void setImmobilienwert(Double immobilienwert) {
		this.immobilienwert = immobilienwert;
	}

	public Double getMonatlicheRate() {
		return monatlicheRate;
	}

	public void setMonatlicheRate(Double monatlicheRate) {
		this.monatlicheRate = monatlicheRate;
	}

}
