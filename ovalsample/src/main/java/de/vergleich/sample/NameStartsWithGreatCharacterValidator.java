package de.vergleich.sample;

import java.util.regex.Pattern;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class NameStartsWithGreatCharacterValidator implements IValidator<String> {

	@Override
	public void validate(IValidatable<String> validatable) {
		final String value = validatable.getValue();

		// wird durch setRequired(true) schon geprüft
		// if(value == null) {
		// validatable.error(new
		// ValidationError("Sollte nicht null sein").addKey("NullString"));
		// }
		// if(value.isEmpty()) {
		// validatable.error(new
		// ValidationError("Sollte nicht leer sein").addKey("LeerString"));
		// }

		boolean match = Pattern.compile("^[A-Z]").matcher(value).find();
		if (!match) {
			validatable.error(new ValidationError("Sollte mit Großbuchstaben beginnen...").addKey("GREAT_CHAR"));
		}
	}

}
