
public class RemoveElements {
	 public static int removeElement(int[] nums, int val) {
	        if(nums.length == 0)
	            return nums.length;
	        if(nums.length < 2 && nums[0] == val)
	            return 0;
	        int output = nums.length ;
	        int high = nums.length -1;
	        int low  = 0;
	        while(high >= low){
	            if(nums[low] == val){
	                if(nums[high] != val){
	                //swap 
	                int temp = nums[high];
	                nums[high] = nums[low];
	                nums[low] = temp;
	                
	                low++;
	              }
	                high--;
	                output--;
	           }else
	                low++;
	        }
	        
	        return output;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
