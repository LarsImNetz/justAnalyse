package de.hypoport.einarbeitung.beans;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.guard.Guard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJustBean {

	private JustBean bean;
	Validator validator;

	@Before
	public void before() {
		bean = new JustBean();
		validator = new Validator();
		//? Guard guard = MyGuardAspect.aspectOf().getGuard();
	}

	@Test
	public void testNotNull() {
		Assert.assertNotNull(bean);
	}

	@Test
    public void testAssertFieldConstraintsWithSetName() throws Exception {
		bean.setName("supercallifragilistiexpialigetischerNameDerLangSeinSoll");
		// Assert.assertTrue(bean.getName().length()<=32);
		List<ConstraintViolation> violations = validator.validate(bean);
		Assert.assertTrue(violations.size() > 0);
	}

	@Test(expected=IllegalStateException.class)
	public void testName() throws Exception {
		bean.setName("Langhans");
		bean.setTelefonnummer("451 625592");

		List<ConstraintViolation> violations = validator.validate(bean);
		if (violations.size() > 0) {
			// Assert.fail("Object " + bean + " is invalid. " + violations.toString());
			throw new IllegalStateException("Object " + bean + " is invalid. " + violations.toString());
		}
	}

	@Test
    public void testTelefonnummer() throws Exception {
		bean.setName("Langhans");
		bean.setLand("DE");
		// bean.setTelefonnummer("451 625592");
		bean.getTelefonnummer();

//		List<ConstraintViolation> violations = validator.validate(bean);
//		if (violations.size() > 0) {
//			// Assert.fail("Object " + bean + " is invalid. " + violations.toString());
//			throw new IllegalStateException("Object " + bean + " is invalid. " + violations.toString());
//		}

    }
}
