import java.util.ArrayList;
/***
 * Get all permutation of a given string. All distinct combination including duplicate characters
 * @author Shilpita
 *
 */
public class GetAllAnagram {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<Character> list = new ArrayList<Character>();
		for(char c : str.toCharArray())
			list.add(c);
		
		ArrayList<String> result = new ArrayList<String>();
		
		getAnagram(result, list, "", str.length());
		
		for(String s : result)
			System.out.println(s);
	}

	private static void getAnagram(ArrayList<String> result, ArrayList<Character> list, String curString, int length) {
		if(curString.length() == length){
			result.add(curString);
			return;
		}
		
		for(int i = 0 ; i< list.size(); i++){
			char c = list.get(i);
			list.remove(i);
			getAnagram(result, list, curString+c, length);
			list.add(i,c);
		}
		
	}
}
