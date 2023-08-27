class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                containsOne = true;
                break;
            }
        }
        if(containsOne == false)
            return 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            int a  = Math.abs(nums[i]);
            if(a == n)
                nums[0] = - Math.abs(nums[0]);
            else{
                nums[a] = - Math.abs(nums[a]);
            }
        }
        
        for(int i =1;i< nums.length;i++){
            if(nums[i] > 0)
                return i;
        }
        
        if(nums[0] > 0)
            return n;
        
        return n+1;
    }
}