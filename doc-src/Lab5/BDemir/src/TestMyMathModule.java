import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test
	void test1() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input1,input2);
		}
		catch(Exception e) {
		}
		assertEquals(18,myanswer);

	}
	
	
	void testError() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input2, input3);
		} catch(Exception e) {
			if (e.getClass()==Exception.class) {
				return; //passed
			}
		}
		fail("it failed");
	}
	
	void testError2() {
		try {
			MathModule.myMultiply(input2, input4);
		} catch(Exception e) {
			if (e.getClass()==Exception.class) {
				return; //passed
			}
		}
		fail("it failed");
	}
}
