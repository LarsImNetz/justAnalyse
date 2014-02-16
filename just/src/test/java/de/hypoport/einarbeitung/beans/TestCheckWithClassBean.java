package de.hypoport.einarbeitung.beans;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCheckWithClassBean {

	private CheckWithClassBean bean;
	Validator validator;

	@Before
	public void before() {
		bean = new CheckWithClassBean();
		validator = new Validator();
		//? Guard guard = MyGuardAspect.aspectOf().getGuard();
	}

	// @Ignore("Vermutlich validator falsch gesetzt.")
//	@Test
//	public void testAllEmpty(){
//		bean.setTingeltangel(1);
//
//		List<ConstraintViolation> validate = validator.validate(bean);
//		System.out.println(validate.toString());
//		// TODO: es wird kein Validate ausgeführt.
//		Assert.assertTrue(validate.size() > 0);
//	}

	@Test
	public void testTelephoneNumber_Wrong_Pattern() {
		bean.setTelefon("");

		List<ConstraintViolation> validate = validator.validate(bean);
		Assert.assertTrue(validate.size() > 0);
		for(ConstraintViolation violation : validate) {
			System.out.println(violation.getErrorCode());
		}
	}

	@Test
	public void testTelephoneNumber_Right_Pattern() {
		bean.setTelefon("012 123");

		List<ConstraintViolation> validate = validator.validate(bean);
		Assert.assertTrue("Alles erlaubte Zeichen", validate.size() == 0);
	}

}
