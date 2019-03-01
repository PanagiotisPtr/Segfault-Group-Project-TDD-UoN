package test3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class testmymathmodule {
	static int input1;
	static int input2;
	static int input3;

	@Ignore
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void test1() {
		int myanswer = 0;
		try {
		myanswer = mathmodule.myMultiply(input1,input2);
		} catch(Exception e){
		}
		assertEquals(18, myanswer);
	}
	
	@BeforeAll
	static void setup(){
	input1 = 3;
	input2 = 6;
	input3=2000000000;
	}
	
	
	
	void testError() {
		int myanswer = 0;
		try {
		myanswer = mathmodule.myMultiply(input2,input3);
		} catch (Exception e) {
		if (e.getClass()==Exception.class) {
		return; //it passed
		}
		}
		fail("it failed");
	}

}


