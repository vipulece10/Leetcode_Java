class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int result = 0;
        int left = 0,right = 0;
        
        if(k == 0)
            return 0;
        
        while(right < nums.length){
            product *= nums[right];
            while(product >= k && left <= right){
                product = product/nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}