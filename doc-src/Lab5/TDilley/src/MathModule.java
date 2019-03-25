
public class MathModule {

	public static void main(String[] args) {
		//System.out.println(myMultiply(2000000000,6));
		//Prints out a negative number when run
		//Due to not using a long int to represent large numbers
		
		try {
			int test = myMultiply(2000000000,6);
			System.out.println(test);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	public static int myMultiply(int firstNum, int secondNum) throws Exception {
		long newAnswer = (long)firstNum*secondNum;
		if (newAnswer > Integer.MAX_VALUE) {
			throw new Exception("Number too big");
		}
		if (newAnswer < Integer.MIN_VALUE) {
			throw new Exception("Number too small");
		}
		return firstNum*secondNum;
	}
	
	public static int myDivide(int firstNum, int secondNum) throws Exception {
		if (secondNum == 0) {
			throw new Exception("Can't divide by zero");
		}			
		return firstNum / secondNum;
	}

}