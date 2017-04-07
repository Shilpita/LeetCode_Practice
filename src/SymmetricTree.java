  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class SymmetricTree {
	  public boolean isSymmetric(TreeNode root) {
	        if(root == null || (root.left == null && root.right == null))
	            return true;
	        
	        TreeNode lsub = root.left;
	        TreeNode rsub = root.right;
	        
	        return isSymmetricHelp(lsub,rsub);
	    }
	    
	    public boolean isSymmetricHelp(TreeNode left, TreeNode right){
	        if(left == null || right == null)
	            return left==right;
	            
	        if(left.val != right.val)
	            return false;
	            
	        return isSymmetricHelp(left.left , right.right) && isSymmetricHelp(left.right,right.left);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
