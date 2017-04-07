
public class RemoveDuplicateArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int output = 1;
        for(int i =1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[output] = nums[i];
                output++;
            }
        }
        
        return output;
    }
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2,7,7,7};
		System.out.println(removeDuplicates(nums));

	}

}
