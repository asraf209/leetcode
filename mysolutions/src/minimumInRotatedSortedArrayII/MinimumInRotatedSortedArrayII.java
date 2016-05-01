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
	 * Binary search can not be used here, as in the previous problem
	 * Because, duplicate elements can be anywhere, which makes it difficult to do binary search
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	private static int findStartPosition(int[] a, int s, int e){
		int pos = 0;
		for(int i=s+1; i<=e; i++){
			if(a[i-1] > a[i]){
				pos = i;
				break;
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 1, 3, 1};
		//int[] a = {1};
		System.out.println(findMin(a));
	}

}
