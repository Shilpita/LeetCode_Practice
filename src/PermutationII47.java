import java.util.*;

public class PermutationII47 {
	public static List<List<Integer>> permuteUnique(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
		for(boolean b : used) System.out.print(b+"\t");
		System.out.println();
		for(Integer i : tempList) System.out.print(i +"\t");
		System.out.println();
	    if(tempList.size() == nums.length){
	        list.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]){
	            	//System.out.println(nums[i-1] + "\t"+ used[i - 1] +"\t"+nums[i] +"\t"+used[i]);
	            	continue;
	            }
//	    		for(boolean b : used) System.out.print(b+"\t");
//	    		System.out.println();
//	    		for(Integer n : tempList) System.out.print(n +"\t");
//	    		System.out.println();
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	public static void main(String[] args) {
		int[] arr ={1,2,3,1};
		List<List<Integer>> result = permuteUnique(arr);
		for(List<Integer> i : result)
			System.out.println(i.toString());
	}

}
