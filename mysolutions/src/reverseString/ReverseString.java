package reverseString;

public class ReverseString {
	public static String reverseString(String s) {
		if(s==null || s.trim().isEmpty())	return s;
		char[] ch = s.toCharArray();
		for(int i=0, j=s.length()-1; i<j; i++, j--){
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
		}
        return new String(ch);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString(" "));
		System.out.println(reverseString("hello"));
	}

}
	