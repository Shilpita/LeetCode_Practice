import java.util.ArrayList;
import java.util.List;

public class FlattenBT114 {
	public static List<Integer> flatten(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		flattenHelper(root,null,list);
		return list;
	}

	private static TreeNode flattenHelper(TreeNode root, TreeNode prev, List<Integer> list) {
		if(root == null)
			return null;
		
		prev = flattenHelper(root.right, prev,list);
		prev = flattenHelper(root.left, prev, list);
		root.right = prev;
		root.left  = null;
		list.add(root.val);
		prev = root;
		return prev;
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

	    System.out.println(flatten(a).toString());
	}

}
