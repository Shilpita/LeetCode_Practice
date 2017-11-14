import java.util.ArrayList;
import java.util.Collections;

public class BestMeetingPoint296 {

	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0,1},
				        {0,0,0,0,0},
				        {0,0,1,0,0}};
		System.out.println(getBestMeetingPnt(grid));
	}

	private static int getBestMeetingPnt(int[][] grid) {
		if(grid.length == 0)
			return 0;
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		
		for(int i =0 ; i< grid.length;i++){
			for(int j =0 ; j < grid[0].length;j++){
				if(grid[i][j] ==1){
					row.add(i);
					col.add(j);
				}	
			}
		}
		Collections.sort(col);
		
		return getMinDist(row) + getMinDist(col);
	}

	private static int getMinDist(ArrayList<Integer> list) {
		if(list.size() ==0)
			return 0;
		
		int sum = 0;
		for(Integer i : list)
			sum += Math.abs(i - list.get(list.size()/2));
		
		return sum;
	}

}
