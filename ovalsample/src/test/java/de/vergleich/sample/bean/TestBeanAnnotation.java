package de.vergleich.sample.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import de.vergleich.sample.validator.OValValidator;


@SuppressWarnings("unused")
public class TestBeanAnnotation {

	@Test
	public void testAnnotation() {
		Bean bean = new Bean();
		bean.setName("Super");
		bean.setDarlehensbetrag(150000d);
		bean.setImmobilienwert(250000d);
		bean.setMonatlicheRate(600d);

		// List<Entry<Field,Bean>> annotatedFields = getAnnotatedFields(bean, Bean.class);
		OValValidator oValValidator = new OValValidator(bean, "name");

	}

	private <C extends Annotation> List<Entry<Field, C>> getAnnotatedFields(Object annotatedObject, Class<C> annotatedClass) {
		final Field[] declaredFields = annotatedObject.getClass().getDeclaredFields();
		final List<Entry<Field, C>> annotatedFields = new ArrayList<Entry<Field, C>>(declaredFields.length);

		for (final Field field : declaredFields) {
			final C annotation = field.getAnnotation(annotatedClass);

			if (annotation != null) {
				annotatedFields.add(new SimpleEntry<Field, C>(field, annotation));
			}
		}

		return annotatedFields;
	}



}
