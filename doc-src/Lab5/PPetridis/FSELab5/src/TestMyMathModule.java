import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestMyMathModule {

	private static int input1;
	private static int input2;
	private static int input3;
	private static int input4;
	
	@BeforeAll
	static void setup() {
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
		input4 = -2000000000;
	}
	
	@Ignore
	void test() {
		fail("Not yet implemented");
	}

	/*
	 * Series of tests for multiply function
	 * */
	
	@Test
	void test1() {
		int myAnswer = 0;
		try {
			myAnswer = MathModule.myMultiply(input1, input2);
		}catch(Exception e) {}
		assertEquals(18, myAnswer);
	}
	
	@Test
	void testError() {
		assertThrows(Exception.class, () -> MathModule.myMultiply(input1, input3));
	}
	
	@Test
	void testErrorTooSmall() {
		assertThrows(Exception.class, () -> MathModule.myMultiply(input1, input4));
	}
	
	/*
	 * Series of tests for division function
	 * */
	
	@Test
	void divSimpleCase() {
		try {
			assertEquals(2, MathModule.MyDivision(input2, input1));
		}catch(Exception e) {
			fail("Exception thrown!");
		}
	}
	
	@Test
	void divTestTooLarge() {
		try {
			assertEquals(0, MathModule.MyDivision(input1, input3));
		}catch(Exception e) {
			fail("Exception thrown!");
		}
	}
	
	@Test
	void divTestTooSmall() {
		try {
			assertEquals(0, MathModule.MyDivision(input2, input4));
		}catch(Exception e) {
			fail("Exception thrown!");
		}
	}
	
	@Test
	void divByZero() {
		assertThrows(Exception.class, () -> MathModule.MyDivision(input1, 0));
	}
	
	@Test
	void divZeroByNum() {
		try {
			assertEquals(0, MathModule.MyDivision(0, input2));
		}catch(Exception e) {
			fail("Exception thrown!");
		}
	}
	
	@Test
	void divLargeNums() {
		try {
			assertEquals(-1, MathModule.MyDivision(input3, input4));
		}catch(Exception e) {
			fail("Exception thrown!");
		}
	}
	
}
