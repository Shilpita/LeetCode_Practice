/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. You have to paint all the houses such 
 * that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1
 *  with color green, and so on... Find the minimum cost to paint all houses.
 * **/
public class PaintHouses256 {
	private static int getMinCost(int[][] costs) {
		int n = costs.length;
		if(n == 0)
			return 0;
		int totalcost =0;
		for(int i =1 ; i< n ; i++){
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}
		totalcost = Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
		return totalcost;
	}
	
	public static void main(String[] args) {
		int[][] costs = {{10, 3,8},{4,7,9},{1,2,3},{3,5,1}};
		
		System.out.println("The minimum cost of paint the houses is : "+ getMinCost(costs));

	}

}
