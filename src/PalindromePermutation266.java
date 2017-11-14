import java.util.HashSet;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,"code" -> False, "aab" -> True, "carerac" -> True.
 * @author Shilpita
 *
 */
public class PalindromePermutation266 {

	public static void main(String[] args) {
		System.out.println(isPalindrome("aabbde"));
	}

	private static boolean isPalindrome(String s) {
		if(s == null || s.length()==0 || s=="")
			return true;
		HashSet<Character> set = new HashSet<Character>();
		for(char c : s.toCharArray()){
			if(set.contains(c))
				set.remove(c);
			else
				set.add(c);
		}
		return set.size() == 0 || set.size() ==1 ; 
	}

}
