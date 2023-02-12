class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        long res = 0;
        String ans;
        while(low <= high){
            if(low == high){
            ans = Integer.toString(nums[low]);
            low++;
            }
            else{
            ans = Integer.toString(nums[low]) + Integer.toString(nums[high]);
            low++;
            high--;
            }
            
            res += Integer.parseInt(ans);
        }
        return res;
        
    }
}