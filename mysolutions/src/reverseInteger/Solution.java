package reverseInteger;



public class Solution {

	public static int reverse(int x){
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

	/**

	 * @param args

	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		System.out.println(reverse(123));

		System.out.println(reverse(-123));

		System.out.println(reverse(-1230));

		System.out.println(reverse(1534236469));

	}



}


