package reverseVowels;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
	public static String reverseVowels(String s) {
        if(s==null || s.trim().isEmpty())	return s;
        char[] ch = s.toCharArray();
        int start=0, end=s.length()-1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        while(true){
        	while(start<ch.length && !vowels.contains(ch[start]))
        		start++;
        	while(end>=0 && !vowels.contains(ch[start]))
        		end--;
        	
        	if(start<end){
	        	char tmp = ch[start];
	        	ch[start] = ch[end];
	        	ch[end] = tmp;
        	}
        	else	break;
        }
        
        return new String(ch);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
