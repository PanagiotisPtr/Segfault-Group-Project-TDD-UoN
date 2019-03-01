
public class MathModule {

	public static void main(String[] args) {
		/*try {
			System.out.println(myMultiply(2000000000,6));
		}catch(Exception e){
			System.out.println(e.toString());
		}*/
	}

	public static int myMultiply(int firstNum, int secondNum) throws Exception {
		long newAnswer = (long)firstNum * secondNum;
		if(newAnswer > Integer.MAX_VALUE) {
			throw new Exception("Number too big");
		}
		if(newAnswer < Integer.MIN_VALUE) {
			throw new Exception("Number too big");
		}
		return firstNum*secondNum;
	}
	
	// Parameters need to be long to check value for newAnswer. 20000000/20000000 is still 1 so it's fine.
	public static int MyDivision(long firstNum, long secondNum) throws Exception {
		if(secondNum == 0) {
			throw new Exception("Division by zero");
		}
		long newAnswer = firstNum / secondNum;
		if(newAnswer > Integer.MAX_VALUE) {
			throw new Exception("Number too big");
		}
		if(newAnswer < Integer.MIN_VALUE) {
			throw new Exception("Number too big");
		}
		return (int)newAnswer;
	}
	
}
