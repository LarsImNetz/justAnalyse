package org.homenet.moonserver.kontoimporter.classification;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestAnjaClassification {

	AnjaClassification classificationSUT = new AnjaClassification();

	@Test
	public void testReflectionByName() throws Exception {

		for (final ClassificationEnum classEnum : ClassificationEnum.values()) {
			final String name = classEnum.name().toLowerCase();
			if (name.equals("unknown")) {
				break;
			}
			// search for method
			boolean found = false;
			final Method[] declaredMethods = classificationSUT.getClass().getDeclaredMethods();
			for (final Method method : declaredMethods) {

				final String methodname = method.getName();
				System.out.println("Method: " + methodname);
				if (methodname.contains(name)) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Keine Entsprechung für: " + name);
				Assert.fail("Keine Entsprechung für " + name);
			}
		}

	}

	@Ignore
	@Test
	public void testCallMethod() throws Exception {
		final Method method = classificationSUT.getClass().getMethod("herrentunnel", String.class);
		Assert.assertNotNull(method);

		method.setAccessible(true);
		method.invoke(classificationSUT, "Herrentunnel Luebeck");
		Assert.assertEquals(ClassificationEnum.HERRENTUNNEL, classificationSUT.getClassification());
	}
}
