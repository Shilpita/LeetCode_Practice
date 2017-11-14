import java.util.ArrayList;

public class BinaryTreeBoundary {
	public static ArrayList<Integer> boundary(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		
		result.add(root.val);
		
		getBoundaryValues(root.left, result, true, false);
		getBoundaryValues(root.right, result, false, true);
		
		return result;
		
	}
	private static void getBoundaryValues(TreeNode root, ArrayList<Integer> result,
			boolean isLeftBoundary, boolean isRightBoundary) {
		if(root == null)
			return;
		
		if(root.left == null && root.right == null){
			result.add(root.val);
			return;
		}
		
		if(isLeftBoundary)
			result.add(root.val);
		
//		getBoundaryValues(root.left, result,isLeftBoundary && root.left!=null,root.right == null && isRightBoundary);
//		getBoundaryValues(root.right, result,isLeftBoundary && root.left==null,root.right != null && isRightBoundary);
		
		getBoundaryValues(root.left, result,isLeftBoundary ,root.right == null && isRightBoundary);
		getBoundaryValues(root.right, result,isLeftBoundary && root.left == null,isRightBoundary);
		
		if(isRightBoundary)
			result.add(root.val);
		
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

	    ArrayList<Integer> result = boundary(a);
	    System.out.println(result.toString());
	}

}
