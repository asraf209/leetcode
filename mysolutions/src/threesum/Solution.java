package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static List<List<Integer>> get3Sum(int[] a, int target){
		if(a==null || a.length<3)	return null;
		
		Arrays.sort(a);
		
		List<List<Integer>> twoSum = new ArrayList<>();
		for(int i=0; i<a.length-1; i++){
			List<Integer> sum = new ArrayList<>();
			for(int j=i+1; j<a.length; j++){
				sum.add(a[i]);
				sum.add(a[j]);
				twoSum.add(sum);
			}
		}
		
		List<List<Integer>> triplet = new ArrayList<>();
		for(int n : a){
			for(List<Integer> pair : twoSum){
				if(doSum(pair, n)==0){
					pair.add(n);
					triplet.add(pair);
				}
			}
		}
		
		return triplet;
	}
	
	private static int doSum(List<Integer> pair, int n){
		int sum = n;
		for(int m : pair)	sum += m;
		return sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {-1, 0, 1, 2, -1, -4}; 
		int target = 0;
		
		/*int[] trivialOut = findTargetTrivial(a, target);
		assert(trivialOut[0] == 0);
		assert(trivialOut[1] == 1);
		System.out.println(trivialOut[0] + ", " + trivialOut[1]);
		*/
	}

}
