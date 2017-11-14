import java.util.*;

public class FindLeavesTree366 {
	

	public static void main(String[] args) {
		/**
		 * 				1
		 * 			  /   \
		 * 			 2      3
		 * 			/ \    / \
		 * 		   4   5  6   7  
		 *             \     /  
		 *              8   10
		 *              	 \
		 *              	  9
		 */
		TreeNode btree = new TreeNode(1);
		btree.left = new TreeNode(2);
		btree.right = new TreeNode(3);
		btree.left.left = new TreeNode(4);
		btree.left.right = new TreeNode(5);
		btree.left.right.right = new TreeNode(8);
		btree.right.left = new TreeNode(6);
		btree.right.right = new TreeNode(7);
		btree.right.right.left = new TreeNode(10);
		btree.right.right.left.right = new TreeNode(9);
		List<List<Integer>> result = getLeafNode(btree);
		System.out.println(result);
	}

	private static List<List<Integer>> getLeafNode(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
			getLeafNodeHelp(root,result);
			return result;
	}

	private static int getLeafNodeHelp(TreeNode root, List<List<Integer>> result) {
		if(root == null)
			return -1;
		
		int left = getLeafNodeHelp(root.left,result);
		int right= getLeafNodeHelp(root.right,result);
		int curr = Math.max(left, right)+1;
		System.out.println(curr+ "\t"+ root.val);
		if(result.size() <= curr){
			result.add(new ArrayList<Integer>());
		}
		
		result.get(curr).add(root.val);
		
		return curr;
	}

}
