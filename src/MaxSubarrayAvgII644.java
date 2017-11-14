/**
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to
 *  k that has the maximum average value. And you need to output the maximum average value.

		Example 1:
		Input: [1,12,-5,-6,50,3], k = 4
		Output: 12.75
		Explanation:
		when length is 5, maximum average value is 10.8,
		when length is 6, maximum average value is 9.16667.
		Thus return 12.75.
		Note:
		1 <= k <= n <= 10,000.
		Elements of the given array will be in range [-10,000, 10,000].
		The answer with the calculation error less than 10-5 will be accepted.
 * @author shilpita
 *
 */
public class MaxSubarrayAvgII644 {

	public static void main(String[] args) {
		int[] arr = {1,12,-5,-6,50,13,45};
		int k = 5;
		System.out.println(getMaxSubLength(arr,k));

	}

	private static double getMaxSubLength(int[] arr, int k) {
		if(k <=0 || arr.length==0)
			return 0;
		double maxavg =0; 
		int count =0;
		for(int i = k; i< arr.length;i++){
			double avg = maxSubCalc(arr,i);
			maxavg = Math.max(avg, maxavg);
		}
		
		return maxavg;
	}

	private static double maxSubCalc(int[] arr, int k) {
		int sum =0, max = Integer.MIN_VALUE;
		for(int i =0 ; i< k;i++)
			sum+= arr[i];
		for(int i =k ; i< arr.length;i++){
			sum+= arr[i]-arr[i-k];
			max = Math.max(max, sum);
		}
		return (max*1.0)/k;
	}

}
