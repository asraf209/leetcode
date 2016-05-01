package rotatedSortedArray;

public class RotatedSortedArraySearch {
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length < 1)	return -1;
		int start = findStartPosition(nums, 0, nums.length-1);
		int end = 0;
		System.out.println("Transition: " + start);
		if((nums[start]<=target) && (target <= nums[nums.length-1])){
			end = nums.length-1;
		}
		else{
			if(start>0)	end = start -1;
			start = 0;			
		}
		System.out.println("start: " + start + ", end: " + end);
		while(start <= end){
			int mid = (start + end)/2;
			if(nums[mid]==target)	return mid;
			if(target < nums[mid])	end = mid -1;
			else start = mid + 1;
		}
		
		return -1;
    }
	
	private static int findStartPosition(int[] a, int s, int e){
		if(s > e)	return 0;
		System.out.println("s: " + s + ", e: " + e);
		int mid = (s + e)/2;
		
		if((mid-1)>=s && (a[mid] < a[mid-1]))	return mid;
		else if((mid+1)<=e && (a[mid] > a[mid+1]))	return mid+1;
		
		if(a[s] > a[mid-1])	return findStartPosition(a, s, mid-1);
		else if(a[mid] > a[e])	return findStartPosition(a, mid, e);
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7, 0, 1, 2, 4, 5, 6};
		//int[] a = {1, 2, 4};
		System.out.println(search(a, 2));
	}

}
