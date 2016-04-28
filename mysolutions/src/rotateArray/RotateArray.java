package rotateArray;

public class RotateArray {
	
	/**
	 * This algorithm is same as Reversing a String.
	 * Rotate left part
	 * Rotate right part
	 * Rotate whole array
	 * @param nums
	 * @param k
	 */
	public static void rotate(int[] nums, int k) {
        if(nums==null || nums.length<2 || k<1 || k==nums.length)	return;
        if(k>nums.length)	k = k % nums.length;
        
        rotateXtoY(nums, 0, nums.length-1-k);
        rotateXtoY(nums, nums.length-k, nums.length-1);
        rotateXtoY(nums, 0, nums.length-1);
    }
	
	private static void rotateXtoY(int[] nums, int x, int y){
		for(int i=x, j=y; i<j; i++, j--){
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		for(int n : a)
			System.out.print(n + ", ");
		System.out.println();
		
		rotate(a, k);
		for(int n : a)
			System.out.print(n + ", ");		
	}

}
