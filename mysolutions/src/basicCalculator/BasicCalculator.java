package basicCalculator;

import java.util.List;

public class BasicCalculator {
	public static int calculate(String s) {
		if(s==null || s.trim().isEmpty())	return 0;
		List<String> rpn = convertToReversePolishNotation(s);
        return evaluate(rpn);
    }
	
	private static int evaluate(List<String> rpn){		
		return 0;
	}
	
	private static List<String> convertToReversePolishNotation(String s){
		
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
