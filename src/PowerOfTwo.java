/**************************************************************************
 * author : Shilpita Roy
 * date   : 21 March 2016
 * purpose: Determine if a given integer input is power of two
 * *****************************************************************************/

import java.util.Scanner;

public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
	     
	       if (n <= 0)
	           return false;
	        else if (0 == (n & (n-1))) // one bit is set for numbers raised to power of two so finding AND with odd number
	            return true;
	        else
	            return false;
	       
	       /*  
	        ///Recursive approach
	        * if (n <= 0)
	          return false;
	        else if(n == 1)
	          return true; 
	        else {
	            
	            if(n%2 == 0)
	                return isPowerOfTwo(n/2);
	            else
	                return false ;
	         }
	      */  
	}
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter x :");
		 int x = in.nextInt();
		System.out.println("Is " +x + " power of two :" + isPowerOfTwo(x));

	}

}
