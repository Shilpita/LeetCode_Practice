
public class FlipGameII294 {
/**
 * TIME COMPLEXITY is O(n*n) or O(n!!) 
 * because each recursive step is carried out O(n) times
 * SPACE COMPLEXITY O(1)
 * This can be reduced to O(n^2) by DP using game theory
 * @param args
 */
	public static void main(String[] args) {
		boolean isWin = canWin("+++-+-++++".toCharArray());
		System.out.println(isWin);
	}

	private static boolean canWin(char[] cs) {
		boolean isWin =false;
		for(int i =1 ; i< cs.length;i++){
			if(cs[i-1] =='+' && cs[i]=='+'){
				cs[i-1] ='-';
				cs[i] ='-';
				isWin = !canWin(cs);
				cs[i-1] ='+';
				cs[i] ='+';
			}
		}
		if(isWin)
			return true;
		return false;
	}

}
