class Solution {
    public int kBigIndices(int[] nums, int k) {
        int ans = 0;
        boolean [] prefix = new boolean[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b- a);
        
        for(int i = 0;i<nums.length;i++){
            if(pq.size()==k && pq.peek() < nums[i]){
                prefix[i] = true;
            }
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        pq.clear();
        
        for(int i = nums.length-1;i>=0;i--){
            if(pq.size() == k && pq.peek() < nums[i] && prefix[i]){
                ans++;
            }
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return ans;
    }
}