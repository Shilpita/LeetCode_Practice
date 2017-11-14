import java.util.*;

public class FlipGame293 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = getFilps("+++++");
		System.out.println(list.toString());
	}

	private static List<String> getFilps(String s) {
		List<String> list = new ArrayList<String>();
		if(s == null || s.length() ==0 || s =="")
			return list;
		char[] c = s.toCharArray();
		for(int i =1 ; i<c.length;i++){
			if(c[i-1] == c[i] && c[i]=='+'){
				c[i-1] ='-';
				c[i]='-';
				list.add(new String(c));
				c[i-1] ='+';
				c[i] ='+';
			}
		}

		return list;
	}

}
