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
	public static List<List<Integer>> get4Sum(int[] nums, int target){
		if(nums==null || nums.length<4)	return new ArrayList<>();
		
		Arrays.sort(nums);
		List<List<Integer>> fourSum = new ArrayList<>();
		
		for(int i=0; i<nums.length-3; i++){
			if(i>0 && nums[i] == nums[i-1])	continue;			
			for(int j=i+1; j<nums.length-2; j++){
				if(j>(i+1) && nums[j] == nums[j-1])	continue;
				
				int start = j+1;
				int end = nums.length-1;
				
				while(start < end){								
					if((start-1)!=j && (nums[start] == nums[start-1])){
						start++;
						continue;
					}
					else if((end+1)<nums.length && (nums[end] == nums[end+1])){
						end--;
						continue;
					}
					
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					
					if(sum == target){
						List<Integer> quadruplates = new ArrayList<>();
						quadruplates.add(nums[i]);
						quadruplates.add(nums[j]);
						quadruplates.add(nums[start]);
						quadruplates.add(nums[end]);
						fourSum.add(quadruplates);
						start++;
						end--;
					}
					else if(sum < target)	start++;
					else end--;
				}
			}			
			
		}
		
		return fourSum;
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(get4Sum(a, target));;			
	}

}
