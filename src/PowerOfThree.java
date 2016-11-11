/**************************************************************************
 * author : Shilpita Roy
 * date   : 21 March 2016
 * purpose: Determine if a given integer input is power of two
 * *****************************************************************************/

import java.util.Scanner;

public class PowerOfThree {
	  public static boolean isPowerOfThree(int n) {
	        if(n <= 0)
	           return false;
	       // else return 1162261467%n == 0;
	        else return Math.pow(3,19)%n ==0 ;
	    }
    
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));

	}

}
