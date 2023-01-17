class MyQueue {
    Stack <Integer> stackIn;
    Stack <Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    public void push(int x) {
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
        stackIn.push(x);
        while(!stackOut.isEmpty()){
            stackIn.push(stackOut.pop());
        }
    }
    
    public int pop() {
        return stackIn.pop();
    }
    
    public int peek() {
       return stackIn.peek();
    }
    
    public boolean empty() {
        return stackIn.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */