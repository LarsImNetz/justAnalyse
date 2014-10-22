package de.hypoport.einarbeitung.compound;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class TestCompoundKey {

	@Test
	public void testListWithCompoundKey_Different_Laufzeit() {
		List<CompoundKey> list = new ArrayList<CompoundKey>();
		CompoundKey e = new CompoundKey(LaufzeitEnum.FUENF_JAHRE, TilgungEnum.EIN_PROZENT);
		list.add(e);
		CompoundKey e2 = new CompoundKey(LaufzeitEnum.ACHT_JAHRE, TilgungEnum.EIN_PROZENT);
		list.add(e2);

		Assert.assertTrue(list.size() == 2);

		Assert.assertTrue(list.contains(e));
		Assert.assertTrue(list.contains(e2));
	}

	@Test
	public void testSetWithCompoundKey_Different_Laufzeit() {
		Set<CompoundKey> set = new HashSet<CompoundKey>();
		CompoundKey e = new CompoundKey(LaufzeitEnum.FUENF_JAHRE, TilgungEnum.EIN_PROZENT);
		set.add(e);
		CompoundKey e2 = new CompoundKey(LaufzeitEnum.ACHT_JAHRE, TilgungEnum.EIN_PROZENT);
		set.add(e2);

		Assert.assertTrue(set.size() == 2);
		Assert.assertTrue(set.contains(e));
		Assert.assertTrue(set.contains(e2));
	}

	@Test
	public void testSetWithCompoundKey_Equal_Tilgung() {
		Set<CompoundKey> set = new HashSet<CompoundKey>();
		CompoundKey e = new CompoundKey(LaufzeitEnum.FUENF_JAHRE, TilgungEnum.EIN_PROZENT);
		set.add(e);
		CompoundKey e2 = new CompoundKey(LaufzeitEnum.FUENF_JAHRE, TilgungEnum.EIN_PROZENT);
		set.add(e2);

		Assert.assertTrue(set.size() == 1);
	}

	@Test
	public void testSetWithCompoundKey_Different_Tilgung() {
		Set<CompoundKey> set = new HashSet<CompoundKey>();
		CompoundKey e = new CompoundKey(LaufzeitEnum.FUENF_JAHRE, TilgungEnum.EIN_PROZENT);
		set.add(e);
		CompoundKey e2 = new CompoundKey(LaufzeitEnum.FUENF_JAHRE, TilgungEnum.ZWEI_PROZENT);
		set.add(e2);

		Assert.assertTrue(set.size() == 2);

		Assert.assertTrue(set.contains(e));
		Assert.assertTrue(set.contains(e2));
	}
}
