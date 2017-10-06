package org.linuxx.moonserver.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@MyClassAnnotation("schnubbel")
public class TestAnnotation {

	@Test
	public void test() {
		System.out.println(this.getClass().getName());
		String schnubbel = ClassInfo.getClassAnnotationValue(this);
		Assert.assertEquals("schnubbel", schnubbel);

		System.out.println(getCurrentMethodName());
	}

	@Ignore
	@Test
	@MyMethodAnnotation("wurst")
	public void weitererTest() {
		String thisMethodNameIS = ClassInfo.getCurrentMethodName(new Object() {
		});
		System.out.println("my name is: " + thisMethodNameIS);
	}

	public String getCurrentMethodName() {
		StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
		return stackTraceElements[1].toString();
	}

	private static class ClassInfo {
		public static String getCurrentMethodName(Object object) {
			String value = getMethodAnnotationValue(object);
			String methodName = object.getClass().getEnclosingMethod().getName();
			return methodName + " annotated by MyMethodAnnotation value: " + value;
		}

		public static String getClassAnnotationValue(Object thisClass) {
			return getAnnotationValue(thisClass.getClass().getAnnotations());
		}

		public static String getMethodAnnotationValue(Object object) {
			return getAnnotationValue(object.getClass().getEnclosingMethod().getAnnotations());
		}

		private static String getAnnotationValue(Annotation[] annotations) {
			Stream<Annotation> stream = Arrays.stream(annotations);
			return stream.filter(x -> filterValue(x)).map(x -> getValue(x.toString())).reduce("", String::concat);
		}

		private static boolean filterValue(Annotation x) {
			return x.toString().contains("value=");
		}

		private static String getValue(String annotation) {
			Pattern valuePattern = Pattern.compile(".*value=(.*)?\\).*");
			final Matcher matcher = valuePattern.matcher(annotation);
			if (matcher.matches()) {
				final String match1 = matcher.group(1);
				return match1;
			}
			return "";
		}
	}
}
