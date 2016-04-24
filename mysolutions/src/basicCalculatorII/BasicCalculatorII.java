package basicCalculatorII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {
	public static int calculate(String s) {
		if(s==null || s.trim().isEmpty())	return 0;
		List<String> rpn = convertToReversePolishNotation(s.trim());
        return evaluate(rpn);
    }
	
	private static int evaluate(List<String> tokens){		
		if(tokens == null || tokens.size()==0)	return 0;
		
		int a, b;
		Stack<Integer> stack = new Stack<Integer>();		
		for(String ch : tokens){
			switch(ch){
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
					stack.push(Integer.parseInt(ch));
					break;
			}					
		}
		return stack.pop();		
	}
	
	private static List<String> convertToReversePolishNotation(String s){
		Stack<String> operators = new Stack<>();
		List<String> rpn = new ArrayList<>();				
		StringBuffer sbf = new StringBuffer();
		
		for(char c : s.toCharArray()){
			if(c==' ' || c=='(' || c==')' || c=='+' || c=='-' || c=='*' || c=='\\'){
				if(sbf.length()!=0){
					rpn.add(sbf.toString());
					sbf.setLength(0);
					
					// (-)ve has more precedence over (+)ve
					if(!operators.isEmpty() && (
													operators.peek().equals("-") || 
													operators.peek().equals("*") ||
													operators.peek().equals("/")
												)
					)
						rpn.add(operators.pop());
				}				
			}
			
			if(c==' ')	continue;							
			else if(c=='(' || c=='+' || c=='-'){
				// (-)ve has more precedence over (+)ve
				//if(!operators.isEmpty() && operators.peek().equals("-"))
					//rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c==')'){
				String p = operators.pop();
				while(!p.equals("(")){
					rpn.add(p);
					p = operators.pop();
				}
				// (-)ve has more precedence over (+)ve
				if(!operators.isEmpty() && (
										operators.peek().equals("-") || 
										operators.peek().equals("*") ||
										operators.peek().equals("/")
									)
				)
				rpn.add(operators.pop());
			}
			else{
				sbf.append(c);		
			}
		}
		if(sbf.length()!=0){
			rpn.add(sbf.toString());			
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
		System.out.println(" 2-1 + 2 ");
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println();
		System.out.println("(1+(4+5+2)-3)+(6+8)");
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println();
		
		System.out.println(calculate("1234"));
		System.out.println();
		System.out.println("(7)-(0)+(4)");
		System.out.println(calculate("(7)-(0)+(4)"));
		
	}

}
