class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        /*
        nums = [1,3,5,2,7,5], minK = 1, maxK = 5
        minKIndex =-1
        maxKIndex =-1
        outOfBoundIndex = -1;
        ans = 0
                 i 
          [1, 3, 5, 2, 7, 5]
           0  1  2  3  4  5
           
           minKIndex = 0
           maxKIndex = 2
           
           ans[0] = -1 + 1 = 0
           ans[1] = 0
           ans[2] = Math.min(minKIndex,maxKIndex) - outOfBoundIndex = 1
           ans[3] = 1
           ans[4] = 0 - 4 = -4 < 0(will not consider)
           ans[5] = Math.min(0,5) - 4
        */
        int minKIndex = -1;
        int maxKIndex =-1;
        int outOfBoundIndex = -1;
        long ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == minK){
                minKIndex = i;
            }
            if(nums[i] == maxK){
                maxKIndex = i;
            }
           if((nums[i] < minK) || (nums[i] > maxK)){
                outOfBoundIndex = i;
            }
            
            int val = Math.min(minKIndex,maxKIndex) - outOfBoundIndex;
            //System.out.println(val);
            if(val > 0){
                ans += val;
            }
        }
        return ans;
    }
}