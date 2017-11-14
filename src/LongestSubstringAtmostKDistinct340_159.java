import java.util.HashMap;

// TIME COMPLEXITY: O(N) SPACE COMEPLEXITY: O(N) 
public class LongestSubstringAtmostKDistinct340_159 {

	public static void main(String[] args) {
		String word = "abcaacccaacdb";
		System.out.println(getLongestSubstring(word,2));
	}

	private static int getLongestSubstring(String word, int k) {
		int max = Integer.MIN_VALUE;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int start = 0;
		for(int i = 0 ; i < word.length();i++){
			map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
			if(map.size() > k){
				max = Math.max(max, i-start);
				while(map.size() > k){
					char c = word.charAt(start);
					int count = map.get(c);
						if(count > 1)
							map.put(c, map.get(c)-1);
						else
							map.remove(c);
					 start++;
				}
						
			  }
					
			}
			
			max = Math.max(max, word.length()-start);
			return max;
	}
}


