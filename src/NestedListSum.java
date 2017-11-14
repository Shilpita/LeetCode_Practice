import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * @author Shilpita
 *
 */
class NestedList{

	public List<NestedList> getvalues() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getInteger() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
public class NestedListSum {
    public static int nestedSum(List<NestedList> list){
    	if(list == null)
    		return 0;
    	return dfs(list,1);
    }
    
	private static int dfs(List<NestedList> list, int depth) {
		if(list == null)
			return 0;
		int sum =0;
		for(NestedList i : list){
			if(i.isInteger())
				sum+= (i.getInteger() * depth);
			else
				sum+= dfs(i.getvalues(),depth+1);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		

	}

}
