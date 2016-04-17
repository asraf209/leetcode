package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.awt.windows.ThemeReader;

public class Solution {
	
	public static ArrayList<ArrayList<Integer>> get3Sum(int[] a, int target){
		if(a==null || a.length<3)	return null;		
		
		List<List<Integer>> twoSum = new ArrayList<>();
		for(int i=0; i<a.length-1; i++){			
			for(int j=i+1; j<a.length; j++){
				List<Integer> pair = new ArrayList<>();
				if(a[i]<=a[j]){
					pair.add(a[i]);
					pair.add(a[j]);
				}
				else{
					pair.add(a[j]);
					pair.add(a[i]);
				}
				twoSum.add(pair);
			}
		}
		System.out.println(twoSum);
		
		Set<ArrayList<Integer>> threeSum = new HashSet<ArrayList<Integer>>();
		for(List<Integer> pair : twoSum){			
			for(int n : a){
				//System.out.println(pair);
				if(doSum(pair, n) == 0){					
					ArrayList<Integer> triplet = new ArrayList<Integer>();
					if(n<=pair.get(0)){
						triplet.add(n);
						triplet.add(pair.get(0));
						triplet.add(pair.get(1));
					}
					else if(n>=pair.get(1)){						
						triplet.add(pair.get(0));
						triplet.add(pair.get(1));
						triplet.add(n);
					}
					else{
						triplet.add(pair.get(0));
						triplet.add(n);
						triplet.add(pair.get(1));						
					}	
					if(!threeSum.contains(triplet))
						threeSum.add(triplet);
				}
			}
		}					
		
		return new ArrayList<ArrayList<Integer>>(threeSum);
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
		System.out.println(get3Sum(a, target));
		/*int[] trivialOut = findTargetTrivial(a, target);
		assert(trivialOut[0] == 0);
		assert(trivialOut[1] == 1);
		System.out.println(trivialOut[0] + ", " + trivialOut[1]);
		*/
	}

}
