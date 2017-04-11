package experiment.lars.java.generics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestGenericWithInterface {

	@Test
	public void testA() {

		A a = new A();
		Assert.assertEquals(1, a.getA());
	}

	@Test
	public void testB() {

		B b = new B();
		Assert.assertEquals(2, b.getA());
	}

	@Test
	public void testListOfIA() {
		List<IA> ia = new ArrayList<>();
		ia.add(new A());
		ia.add(new B());
		ia.add(new C());

		Assert.assertEquals(3, ia.size());
		Assert.assertTrue(ia.get(0) instanceof A);
		Assert.assertEquals(1, ia.get(0).getA()); // train wreck aber ohne cast
		
		Assert.assertTrue(ia.get(1) instanceof B);
		Assert.assertEquals(2, ia.get(1).getA());
		
		Assert.assertTrue(ia.get(2) instanceof C);
		Assert.assertEquals(3, ia.get(2).getA());
	}

	@Test
	public void testListOfAandB_marker() {
		List<AandB_marker> ia = new ArrayList<>();
		ia.add(new A());
		ia.add(new B());
//		ia.add(new C()); geht nicht, da C nicht das marker Interface implementiert

		Assert.assertEquals(2, ia.size());
		Assert.assertTrue(ia.get(0) instanceof A);
		Assert.assertEquals(1, ((A)ia.get(0)).getA()); // häßlich!
		
		Assert.assertTrue(ia.get(1) instanceof B);
		Assert.assertEquals(2, ((B)ia.get(1)).getA()); // häßlich!
	}

	@Test(expected=ClassCastException.class)
	public void testWrongCast() {
		List<AandB_marker> ia = new ArrayList<>();
		ia.add(new A());
		Assert.assertEquals(1, ((C)ia.get(0)).getA()); // Fehlermeldung erst zur Laufzeit!
		
	}
	
	private interface AandB_marker {
	}

	private interface IA {
		int getA();
	}

	private static class A implements IA, AandB_marker {
		@Override
		public int getA() {
			return 1;
		}
	}

	private static class B implements IA, AandB_marker {
		@Override
		public int getA() {
			return 2;
		}
	}

	private static class C implements IA {
		@Override
		public int getA() {
			return 3;
		}
	}

}
