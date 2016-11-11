
public class ReverseArray {
	private static int[] reverse(int[] arr){
		int mid = (0+ arr.length-1)/2;
		for(int i=0 ; i < mid ; i++){
			arr[i] = arr[i] + arr[arr.length -1 -i];
			arr[arr.length -1 -i] = arr[i] -arr[arr.length -1 -i];
			arr[i] = arr[i] - arr[arr.length -1 -i];
		}	
		return arr;
		
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		for(int i =0 ; i< arr.length ; i++)
			System.out.print(arr[i]+ " ");
		
		arr = reverse(arr);
		System.out.println("\n");
		for(int i =0 ; i< arr.length ; i++)
			System.out.print(arr[i]+ " ");

	}

}
