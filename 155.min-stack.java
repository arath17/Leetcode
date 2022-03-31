import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    Stack<Integer> originStack;
    Stack<Integer> minStack;

    public MinStack() {
        originStack = new Stack<>();
        minStack = new Stack<>();
        
    }
    
    public void push(int val) {
        originStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }  
    }
    
    public void pop() {
        int top = originStack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }   
    }
    
    public int top() {
        return originStack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

