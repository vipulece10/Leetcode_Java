class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];
        int index = 0;
        
        Deque <Integer> dq = new ArrayDeque();
        for(int i =0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peek() == i - k){
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            
            dq.add(i);
            
            if(i>=k-1){
                res[index++] = nums[dq.peek()];
            }
        }
        return res;
    }
}