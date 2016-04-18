package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	/**
	 * Time: O(n^2). This is the good one. 
	 * Do not need to use extra spaces. Also faster than the previous one.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> get3Sum2ndApproach(int[] nums, int target){
		if(nums==null || nums.length<3)	return new ArrayList<>();
		
		Arrays.sort(nums);
		List<List<Integer>> threeSum = new ArrayList<>();
		
		for(int i=0; i<nums.length-2; i++){
			
			if(i>0 && nums[i] == nums[i-1])	continue;
			
			int start = i+1;
			int end = nums.length-1;
			
			while(start < end){								
				if((start-1)!=i && (nums[start] == nums[start-1])){
					start++;
					continue;
				}
				else if((end+1)<nums.length && (nums[end] == nums[end+1])){
					end--;
					continue;
				}
				
				int sum = nums[i] + nums[start] + nums[end];
				
				if(sum == target){
					List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[i]);
					triplet.add(nums[start]);
					triplet.add(nums[end]);
					threeSum.add(triplet);
					start++;
					end--;
				}
				else if(sum < target)	start++;
				else end--;
			}
		}
		
		return threeSum;
	}
	
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
		return out;
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
		//int[] a = {0, 0, 0, 0};
		int[] a = {-1, 0, 1, 2, -1, -4};
		//int[] a = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int target = 0;
		long startTime = System.currentTimeMillis();
		//List<List<Integer>> threeSum = get3Sum(a, target);
		List<List<Integer>> threeSum = get3Sum2ndApproach(a, target);
		long endTime = System.currentTimeMillis();	
		System.out.println(endTime - startTime);
		System.out.println(threeSum);			
	}

}
