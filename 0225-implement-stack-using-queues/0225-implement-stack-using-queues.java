class MyStack {
    Queue <Integer> queueIn;
    Queue <Integer> queueOut;
    public MyStack() {
        queueIn = new LinkedList<Integer>();
        queueOut = new LinkedList<Integer>();
    }
    
    public void push(int x) {
         while(!queueIn.isEmpty()){
            queueOut.add(queueIn.poll());
        }
        queueIn.add(x);
        while(!queueOut.isEmpty()){
            queueIn.add(queueOut.poll());
        }
    }
    
    public int pop() {
         return queueIn.poll();
    }
    
    public int top() {
         return queueIn.peek();
    }
    
    public boolean empty() {
        return queueIn.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */