/**
 * XXXXXXXXXXXXX $$$$$$$I did not figure out the solution at all at first!
 * Using two stacks & record the state!
 * 
 * XXXXXXXXXstack.peek()  not peak()
 * 
 * IMPROVEMENT: Do not need to repeatedly push the min value, only need one copy;
 */ 
/*class MinStack {
    Stack<Integer> stack; 
    Stack<Integer> minstack;
    
    MinStack() { stack = new Stack<>(); minstack = new Stack<>(); }
    
    public void push(int x) {
        stack.push(x);
        minstack.push(minstack.isEmpty() ? x : Math.min(x, minstack.peek()));
    }

    public void pop() {
        stack.pop(); minstack.pop();
    }

    public int top() {
        return stack.peek();        
    }

    public int getMin() {
        return minstack.peek();
    }
}*/

class MinStack {
    private Stack<Integer> stack; 
    private Stack<Integer> minstack;
    
    MinStack() { stack = new Stack<>(); minstack = new Stack<>(); }
    
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()) minstack.push(x);
    }

    public void pop() {
        // if (stack.peek() == minstack.peek()) minstack.pop(); // XXXXXX you can not use == here, they are two objects!!!
        if (stack.peek().equals(minstack.peek())) minstack.pop(); 
        stack.pop();
    }

    public int top() {
        return stack.peek();        
    }

    public int getMin() {
        return minstack.peek();
    }
}
