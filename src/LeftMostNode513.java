
public class LeftMostNode513 {
	public static int leftMost(TreeNode root){
		int[] result = {-1,-1}; // index 0 -> current depth, index 1-> leftmost
		
		if(root == null)
			return result[1];
		
		getLeftMost(root,0,result);
		return result[1];
	}

	private static void getLeftMost(TreeNode root, int currdepth, int[] result) {
		if(root == null)
			return;
		
		if(result[0] < currdepth){
			result[1] = root.val;
			result[0] = currdepth;
		}
		
		if(root.left != null)
			getLeftMost(root.left, currdepth+1, result);
		
		if(root.right != null)
			getLeftMost(root.right, currdepth+1, result);
		
	}

	public static void main(String[] args) {
		/**
		 * 			   10
		 * 			 /     \
		 * 			5	    11
		 * 		  /  \	   /  \
		 *       3    7   12   100
		 *      / \    \
		 *    -2   4    8
		 *       
		 */
		
	    TreeNode a = new TreeNode(10);
	    TreeNode b = new TreeNode(5);
	    TreeNode c = new TreeNode(-2);
	    TreeNode d = new TreeNode(3);
	    TreeNode e = new TreeNode(4);
	    TreeNode f = new TreeNode(7);
	    TreeNode g = new TreeNode(8);
	    TreeNode h = new TreeNode(11);
	    TreeNode i = new TreeNode(12);
	    TreeNode j = new TreeNode(100);
	    
	    a.left = b; a.right = h;
	    b.left = d; b.right = f;
	    d.left = c; d.right = e;
	    f.right= g; 
	    h.left =i ; h.right = j;
	    
	    System.out.println(leftMost(a));
	}

}
