class Solution {
    public long subArrayRanges(int[] nums) {
        
        /**
        https://leetcode.com/problems/sum-of-subarray-ranges/discuss/2413551/2-Monotonic-stack-easy-to-understand-plus-a-lot-of-explanations
        **/
        Stack <Integer> inc = new Stack<>();
        Stack <Integer> dec = new Stack<>();
        long all_max = 0;
        long all_min = 0;
        
        for(int i =0;i<=nums.length;i++){
            while(!inc.isEmpty() && (i==nums.length || nums[inc.peek()] < nums[i])){
               int curr_index = inc.pop();
               int prev_index = inc.isEmpty() ? -1 : inc.peek();
               int next_index = i;
                all_max += (curr_index - prev_index) * (next_index - curr_index) * (long)nums[curr_index];
            }
            
            while(!dec.isEmpty() && (i==nums.length || nums[dec.peek()] > nums[i])){
                  int curr_index = dec.pop();
                  int prev_index = dec.isEmpty() ? -1 : dec.peek();
                  int next_index = i;
                all_min += (curr_index - prev_index) * (next_index - curr_index) * (long)nums[curr_index];
            }
            
            inc.push(i);
            dec.push(i);
        }
        
         return all_max - all_min;
    }
}