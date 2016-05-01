package rotatedSortedArray;

public class RotatedSortedArraySearch {
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length < 1)	return -1;
		int start = findStartPosition(nums, 0, nums.length-1);
		return start;
    }
	
	private static int findStartPosition(int[] a, int s, int e){
		if(s > e)	return 0;
		int mid = (s + e)/2;
		if(mid>0 && (a[mid] < a[mid-1]))	return mid;
		if(a[s] > a[mid-1])	return findStartPosition(a, s, mid-1);
		else if(a[mid] > a[e])	return findStartPosition(a, mid, e);
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
