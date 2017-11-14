import java.util.ArrayList;

public class KSmallest230 {
	public static int kSmallest(TreeNode root,int k){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return Integer.MAX_VALUE;
		inorder(root,result);
		if(k > result.size())
			return Integer.MAX_VALUE;
		return result.get(k-1);
	}

	private static void inorder(TreeNode root, ArrayList<Integer> result) {
		if(root == null)
			return;
		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right,result);
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

	    System.out.println(kSmallest(a, 80));
	}

}
