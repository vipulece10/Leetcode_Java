class Solution {
    public int minimizeArrayValue(int[] nums) {
        /*
        Input: nums = [3,7,1,6]
        Output: 5
        
        [3,7,1,6]

        */
        
        int max = 0;
        double cur = 0;
        for (int i = 0; i < nums.length; i++)
        {
            cur += nums[i];
            max = Math.max(max, (int)Math.ceil(cur / (i + 1)));
        }
        return max;
    }
}