package palindromeNumber;



public class Solution {

	private static int reverse(int x){

		if(x==0)	return x;		

		int n = Math.abs(x);

		long out = 0;

		while(n/10!=0){			

			int modN = n % 10;

			out = 10*out + modN;

			n = n / 10;

		}

		if(x<0)	out = (10*out + n)*(-1);

		else	out = 10*out + n;

		

		if(out < Integer.MIN_VALUE || out > Integer.MAX_VALUE)	

			return 0;

		

		return (int)out;

	}


	public static boolean isPalindrome(int x) {
		if(x<0)	return false;
		int reverseX = reverse(x);

		if(x == reverseX)	return true;

		return false;

    	}


	/**

	 * @param args

	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		System.out.println(isPalindrome(123));

		System.out.println(isPalindrome(121));

		System.out.println(isPalindrome(-123));

		System.out.println(isPalindrome(-121));

	}



}


