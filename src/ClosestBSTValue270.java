//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

public class ClosestBSTValue270 {
		//public static int goal;
		//public static double min = Double.MAX_VALUE;
		
		/**
		public static void inorder(TreeNode root){
			if(root == null) return;
			inorder(root.left);
			System.out.print(root.val+"\t");
			inorder(root.right);
		}
		**/
		private static int closestBSTValue(TreeNode root, int target) {
			int[] res = {Integer.MAX_VALUE,Integer.MAX_VALUE};
			inorderHelper(root,target, res);
			return res[1];
		}

		private static void inorderHelper(TreeNode root, int target, int[] res) {
			if(root == null)
				return;
			
			if(Math.abs(target - root.val) < res[0]){
				//System.out.println("\n"+min + "\t"+Math.abs(target - root.val) );
				res[0] = Math.abs(target - root.val);
				res[1] = root.val;
			}
				
			if(root.val < target)
				inorderHelper(root.right , target, res);
			else
				inorderHelper(root.left , target, res);
			
		}

		public static void main(String[] args) { 
			/**
			 * 			   10
			 * 			 /     \
			 * 			5	    20
			 * 		  /  \	   /  \
			 *       3    7   19   100
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
		    TreeNode h = new TreeNode(23);
		    TreeNode i = new TreeNode(19);
		    TreeNode j = new TreeNode(100);
		    
		    a.left = b; a.right = h;
		    b.left = d; b.right = f;
		    d.left = c; d.right = e;
		    f.right= g; 
		    h.left =i ; h.right = j;
		    
		    //inorder(a);
		    System.out.println("\nThe closest value in the BST to target " + 59 + " is: "+ closestBSTValue(a,59));
		}


	

}
