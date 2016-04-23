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
		if(tokens == null || tokens.size()==0)	return 0;
		
		int a, b;
		Stack<Integer> stack = new Stack<Integer>();		
		for(char ch : tokens){
			switch(ch){
				case '/':
					b = stack.pop();
					a = stack.pop();
					stack.push(a/b);
					break;
				case '*':
					b = stack.pop();
					a = stack.pop();
					stack.push(a*b);
					break;
				case '+':
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
					break;
				case '-':
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
					break;
				default:
					stack.push(ch - '0');
					break;
			}					
		}
		return stack.pop();		
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
		System.out.println(calculate("1 + 1"));
		System.out.println();
		System.out.println(calculate("1+1"));
		System.out.println();
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println();
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

}
