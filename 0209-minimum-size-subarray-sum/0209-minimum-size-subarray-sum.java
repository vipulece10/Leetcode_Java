class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum =0;
        int min= Integer.MAX_VALUE;
        if (nums == null || nums.length == 0)
        return 0;
        while(j<nums.length){
            sum+=nums[j];
            j++;
            while(sum>=target){
                min=Math.min(min,j-i);
                sum-=nums[i];
                i++;
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;    
    }
}