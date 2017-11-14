
public class LongestConsecutiveSeqBT298 {
	public static int maxLCS(TreeNode root){
		int[] maxval = {0};
		getMaxLCS(root,0,maxval,root.val);
		return maxval[0];
	}

	private static void getMaxLCS(TreeNode root, int currlen, int[] maxval, int target) {
		if(root == null)
			return ;
		
		if(root.val == target)
			currlen++;
		else
			currlen =1;
		maxval[0] = Math.max(maxval[0],currlen);
		getMaxLCS(root.left, currlen,maxval, root.val +1);
		getMaxLCS(root.right, currlen,maxval, root.val +1);
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
	    System.out.println(maxLCS(a));
	}

}
