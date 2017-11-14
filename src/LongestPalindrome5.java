/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example: Input: "babad"  Output: "bab"   Note: "aba" is also a valid answer.
 * @author Shilpita
 * 
 * TIME : O(n*n) SPACE : O(1)
 * The idea is to generate all even length and odd length palindromes and keep track of the longest palindrome seen so far.
 * 
 */
public class LongestPalindrome5 {

	public static void main(String[] args) {
		String str = "geekforgeeksababa";
		System.out.println(getLPS(str));

	}

	private static String getLPS(String str) {
		if(str.isEmpty() || str.length() ==0)
			return null;
		
		int n = str.length();
		int max = 1 , startindex = 0;
		
		for(int i = 1  ; i< n ; i++){
			int low = i-1, high = i;
			while(low >= 0 && high < n && str.charAt(low)== str.charAt(high)){
				if(high-low+1 > max){
					max = high-low+1;
					startindex = low;
				}
				low--;
				high++;
			}
			low = i-1;
			high = i+1;
			while(low >= 0 && high < n && str.charAt(low)== str.charAt(high)){
				if(high-low+1 > max){
					max = high-low+1;
					startindex = low;
				}
				low--;
				high++;
			}
		}
		
		return str.substring(startindex,startindex+max);
	}
}
