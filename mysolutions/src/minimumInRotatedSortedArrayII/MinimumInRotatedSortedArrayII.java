package minimumInRotatedSortedArrayII;

public class MinimumInRotatedSortedArrayII {
	
	/**
	 * Find the transition point
	 * It contains the minimum element
	 * O(log n)
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		if(nums == null || nums.length < 1)	return Integer.MAX_VALUE;
		int start = findStartPosition(nums, 0, nums.length-1);
		System.out.println("Transition point: " + start);
		return nums[start];
    }	
	
	/**
	 * Find the transition point.
	 * Values will not be in order in that point
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	private static int findStartPosition(int[] a, int s, int e){
		if(s > e)	return 0;
		System.out.println("s: " + s + ", e: " + e);
		int mid = (s + e)/2;
		
		// Values will not be in an order in that point
		if((mid-1)>=s && (a[mid] < a[mid-1]))	return mid;
		else if((mid+1)<=e && (a[mid] > a[mid+1]))	return mid+1;
		
		if((mid-1)>=s && (a[s] > a[mid-1]))	return findStartPosition(a, s, mid-1);
		else if(a[mid] > a[e])	return findStartPosition(a, mid, e);
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 4, 5, 5, 6, 6, 7, 0, 1};
		//int[] a = {1};
		System.out.println(findMin(a));
	}

}
