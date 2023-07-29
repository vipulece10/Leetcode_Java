class Solution {
    public int missingElement(int[] nums, int k) {
        
        for(int i =1;i< nums.length;i++){
            int diff = nums[i] - nums[i-1];
            if(k <= (diff -1))
                return nums[i-1] + k;
            k -= (diff -1);
        }
        return nums[nums.length - 1] + k;
    }
    
}