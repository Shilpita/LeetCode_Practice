import java.util.ArrayList;
import java.util.Scanner;

/****
 * Generalized Abbreviation
 * Write a function to generate the generalized abbreviations of a word.
 * Example:  
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * METHOD : DFS /Backtracking 
 * TIME COMPLEXITY = O(2^N) Every char has two possibilities, either abbreviate it or omit it.So there are total 2^n possibilities.
 */


public class GeneralizedAbbreviation320 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		
		ArrayList<String> list = new ArrayList<String>();
		getAbbreviation(list, word, new StringBuilder(), 0, 0, "BackTrack0 ");
		
		System.out.println("THE FINAL LIST CREATED BELOW:");
		for(String s : list)
			System.out.print(s + "\t");
	}

	private static void getAbbreviation(ArrayList<String> list, String word, StringBuilder curStr, int curPos, int count, String bckCall) {
		int curStrLength = curStr.length();
		System.out.println(bckCall);
		if(curPos == word.length()){
			if(count > 0){
				curStr.append(""+ count);
			}
			System.out.println(bckCall+ " : "+curPos+" : "+ curStr);
			list.add(curStr.toString());
		}else{
			//To skip the letter and increase count
			getAbbreviation(list, word, curStr , curPos+1 , count+1 , "BackTrack1 ");
			
			//Consider the count and the letter on the position
			if(count > 0){
				curStr.append(""+ count);
			}
			
			curStr.append(word.charAt(curPos));
			
			getAbbreviation(list, word, curStr , curPos+1 , 0, "BackTrack2 ");	
		}
		
		curStr.setLength(curStrLength);
	}

}
