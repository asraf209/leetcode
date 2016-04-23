package basicCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		if(s==null || s.trim().isEmpty())	return 0;
		List<Character> rpn = convertToReversePolishNotation(s.trim());
        return evaluate(rpn);
    }
	
	private static int evaluate(List<Character> tokens){		
		return 0;		
	}
	
	private static List<Character> convertToReversePolishNotation(String s){
		Stack<Character> operators = new Stack<>();
		List<Character> rpn = new ArrayList<>();
		for(char c : s.toCharArray()){
			if(c==' ')	continue;
			else if(c=='(' || c=='+' || c=='-')	operators.push(c);
			else if(c==')'){
				char p = operators.pop();
				while(p!='('){
					rpn.add(p);
					p = operators.pop();
				}
			}
			else rpn.add(c);
		}
		if(!operators.isEmpty()){
			while(!operators.isEmpty())
				rpn.add(operators.pop());
		}
		System.out.println(rpn);
		return rpn;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate("1 + 1");
		System.out.println();
		calculate("1+1");
		System.out.println();
		calculate(" 2-1 + 2 ");
		System.out.println();
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

}
