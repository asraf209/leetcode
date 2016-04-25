package validParentheses;

import java.util.Stack;

public class Solution {
	public static boolean isValid(String s) {
        if(s==null || s.isEmpty())	return false;
		Stack<Character> chStack = new Stack<Character>();
		for(char ch : s.toCharArray()){
			if(ch=='(' || ch=='{' || ch=='[')
				chStack.push(ch);
			else if(ch==')' || ch=='}' || ch==']'){
				if(chStack.isEmpty())	return false;
				char pop = chStack.pop();
				if(Math.abs(ch-pop) > 2)	return false;
			}
		}
		return chStack.isEmpty();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));
		System.out.println(isValid("()}"));
	}

}
