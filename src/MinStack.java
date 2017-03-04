import java.util.Stack;

public class MinStack {
    public Stack<Integer> stack;
    private static int minValue;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minValue = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
       if(x<= minValue){
           stack.push(minValue);
           minValue = x;
       }
       stack.push(x);
    }
    
    public void pop() {
        if(stack.pop()==minValue) minValue = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.empty()) 
           return Integer.MIN_VALUE;
      //  System.out.println(minValue);
        return minValue;
    }
}