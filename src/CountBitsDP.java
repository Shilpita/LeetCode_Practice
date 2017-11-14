/*
 * Calculate and display set bits for all numbers from 0 to num where num is non negative.
 * Time Complexity = O(N) and Space is O(N) for result NO EXTRA SPACE
 */
public class CountBitsDP {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        bits[0] =0;
        int pow =1, index =1;
        for(int i =1; i<= num ; i++){
            if(pow == i){
                bits[i] = 1;
                pow <<=1;
                index =1;
            }else{
                bits[i] = bits[index]+1;
                index++;
            }
        }
        
        return bits;
    }
	public static void main(String[] args) {
		int[] result = new CountBitsDP().countBits(12);
		for(int i : result)
			System.out.print(i+"  ");
	}

}
