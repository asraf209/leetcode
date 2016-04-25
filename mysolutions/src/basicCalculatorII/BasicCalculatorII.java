package basicCalculatorII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {
	public static int calculate(String s) {
		if(s==null || s.trim().isEmpty())	return 0;
		List<String> rpn = convertToReversePolishNotation2(s.trim());
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
			if(c==' ' || c=='(' || c==')' || c=='+' || c=='-' || c=='*' || c=='/'){
				if(sbf.length()!=0){
					rpn.add(sbf.toString());
					sbf.setLength(0);
					
					// (-)ve has more precedence over (+)ve
					/*if(!operators.isEmpty() && (
													operators.peek().equals("-") || 
													operators.peek().equals("*") ||
													operators.peek().equals("/")
												)
					)
						rpn.add(operators.pop());*/
				}				
			}
			
			if(c==' ')	continue;			
			else if(c=='(')	operators.push(""+c);
			else if(c=='/'){
				if(!operators.isEmpty() && operators.peek().equals("/"))
					rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c=='*'){
				if(!operators.isEmpty() && operators.peek().equals("/"))
					rpn.add(operators.pop());
				operators.push(""+c);
			}			
			else if(c=='-'){
				if(!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("-")))
					rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c=='+'){
				if(!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("-")))
					rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c==')'){
				String p = operators.pop();
				while(!p.equals("(")){
					rpn.add(p);
					p = operators.pop();
				}			
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
	
	
	private static List<String> convertToReversePolishNotation2(String s){
		Stack<String> operators = new Stack<>();
		List<String> rpn = new ArrayList<>();				
		StringBuffer sbf = new StringBuffer();
		
		Map<String, Integer> hierarchy = new HashMap<String, Integer>();
		hierarchy.put("+", 1);
		hierarchy.put("-", 1);
		hierarchy.put("*", 2);
		hierarchy.put("/", 2);
		hierarchy.put("(", 3);
		
		for(char c : s.toCharArray()){
			// Make each number
			if(c==' ' || c=='(' || c==')' || c=='+' || c=='-' || c=='*' || c=='/'){
				if(sbf.length()!=0){
					rpn.add(sbf.toString());
					sbf.setLength(0);					
				}				
			}
			
			if(c==' ')	continue;
			else if(c=='(')	operators.push(""+c);
			else if(c=='/' || c=='*' || c=='+' || c=='-'){				
				while(!operators.isEmpty() && 
						!operators.peek().equals("(") &&
						(hierarchy.get(operators.peek()) >= hierarchy.get(""+c)))
					rpn.add(operators.pop());						
				
				operators.push(""+c);				
			}
			else if(c==')'){
				System.out.println("Ashraf");
				while(!operators.isEmpty()){
					String p = operators.pop();
					if(p.equals("("))	break;
					rpn.add(p);
				}
				/*String p = operators.pop();
				while(!p.equals("(")){
					rpn.add(p);
					p = operators.pop();
				}*/
			}
			else
				sbf.append(c);
			
			
			
			/*switch(c){
				case '(':
					operators.push(""+c);
					break;
				case '/':
					if(!operators.isEmpty()){
						while(hierarchy.get(operators.peek()) >= hierarchy.get(""+c))
							rpn.add(operators.pop());						
					}
					operators.push(""+c);
					break;
				case '*':
					if(!operators.isEmpty()){
						while(hierarchy.get(operators.peek()) >= hierarchy.get(""+c))
							rpn.add(operators.pop());						
					}
					operators.push(""+c);
					break;
				case '-':
					if(!operators.isEmpty()){
						while(hierarchy.get(operators.peek()) >= hierarchy.get(""+c))
							rpn.add(operators.pop());						
					}
					operators.push(""+c);
					break;
				case '+':
					if(!operators.isEmpty()){
						while(hierarchy.get(operators.peek()) >= hierarchy.get(""+c))
							rpn.add(operators.pop());						
					}
					operators.push(""+c);
					break;
				case ')':
					String p = operators.pop();
					while(!p.equals("(")){
						rpn.add(p);
						p = operators.pop();
					}
					break;
				default:					
					sbf.append(c);		
					break;
			}*/
			
			
			
			/*else if(c=='(')	operators.push(""+c);
			else if(c=='/'){
				if(!operators.isEmpty() && operators.peek().equals("/"))
					rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c=='*'){
				if(!operators.isEmpty() && operators.peek().equals("/"))
					rpn.add(operators.pop());
				operators.push(""+c);
			}			
			else if(c=='-'){
				if(!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("-")))
					rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c=='+'){
				if(!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("-")))
					rpn.add(operators.pop());
				operators.push(""+c);
			}
			else if(c==')'){
				String p = operators.pop();
				while(!p.equals("(")){
					rpn.add(p);
					p = operators.pop();
				}			
			}
			else{
				sbf.append(c);		
			}*/
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
		System.out.println("3+2*2");
		System.out.println(calculate("3+2*2"));
		System.out.println();
		
		System.out.println(" 3/2 ");
		System.out.println(calculate(" 3/2 "));
		System.out.println();
		
		System.out.println(" 3+5 / 2 ");
		System.out.println(calculate(" 3+5 / 2 "));
		System.out.println();
				
		System.out.println("12-3*4");
		System.out.println(calculate("12-3*4"));
		System.out.println();
		
		System.out.println("(3+4)*5");
		System.out.println(calculate("(3+4)*5"));
		System.out.println();
		
		System.out.println("100000000/1/2/3/4/5/6/7/8/9/10");
		System.out.println(calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
		System.out.println();
				
		System.out.println("123-8*5-57/3+148+1*3/2*14*11*2*5/4*3/3/3+2283");
		System.out.println(calculate("123-8*5-57/3+148+1*3/2*14*11*2*5/4*3/3/3+2283"));
		System.out.println();
		
		System.out.println("1-1-1");
		System.out.println(calculate("1-1-1"));
		System.out.println();
		
		System.out.println("1*2-3/4+5*6-7*8+9/10");
		System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
		System.out.println();
	}

}
