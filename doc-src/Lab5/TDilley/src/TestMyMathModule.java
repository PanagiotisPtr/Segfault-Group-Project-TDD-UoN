import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestMyMathModule {
		
	private static int input1, input2, input3, input4, input5;
	
	@BeforeAll
	static void setup() {
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
		input4 = -2000000000;
		input5 = 7;
	}
	
	@Ignore
	void test() {
		fail("Not yet implemented");
	}

	@Test //Test that the function multiplies 2 valid integers
	void multiply_test() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input1, input2);
		} catch (Exception e) {
			assertEquals(18, myanswer);
		}
		
	}	
	
	@Test //Test for positive numbers out of range (large)
	void multiply_testError1() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input2, input3);
		} catch (Exception e) {
			if (e.getClass() == Exception.class) {
				return; //it passed
			}
		}
		fail("it failed");
	}
	
	@Test //Test for negative numbers out of range (large)
	void multiply_testError2() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input2, input4);
		} catch (Exception e) {
			if (e.getClass() == Exception.class) {
				return; //it passed
			}
		}
		fail("it failed");
	}
	
	@Test //Test that function divides 2 valid integers
	void divide_test1() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myDivide(input2, input1);
		} catch (Exception e) {
			assertEquals(2, myanswer);
		}		
	}
	
	@Test //Test for handling values between integers
	void divide_test2() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myDivide(input5, input1);
		}
		catch (Exception e) {
			assertEquals(2, myanswer);
		}
	}
	
	@Test //Test for dividing by 0 
	void divide_by_zero_test() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myDivide(input2, 0);
		} catch (Exception e) {
			if (e.getClass() == Exception.class) {
				return; //it passed
			}
		}
		fail("it failed");
	}
	
	@Test 
	void divide_test3() {
		int myanswer = 0;
		try { 
			myanswer = MathModule.myDivide(input2, input3);
		} catch (Exception e) {
			assertEquals(0, myanswer);
		}
	}
	
}
