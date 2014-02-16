package de.vergleich.sample.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import net.sf.oval.configuration.annotation.AnnotationCheck;
import net.sf.oval.configuration.annotation.Constraint;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;

public class OValValidator implements IValidator<String> {

	private final String fieldName;
	private final Object bean;

	public OValValidator(Object bean, String fieldName) {
		this.fieldName = fieldName;
		this.bean = bean;
	}

	@Override
	public void validate(IValidatable<String> validatable) {

		String value = validatable.getValue();
		// Field[] declaredFields = bean.getClass().getDeclaredFields();
		// for (Field field : declaredFields) {

		Field field;
		try {
			field = bean.getClass().getDeclaredField(fieldName);
			Annotation[] annotations = field.getAnnotations();

			for (Annotation annotation : annotations) {
				final Constraint annotation2 = annotation.annotationType().getAnnotation(Constraint.class);
				final Class<? extends AnnotationCheck<? extends Annotation>> checkWith = annotation2.checkWith();

				try {
					@SuppressWarnings("unchecked")
					final AnnotationCheck<Annotation> newInstance = (AnnotationCheck<Annotation>) checkWith.newInstance();
					newInstance.configure(annotation);
					final boolean satisfied = newInstance.isSatisfied(bean, value, null, null);

					System.out.println(annotation);
					System.out.println("PropertyKey: immobilienwert." + annotation.annotationType().getSimpleName());
					System.out.println("Satisfied: " + satisfied);
				} catch (Exception e) {
				}

				// if (annotation.annotationType().equals(Length.class)) {
				// Length length = (Length)annotation;
				// int max = length.max();
				// final String value = validatable.getValue();
				// if (value.length() > max) {
				// ValidationError valError = new
				// ValidationError("Bitte nicht mehr als " + max +
				// " Zeichen").addKey(length.errorCode());
				// validatable.error(valError);
				// }
				// }
				// if (annotation.annotationType().equals(MatchPattern.class)) {
				// MatchPattern matchPattern = (MatchPattern)annotation;
				// String[] pattern = matchPattern.pattern();
				// final String value = validatable.getValue();
				// Pattern p = Pattern.compile(pattern[0]);
				// Matcher m = p.matcher(value);
				// if (! m.matches()) {
				// ValidationError valError = new
				// ValidationError("Pattern passt nicht").addKey(matchPattern.errorCode());
				// validatable.error(valError);
				// }
				// }

			}
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	}

	// @Override
	// public void validate(IValidatable<String> validatable) {
	// checkMaxLength(validatable);
	// final String value = validatable.getValue();
	// // wird durch setRequired(true) schon geprüft
	// // if(value == null) {
	// // validatable.error(new
	// // ValidationError("Sollte nicht null sein").addKey("NullString"));
	// // }
	// // if(value.isEmpty()) {
	// // validatable.error(new
	// // ValidationError("Sollte nicht leer sein").addKey("LeerString"));
	// // }
	//
	// boolean match = Pattern.compile("^[A-Z]").matcher(value).find();
	// if (!match) {
	// validatable.error(new
	// ValidationError("Sollte mit Großbuchstaben beginnen...").addKey("GREAT_CHAR"));
	// }
	// }

}
