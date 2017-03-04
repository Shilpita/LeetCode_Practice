/**************************************************************************************************************************
 * author : Shilpita Roy
 * date   : Feb19,2017
 * purpose: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding 
 * 			up all the values along the path equals the given sum
 * 			Leetcode 112
 * *************************************************************************************************************************/

public class PathSumI {
	  public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		}
	  
	public static boolean hasPathSum(TreeNode root, int sum){
		if(root == null) return false;
		if(root.left == null && root.right == null && sum-root.val==0 )
			return true;
		
		return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
	}
	
	public static void main(String[] args) {
		TreeNode btree = new TreeNode(4);
		btree.left = new TreeNode(2);
		btree.right = new TreeNode(6);
		btree.left.left = new TreeNode(1);
		btree.left.right = new TreeNode(3);
		btree.right.left = new TreeNode(5);
		btree.right.right = new TreeNode(7);
		
		System.out.println(hasPathSum(btree,15));
	}

}
