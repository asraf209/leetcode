package twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * Trivial solution. Time: O(n^2)
	 * @param a
	 * @param target
	 * @return
	 */
	public static int[] findTargetTrivial(int[] a, int target){
		if(a==null || a.length==0)	return null;
		
		int[] out = new int[2];
		for(int i=0; i<a.length-1; i++){			
			for(int j=i+1; j<a.length; j++){
				if((a[i]+a[j]) == target){
					out[0] = i;
					out[1] = j;
					return out;
				}
			}
		}		
		return null;
	}
	
	/**
	 * Time: O(n); Space: O(n)
	 * @param a
	 * @param target
	 * @return
	 */
	public static int[] findTargetBetterOne(int[] a, int target){
		if(a==null || a.length==0)	return null;
		
		int[] out = new int[2];
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
		
		for(int i=0; i<a.length; i++){
			int remaining = Math.abs(a[i] - target);
			if(visited.containsKey(remaining)){
				out[0] = i;
				out[1] = visited.get(remaining);
				return out;
			}
			else
				visited.put(a[i], i);			
		}		
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		int[] a = {2, 7, 11, 15}; 
		int target = 9;
		
		// Trivial one
		int[] trivialOut = findTargetTrivial(a, target);
		assert(trivialOut[0] == 0);
		assert(trivialOut[1] == 1);
		System.out.println(trivialOut[0] + ", " + trivialOut[1]);
		
		// Better one
		int[] betterOut = findTargetTrivial(a, target);
		assert(betterOut[0] == 0);
		assert(betterOut[1] == 1);
		System.out.println(betterOut[0] + ", " + betterOut[1]);
	}

}
