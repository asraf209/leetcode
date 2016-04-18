package reverseInteger;



public class Solution {

	public static int reverse(int x){

		if(x==0)	return x;		

		int n = Math.abs(x);

		int out = 0;

		while(n/10!=0){			

			int modN = n % 10;

			out = 10*out + modN;

			n = n / 10;

		}

		if(x<0)	return (10*out + n)*(-1);

		return 10*out + n;

	}

	/**

	 * @param args

	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub



	}



}


