
public class MathModule {
	public static int myMultiply(int firstNum, int secondNum) throws Exception {
		long newAnswer= (long)firstNum*secondNum;
		if(newAnswer > Integer.MAX_VALUE || newAnswer < Integer.MAX_VALUE){
			throw new Exception("Number too big");
		}
		return firstNum*secondNum;
	}
	
	public static int myDivide(int firstNum, int secondNum) throws Exception {
		long newAnswer= (long)firstNum/secondNum;
		if(newAnswer > Integer.MAX_VALUE || newAnswer < Integer.MAX_VALUE){
			throw new Exception("Number too big");
		}
		return firstNum/secondNum;
	}
}
