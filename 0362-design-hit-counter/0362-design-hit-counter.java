class HitCounter {
    Deque <Integer> dq;
    public HitCounter() {
        dq = new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        dq.add(timestamp);
        int start = timestamp - 300 +1;
        while(dq.peek() < start){
            dq.remove();
        }
    }
    
    public int getHits(int timestamp) {
        int start = timestamp - 300 +1;
        while(dq.size() > 0 && dq.peek() < start){
            dq.remove();
        }
        return dq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */