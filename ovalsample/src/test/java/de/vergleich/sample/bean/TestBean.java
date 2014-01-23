package de.vergleich.sample.bean;


import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBean {

	@Before
	public void before() {

	}

	@Test
	public void testName_Grossbuchstabe() {
		Bean bean = new Bean();
		bean.setName("egal");
		bean.setDarlehensbetrag(150000d);
		bean.setImmobilienwert(250000d);
		bean.setMonatlicheRate(600d);

		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(bean);
		// show(violations);
		Assert.assertTrue(violations.size() == 1);
		Assert.assertEquals(Bean.VIOLATION_GROSSBUCHSTABE, violations.get(0).getErrorCode());
	}

	@Test
	public void testName_ToLong() {
		Bean bean = new Bean();
		bean.setName("Supercallifragilistiexpialigetisch");
		bean.setDarlehensbetrag(150000d);
		bean.setImmobilienwert(250000d);
		bean.setMonatlicheRate(600d);

		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(bean);
		Assert.assertTrue(violations.size() == 1);
		Assert.assertEquals(Bean.VIOLATION_LENGTH, violations.get(0).getErrorCode());
	}

	@Test
	public void testName_NoName() {
		Bean bean = new Bean();
		// bean.setName("Supercallifragilistiexpialigetisch");
		bean.setDarlehensbetrag(150000d);
		bean.setImmobilienwert(250000d);
		bean.setMonatlicheRate(600d);

		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(bean);
		Assert.assertTrue(violations.size() == 1);
		Assert.assertEquals(Bean.VIOLATION_NOTNULL, violations.get(0).getErrorCode());
	}

	@Test
	public void testName_Darlehensbetrag_to_low() {
		Bean bean = new Bean();
		bean.setName("Super");
		bean.setDarlehensbetrag(1d);
		bean.setImmobilienwert(250000d);
		bean.setMonatlicheRate(600d);

		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(bean);

		Assert.assertEquals(2, violations.size());
		// TODO: in hamcrest?
		// assertThat(in(violation), oneFunctionCallOf(getErrorCode() returns Bean.VIOLATION_DARLEHENSBETRAG_TO_LOW));
		for (ConstraintViolation violation : violations) {
			if (violation.getErrorCode().equals(Bean.VIOLATION_DARLEHENSBETRAG_TO_LOW)) {
			}
			else if (violation.getErrorCode().equals(Bean.VIOLATION_MONATLICHE_RATE)) {
			}
			else {
				Assert.fail("Illegale Violation gefunden: " + violation.getErrorCode());
			}
		}
	}

	@Test
	public void testAll() {
		Bean bean = new Bean();

		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(bean);
		Assert.assertEquals(4, violations.size());

	}

	@Test
	public void test_MonatlicheRate_falsch() {
		Bean bean = new Bean();
		bean.setName("Super");
		bean.setDarlehensbetrag(150000d);
		bean.setImmobilienwert(250000d);
		bean.setMonatlicheRate(200d);

		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(bean);
		// show(violations);
		Assert.assertEquals(1, violations.size());
		Assert.assertEquals(Bean.VIOLATION_MONATLICHE_RATE, violations.get(0).getErrorCode());
	}

	private void show(List<ConstraintViolation> violations) {
		System.out.println("Show current violations");
		for(ConstraintViolation violation : violations) {
			StringBuffer out = new StringBuffer();
			final String errorCode = violation.getErrorCode();
			out.append(errorCode).append(" ");
			final String checkName = violation.getCheckName();
			out.append(checkName).append(" ");
			final String message = violation.getMessage();
			out.append(message).append(" ");
			System.out.println(out.toString());
		}
	}
}
