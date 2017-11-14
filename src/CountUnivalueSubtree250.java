class Count{
    	public int count;
    	public Count(){
    		count=0;
    	}
}

public class CountUnivalueSubtree250 {
// USING POSTORDER TRAVERSAL : TIME COMPLEXITY = O(N) : SPACE COMPLEXITY O(1) 
	private static int getUniValue(TreeNode root) {
		Count c= new Count();
		getCountUniVal(root,c);
		return c.count;
	}

	private static boolean getCountUniVal(TreeNode root, Count c) {
		if(root == null)
			return true;
		
		boolean left = getCountUniVal(root.left,c);
		boolean right = getCountUniVal(root.right,c);
		if(left && right){
			if((root.left!= null && root.left.val != root.val)||
				(root.right!= null && root.right.val != root.val))
				return false;
			
			c.count++;
			return true;
		}
		return false;
	}

}
