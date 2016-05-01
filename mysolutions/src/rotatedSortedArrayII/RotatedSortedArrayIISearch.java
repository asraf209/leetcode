package rotatedSortedArrayII;

public class RotatedSortedArrayIISearch {
	public static boolean search(int[] nums, int target) {
		if(nums == null || nums.length < 1)	return false;
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
			if(nums[mid]==target)	return true;
			if(target < nums[mid])	end = mid -1;
			else start = mid + 1;
		}
		
		return false;
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
		//int[] a = {2, 4, 5, 5, 6, 6, 7, 0, 1};
		int[] a = {1, 1, 3, 1};
		System.out.println(search(a, 3));
	}

}
