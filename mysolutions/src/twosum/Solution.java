package twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * This is a good approach. The same kind of approach can be used to compute 3sum, 4sum
	 * This Solution needs the Array to be Sorted first
	 * @param a
	 * @param target
	 * @return
	 */
	public static int[] findTargetAnotherBetterOne(int[] a, int target){
		if(a==null || a.length<2)	return null;		
		
		Arrays.sort(a);
		int[] out = new int[2];
		int start = 0;
		int end = a.length-1;
		
		while(start < end){
			
			if(start>0 && a[start]==a[start-1]){
				start++;
				continue;
			}
			else if((end+1)<a.length && a[end]==a[end+1]){
				end--;
				continue;
			}
			
			int sum = a[start] + a[end];
			if(sum == target){
				out[0] = start;
				out[1] = end;
				return out;
			}
			else if(sum < target)	start++;
			else	end--;
		}
		return out;
	}
	
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
			int remaining = target - a[i];
			if(visited.containsKey(remaining)){				
				out[0] = visited.get(remaining);
				out[1] = i;
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
		int[] betterOut = findTargetBetterOne(a, target);
		assert(betterOut[0] == 0);
		assert(betterOut[1] == 1);
		System.out.println(betterOut[0] + ", " + betterOut[1]);
		
		// Another Better one
		int[] banotherBetterOut = findTargetAnotherBetterOne(a, target);
		assert(banotherBetterOut[0] == 0);
		assert(banotherBetterOut[1] == 1);
		System.out.println(banotherBetterOut[0] + ", " + banotherBetterOut[1]);
	}

}
