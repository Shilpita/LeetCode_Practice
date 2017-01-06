import java.util.Scanner;

public class IsPalindrome {
	public static boolean isPalindromeData(int num){
		int n = num;
		int reverse = 0;
		while(n > 0){
			int digit = n%10;
			reverse = reverse *10 +digit;
			n = n/10;
		}
		if(reverse == num)
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(num +"is a palidrome :"+ isPalindromeData(num));
	}

}
