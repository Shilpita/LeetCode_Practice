
public class MatrixDiagonalTraverse498 {
	public static int[] findDiagonalOrder(int[][] matrix) {
		//Step1 : Empty Matrix
        if(matrix.length == 0)
           return new int[0];
        //Step2 : Initialize counts and traversed Matrix array
        int total = matrix.length * matrix[0].length, rcnt = matrix.length , ccnt = matrix[0].length ;
        int[] traversal = new int[total]; 
        //Step3 : Initialize a flag for traversal direction
        boolean up = true;
        //Step4 : Loop through matrix diagonally for alternate direction
        int row =0 , col = 0 ,count =0 ;
        while(count < total){
            if(up){
                while(row >= 0 && col < ccnt){
                   traversal[count] = matrix[row][col];
                   count++;
                   row--;
                   col++;
                   //System.out.println(traversal[count]+""+ up);
                }
                up = false;
                if(row < 0) row = 0;
                if(col >= ccnt){
                	col = ccnt-1;
                	//row++;
                }
            }else{
                while(col >= 0 && row < rcnt){
                    traversal[count] = matrix[row][col];
                    count++;
                    row++;
                    col--;
                   // System.out.println(traversal[count]+""+ up);
                }
                up = true;
                row= (row >= rcnt)? (row-1):row;
                col= (col < 0)? 0:col;
            }
            //count++;
        }
        return traversal;  
	}
	public static void main(String[] args) {
		/**
		 *   1	2  3
		 *   4	5  6
		 * 	 7  8  9 
		 */
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[] traverse = findDiagonalOrder(matrix);
		for(int i : traverse)
			System.out.print(i+"\t");
	}

}
