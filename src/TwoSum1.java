/************************************************************************************************************
	1. Two Sum 
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].

**************************************************************************************************************/
import java.lang.*;
import java.util.*;

public class TwoSum1 {
    public static int[] twoSum(int[] arr, int target) {
    	if(arr.length ==0) return arr;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i =0 ; i< arr.length ; i++){
    		if(map.containsKey(target - arr[i]))
    			return new int[] {i , map.get(target-arr[i])};
    		else
    			map.put(arr[i],i);
    	}
    	return (new int[]{-1,-1});
    }
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int target = scan.nextInt();
    	int n = scan.nextInt(); //size of input array
    	int[] a = new int[n];
    	for(int i =0 ; i<n ;i++)
    		a[i] = scan.nextInt();

    	int[] result = twoSum(a,target);
    	System.out.println("Indices are : "+ result[0]+" and "+result[1]);
    }
}