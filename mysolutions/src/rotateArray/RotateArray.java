package rotateArray;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
        if(nums==null || nums.length<2 || k<1)	return;
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

	}

}
