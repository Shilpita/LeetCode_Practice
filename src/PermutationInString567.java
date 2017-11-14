import java.util.Arrays;

public class PermutationInString567 {
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2) 
                return false;
        
        int[] count = new int[26];
        //Arrays.fill(count,0);
        
        for(int i = 0 ; i < l1 ; i++){
            count[s1.charAt(i)-'a']++;
            System.out.println(s1.charAt(i)+"-"+(s1.charAt(i)-'a') +"\t"+count[s1.charAt(i)-'a']); 
        }
        System.out.println();
        for(int i = 0 ; i < l1 ; i++){
            count[s2.charAt(i)-'a']--;
            System.out.println(s2.charAt(i)+"-"+(s2.charAt(i)-'a') +"\t"+count[s2.charAt(i)-'a']); 
        }
        if(isZero(count)) return true;
        System.out.println();
        
        for(int i =l1 ; i< l2 ; i++){
            //if(count[s2.charAt(i)-'a'] > 0)
               count[s2.charAt(i)-'a']--;
            
            count[s2.charAt(i-l1)-'a']++ ;
            
            System.out.println(s2.charAt(i)+"-"+(s2.charAt(i)-'a') +"\t"+count[s2.charAt(i)-'a']); 
            
            if(isZero(count)) return true;
        }
        
        return false;
    }
	private static boolean isZero(int[] count) {
		for(int i : count){
			System.out.println(i);
			if(i!= 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "oosbelooelhlooabh";
		System.out.println(checkInclusion(s1, s2));
	}

}
