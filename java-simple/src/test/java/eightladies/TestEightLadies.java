package eightladies;

import org.junit.Ignore;
import org.junit.Test;

public class TestEightLadies {

	@Test
	public void testCheckLady() throws Exception {
		final EightLadies ladiesProblem = new EightLadies();
		ladiesProblem.checkLady(7, 0);
		ladiesProblem.checkLady(0, 0);
		ladiesProblem.checkLady(0, 2);
		ladiesProblem.checkLady(2, 0);
		ladiesProblem.checkLady(2, 5);
		ladiesProblem.checkLady(5, 7);
		ladiesProblem.checkLady(7, 5);
		ladiesProblem.checkLady(7, 7);
	}

	@Ignore
	@Test
	public void testShowField() throws Exception {
		final EightLadies ladiesProblem = new EightLadies();
		ladiesProblem.showField();
	}
	
	@Test
	public void testFindSolution() throws Exception {
		final EightLadies ladiesProblem = new EightLadies();
		ladiesProblem.findSolution();
	}
}
