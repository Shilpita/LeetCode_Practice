import java.util.*;

public class KillProcesses582 {	    
	    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
	        List<Integer> list = new ArrayList<Integer>();
	        HashMap<Integer,ArrayList<Integer>> map =new HashMap<Integer,ArrayList<Integer>>();
	        for(int i =0 ; i< ppid.size();i++){
	            if(ppid.get(i) > 0){
	            	ArrayList<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
	            	l.add(pid.get(i));
	            	map.put(ppid.get(i), l);
	            }
	        }
	        list.add(kill);
	        getChildAll(map,list,kill);
	        
	        return list;
	    }
	    
	    public static void getChildAll(HashMap<Integer,ArrayList<Integer>> map, List<Integer> list,int kill){
	    	if(map.containsKey(kill)){
	    		for(int id : map.get(kill)){
	    			list.add(id);
	    			getChildAll(map, list, id);
	    		}
	    	}
	    }
	
	public static void main(String[] args) {
		

	}

}
