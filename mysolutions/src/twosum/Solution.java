package twosum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * Trivial solution. O(n^2)
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
		// TODO Auto-generated method stub
		int[] a = {2, 7, 11, 15}; 
		int target = 9;
		int[] out = findTargetTrivial(a, target);
		assert(out[0] == 0);
		assert(out[1] == 1);
		System.out.println(out[0] + ", " + out[1]);
	}

}
