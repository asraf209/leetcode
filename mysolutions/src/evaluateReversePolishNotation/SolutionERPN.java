package evaluateReversePolishNotation;

import java.util.Stack;

public class SolutionERPN {
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length==0)	return 0;
		int a, b;
		Stack<Integer> stack = new Stack<Integer>();		
		for(String s : tokens){
			switch(s){
				case "/":
					b = stack.pop();
					a = stack.pop();
					stack.push(a/b);
					break;
				case "*":
					b = stack.pop();
					a = stack.pop();
					stack.push(a*b);
					break;
				case "+":
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
					break;
				case "-":
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
					break;
				default:
					stack.push(Integer.parseInt(s));
					break;
			}					
		}
		return stack.pop();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
