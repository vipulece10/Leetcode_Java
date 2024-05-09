class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long maxSum = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for(int happy : happiness){
            pq.add(happy);
        }
        
        // for(int i =0;i<pq.size();i++){
        //     pq.
        // }
        
        while(count < k){
            int val = pq.poll();
            if((val - count) > 0){
                maxSum += val - count;
            }
            else{
                break;
            }
           count++; 
        }
        return maxSum;
    }
}