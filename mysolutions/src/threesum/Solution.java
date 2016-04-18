package threesum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	
	/**
	 * O(n^2). Time limit exceeded
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> get3Sum(int[] nums, int target){
		if(nums==null || nums.length<3)	return new ArrayList<>();		
		
		List<List<Integer>> twoSum = new ArrayList<>();
		for(int i=0; i<nums.length-1; i++){			
			for(int j=i+1; j<nums.length; j++){
				List<Integer> pair = new ArrayList<>();
				if(nums[i]<=nums[j]){
					pair.add(nums[i]);
					pair.add(nums[j]);
				}
				else{
					pair.add(nums[j]);
					pair.add(nums[i]);
				}
				twoSum.add(pair);
			}
		}
		
		Set<List<Integer>> threeSum = new HashSet<List<Integer>>();
		for(List<Integer> pair : twoSum){			
			for(int n : nums){				
				if(doSum(pair, n) == 0){					
					List<Integer> triplet = new ArrayList<Integer>();
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
		
		List<List<Integer>> out = new ArrayList<>(threeSum);		
		return out;//new List<List<Integer>>(threeSum);
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
		//int[] a = {-1, 0, 1, 2, -1, -4};
		int[] a = {13,4,-6,-7,-15,-1,0,-1,0,-12,-12,9,3,-14,-2,-5,-6,7,8,2,-4,6,-5,-10,-4,-9,-14,-14,12,-13,-7,3,7,2,11,7,9,-4,13,-6,-1,-14,-12,9,9,-6,-11,10,-14,13,-2,-11,-4,8,-6,0,7,-12,1,4,12,9,14,-4,-3,11,10,-9,-8,8,0,-1,1,3,-15,-12,4,12,13,6,10,-4,10,13,12,12,-2,4,7,7,-15,-4,1,-15,8,5,3,3,11,2,-11,-12,-14,5,-1,9,0,-12,6,-1,1,1,2,-3};
		int target = 0;
		long startTime = System.currentTimeMillis();
		List<List<Integer>> threeSum = get3Sum(a, target);
		long endTime = System.currentTimeMillis();
		//assert(threeSum.size() == 3);
		System.out.println(endTime - startTime);
		System.out.println(threeSum);			
	}

}
