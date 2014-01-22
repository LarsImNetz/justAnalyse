package de.vergleich.sample.bean;

import java.io.Serializable;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;
import net.sf.oval.constraint.ValidateWithMethod;

public class Bean implements Serializable {
	@NotNull
	@MatchPattern(pattern = "^[A-Z].*")
	@Length(max = 32)
	String name;

	@NotNull
	@Range(min = 50000, max = 1000000)
	Double darlehensbetrag;

	@NotNull
	@Range(min = 1, max = 1000000)
	Double immobilienwert;

	@NotNull
	@ValidateWithMethod(methodName = "isMonatlicheRateValid", parameterType = Double.class)
	Double monatlicheRate;

	@SuppressWarnings("unused")
	private boolean isMonatlicheRateValid(final Double rate) {
		if (rate == null) {
			return false;
		}
		if (rate < 0) {
			return false;
		}

		if (immobilienwert <= 0) {
			return false;
		}

		// Berechnen, welche Rate min. bezahlt werden sollte
		double monatsrate = immobilienwert / 12;

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
