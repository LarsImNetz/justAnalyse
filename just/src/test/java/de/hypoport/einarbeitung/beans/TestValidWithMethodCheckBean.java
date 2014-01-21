package de.hypoport.einarbeitung.beans;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestValidWithMethodCheckBean {

	private ValidWithMethodCheckBean bean;
	Validator validator;

	@Before
	public void before() {
		bean = new ValidWithMethodCheckBean();
		validator = new Validator();
	}
	@Test
	public void test() {
		List<ConstraintViolation> violations = validator.validate(bean);
		Assert.assertTrue("Es gibt keine Fehler wenn nichts gesetzt ist.", violations.size() == 0);
	}

	@Test
	public void testSetTelefon() {
		bean.setTelefon("12345");
		List<ConstraintViolation> violations = validator.validate(bean);
		Assert.assertFalse("Es sollte einen Fehler geben.", violations.size() == 0);
	}


}
