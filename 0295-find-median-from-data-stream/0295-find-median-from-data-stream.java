class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        
        if(maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
        }
        
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        
        if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // System.out.println("minHeap   :"+minHeap.peek());
        //  System.out.println("maxHeap   :" +maxHeap.peek());
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }
        
        return ((minHeap.peek() + maxHeap.peek()) * 1.0/2.0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */