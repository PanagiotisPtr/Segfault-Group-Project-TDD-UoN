import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class MathModuleTest {
	
	private static int input1;
	private static int input2;
	private static int input3;
	
	@BeforeAll
	static void setup() {
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
	}
	
	@Test
	void test1() throws Exception {
		assertEquals(MathModule.myMultiply(input1, input2),18);
	}
	
	@Test
	void testOverflow() {
		assertThrows(Exception.class,() -> MathModule.myMultiply(input2, input3));
	}
	
	@Test
	void testUnderflow() {
		assertThrows(Exception.class,() -> MathModule.myMultiply(input2, -input3));
	}
}
