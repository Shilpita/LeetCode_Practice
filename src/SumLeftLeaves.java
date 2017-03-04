import java.util.Stack;

/**************************************************************************************************************************
 * author : Shilpita RoyCheck if gi
 * date   : Mar1,2017
 * purpose: Find the sum of all left leaves in a given binary tree.
 * 			Leetcode 404
 * *************************************************************************************************************************/

public class SumLeftLeaves {

	/**
	 * Definition for a binary tree node.
	 */
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	 /*****ITERATIVE METHOD O(N)****/
	    public int sumOfLeftLeavesIterative(TreeNode root) {
	        if(root == null) return 0;
	        int sum =0;
	        Stack<TreeNode> stack = new  Stack<TreeNode>();
	        stack.push(root);
	        while(!stack.isEmpty()){
	            TreeNode node = stack.pop();
	            if(node.left!=null){
	               if(node.left.left == null && node.left.right == null)
	                    sum+= node.left.val;
	               else
	                    stack.push(node.left);
	            }
	            if(node.right != null){
	                 if(node.right.left != null || node.right.right != null)
	                    stack.push(node.right);
	            }
	        }
	        
	        return sum;
	    }
	    
	   /******RECURSIVE METHOD O(N)******/
	   public int sumOfLeftLeavesRecursive(TreeNode root){
		   if(root == null) return 0;
		   int sum =0;
		   if(root.left != null){
			   if(root.left.left == null && root.left.right == null)
                   sum+= root.left.val;
			   else 
				   sum+= sumOfLeftLeavesRecursive(root.left);
		   }
		   sum+= sumOfLeftLeavesRecursive(root.right);
		   
		   return sum;
	   }
	    
}
