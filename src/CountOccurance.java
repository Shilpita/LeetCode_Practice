/*********************************************************************************************
 * author : Shilpita Roy
 * date   : 21 March 2016
 * purpose: Count Occurance of number in sorted array using Binary search
 *********************************************************************************************/
public class CountOccurance {
	//static int count =0 ;
	
	private static int firstOccurance (int[] arr, int low, int high, int x){
		    int mid ;
		    if(high >= low){
		   // while(low <= high){
		    	mid = (high + low)/2;
		    	//System.out.println("\n mid "+mid);
		    	if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
		    		//System.out.println("\n mid "+mid);
		    		return mid ;
		    	else if(x > arr[mid])
		    		return firstOccurance(arr, (mid + 1), high, x);
		    	else
		    		return firstOccurance(arr, low, (mid -1), x);
		    	
		    	}
		  //  }
		    return -1;
	}
	
	private static int lastOccurance (int[] arr, int low, int high, int x){
	    int mid ;
	    if(high >= low){
	  //  while(low <= high){
	    	mid = (high + low)/2;
	    	if( ( mid == arr.length-1 || x < arr[mid+1]) && arr[mid] == x )
	    		return mid;
	    	else if(x < arr[mid])
	    		return lastOccurance(arr, low, (mid -1), x);
	    	else
	    		return lastOccurance(arr, (mid + 1), high, x);
	    	}
	 //   }
	    return -1;
   }
	
	private static int countOccurance(int[] arr , int n , int x){
		if(arr.length ==1 && arr[0] == x)
			return 1;
		else{
			int first = firstOccurance(arr , 0 , arr.length -1 ,x);
		//	System.out.println("first "+ first);
			int last;
			if (first < 0)
				return 0;
			else 
				last = lastOccurance (arr, first ,arr.length -1 ,x);
		//	System.out.println("last "+ last);
			return (last - first +1);
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr = {0, 7, 9, 9, 9, 10, 56, 80, 100 }; //,101,111};
       
      
       System.out.println("\n The occurance of 9 in array is "+countOccurance(arr, arr.length , 9));    
	}

}
