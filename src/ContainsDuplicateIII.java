import java.util.*;
/**************************************************************************************************************************
 * author : Shilpita Roy
 * date   : Feb18,2017
 * purpose: Check if given array has almost duplicates of difference at most t in index difference at most k.
 * 			Leetcode 220
 * *************************************************************************************************************************/

public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	// Base case1: If there is only one or less element in array then no duplicates.
        if(nums.length <= 1) return false;
        
        // Base case2: If no distance between elements or -ve difference then return false
        if(k < 1 || t < 0) return false;
        
        TreeSet<Integer> tree = new TreeSet<Integer>(); // BST to hold the possible values within the range of t
        
        for(int i = 0 ; i<nums.length; i++){
        	
            // Overflow Check
            int min_limit = Integer.MIN_VALUE + t;
            int rmin = nums[i] > min_limit ? nums[i] - t : Integer.MIN_VALUE;      	
            
            Integer ceil =   tree.ceiling(rmin); 
            
            // left region 
            if (ceil != null && ceil <= (rmin + t)) {
            	System.out.println(nums[i]+ " " + ceil);
                return true;
            }
            	
            // Overflow Check
            int max_limit = Integer.MAX_VALUE - t;
            int rmax = nums[i] < max_limit ? nums[i] + t : Integer.MAX_VALUE;
            
            Integer floor  =  tree.floor(rmax); 
    
            // right region
            if (floor != null && floor >= (rmax - t)) {
            	System.out.println(nums[i]+"  "+ floor);
                return true;
            }
            
            tree.add(nums[i]); 
            
            if(i >= k) // move the window 
               tree.remove(nums[i-k]);
        }
        return false;
    }
    
    public static void test_overflow01() {
    	int[] arr = {-2147483648,-2147483647};
    	assert(containsNearbyAlmostDuplicate(arr,3,3));
    }
    
    public static void test_overflow02() {
    	int[] arr1 = {-1,2147483647};
		assert(!containsNearbyAlmostDuplicate(arr1,1,2147483647));
    }
   
    public static void test_duplicates() {
    	int[] arr1 = {-1,5, 10, 4, -1, 5, 7};
		assert(containsNearbyAlmostDuplicate(arr1, 3, 1));
		assert(containsNearbyAlmostDuplicate(arr1, 3, 3));
		assert(containsNearbyAlmostDuplicate(arr1, 3, 100));
		assert(!containsNearbyAlmostDuplicate(arr1, 100, 100));
    }
    
    
	public static void main(String[] args) {
		test_overflow01();
		test_overflow02();
		test_duplicates();
		
	}
    
/*	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if (k < 1 || t < 0) return false;
	    Map<Long, Long> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        long remappedNum = (long) nums[i] - Integer.MIN_VALUE; // if t is max int value then division by t gives 0
	        System.out.println(remappedNum);
	        long bucket = remappedNum / ((long) t + 1); // why t+1 ? because, if t not plus 1, when t == 0, num divide by 0 will cause crash.
	        System.out.println(bucket);
	        if (map.containsKey(bucket) // means the key in the map duplicated, it means the must be exist two numbers that the different value between them are less than t
	                || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) // if the two different numbers are located in two adjacent bucket, the value still might be less than t
	                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)){
	        	System.out.println(nums[i]+" "+remappedNum+"  "+bucket+" "+map.get(bucket - 1)+" "+  map.get(bucket + 1));
	                        return true; // the same reason for -1
	        }                
	        if (map.entrySet().size() >= k) { 
	            long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
	            map.remove(lastBucket);
	        }
	        map.put(bucket, remappedNum); //replace the duplicated key
	        System.out.println(map.toString());
	    }
	    return false;
	}
*/


}
