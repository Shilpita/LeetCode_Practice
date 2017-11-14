import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This is the extension problem of Word Pattern I.
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * @author shilpita
 *
 */
public class WordPatternII {

	public static void main(String[] args) {
		String str = "redblueredblue";
		String pattern = "abab";
		HashMap<Character,String> map = new HashMap<Character,String>();
		HashSet<String> set = new HashSet<String>();
		System.out.println( wordPatternHelper(str,0,pattern,0,map,set));	
	}

	private static boolean wordPatternHelper(String str, int curPosStr, String pattern, int curPosPat,
			HashMap<Character, String> map,
			HashSet<String> set) {
		if(curPosStr == str.length() && curPosPat == pattern.length())
			return true;
		if(curPosStr > str.length() && curPosPat > pattern.length())
			return false;
		char c = pattern.charAt(curPosPat);
		for(int i = curPosStr+1 ; i<= str.length(); i++){
			String temp = str.substring(curPosStr,i);
			if(map.containsKey(c) && set.contains(temp) && map.get(c).equals(temp)){
				if(wordPatternHelper(str,i,pattern,curPosPat+1,map,set))
					return true;		
			}else if(!map.containsKey(c) && !set.contains(temp)){
				map.put(c, temp);
				set.add(temp);
				if(wordPatternHelper(str,i,pattern,curPosPat+1,map,set))
					return true;
				map.remove(c);
				set.remove(temp);
			}
		}
		
		return false;
	}

}
