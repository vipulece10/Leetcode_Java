class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{i,nums[i]});
        }
        long sum = 0;
        while(k > 0){
            int[] score = pq.poll();
            sum += score[1];
            score[1] = (int)Math.ceil(score[1] * 1.0/3);
            pq.add(score);
            k--;
        }
        
        return sum;
        
    }
}