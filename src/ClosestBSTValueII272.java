import java.util.*;

// Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

// Note:
// Given target value is a floating point.
// You may assume k is always valid, that is: k ≤ total nodes.
// You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

public class ClosestBSTValueII272 {
	public static int goal;
	public static double min = Double.MAX_VALUE;
	
	public static void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val+"\t");
		inorder(root.right);
	}
	
	private static List<Integer> closestBSTValueII(TreeNode root, int target , int k) {
		List<Integer> list = new ArrayList<Integer>();
		
		Stack<TreeNode> successors = new Stack<TreeNode>();
		Stack<TreeNode> predecessors = new Stack<TreeNode>();
		
		while(root != null){
			if(root.val >= target){
				successors.push(root);
				root = root.left;
			}else{
				predecessors.push(root);
				root = root.right;
			}
		}
		
		while(k > 0 && (!successors.isEmpty() || !predecessors.isEmpty())){
			if(successors.isEmpty())
				list.add(getNextPredecessor(predecessors));
			else if(predecessors.isEmpty())
				list.add(getNextSuccessor(successors));
			else{
				if(Math.abs(predecessors.peek().val-target) < Math.abs(successors.peek().val-target))
					list.add(getNextPredecessor(predecessors));
				else
					list.add(getNextSuccessor(successors));
			}
			k--;
		}
		
		return list;
	}


	private static Integer getNextSuccessor(Stack<TreeNode> successors) {
		TreeNode node = successors.pop();
		TreeNode next = node.right;
		while(next != null){
			successors.push(next);
			next = next.left;
		}
		return node.val;
	}

	private static Integer getNextPredecessor(Stack<TreeNode> predecessors) {
		TreeNode node = predecessors.pop();
		TreeNode next = node.left;
		while(next != null){
			predecessors.push(next);
			next = next.right;
		}
		return node.val;
	}

	public static void main(String[] args) {
		/**
		 * 			   10
		 * 			 /     \
		 * 			5	    23
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
	    
	    inorder(a);
	    System.out.println("\nThe closest value in the BST to target is: "+ closestBSTValueII(a,59,3));
	}


}
