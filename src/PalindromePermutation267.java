import java.util.*;

/**
 *Given a string s, return all the palindromic permutations (without duplicates) of it. 
 *Return an empty list if no palindromic permutation could be form.
 *For example:
 *	Given s = "aabb", return ["abba", "baab"].
 *	Given s = "abc", return [].
 *Hint:
 *	If a palindromic permutation exists, we just need to generate the first half of the string.
 *  To generate all distinct permutations of a (half of) string, use a similar approach from: 
 *  Permutations II or Next Permutation.
 * @author Shilpita
 */
public class PalindromePermutation267 {

	public static void main(String[] args) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		System.out.println(getAllPalindromePermutation("aabbd").toString());
	}

	private static List<String> getAllPalindromePermutation(String s) {
		//Step1 : Initialize result list
		List<String> list = new ArrayList<String>();
		
		//Step2 : If input string is empty or null
		if(s == null || s == ""||s.length() ==0)
			return list;
		
		//Step3 : If the input string is palindrome
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		if(!isPalindrome(s,map))
			return list;
		
		//Step4 : create Char array and find middle char
		char middle = '\0';
		ArrayList<Character> charList = new ArrayList<Character>();
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			char key = entry.getKey();
			int count= entry.getValue();
			while(count > 1){
				charList.add(key);
				count -=2;
			}
			if(count == 1)
				middle = key;
		}
		
		//Step5 : create List of all permutations of Palindrome
		getAllPermutation(list, new boolean[charList.size()],charList,middle, new StringBuilder());
		
		return list;
	}
	//FUNCTION TO CHECK IF STRING CAN BE PALINDROME
	private static boolean isPalindrome(String s, HashMap<Character,Integer> map) {
		if(s == null || s.length()==0 || s=="")
			return true;
		int numOdd = 0;
		for(Character c: s.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
			//System.out.println(map.get(c));
			numOdd += (map.get(c)%2 != 0)? 1:-1;
			
			//System.out.println(numOdd);
		}
		//System.out.println(numOdd);
		if(numOdd <=1)
			return true;
		return false;
	}
	
	//FUNCTION TO GENERATE ALL PALINDROME STRINGS
	private static void getAllPermutation(List<String> list, boolean[] visited, ArrayList<Character> charList, 
										  char middle, StringBuilder sb) {
		if(sb.length() == charList.size()){
			list.add(new String(sb.toString() + middle + sb.reverse().toString()));
			sb.reverse();
			return;
		}else{
			for(int i = 0 ; i < charList.size(); i++){
				if(i > 0 && charList.get(i) == charList.get(i-1) && !visited[i-1])
					continue;
				if(!visited[i]){
					//1: CREATE PERMUTATION
					sb.append(charList.get(i));
					visited[i] = true;
					//2: RECURSION
					getAllPermutation(list, visited,charList,middle,sb);
					//3: BACKTRACKING
					visited[i] = false;
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}	
	}



}
