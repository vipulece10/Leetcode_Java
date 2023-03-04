class Solution {
    public int[] leftRigthDifference(int[] nums) {
        if(nums.length == 1)
            return new int[]{0};
        int [] left =new int[nums.length];
        int [] right =new int[nums.length];
         int [] ans =new int[nums.length];
        for(int i =1;i<nums.length;i++){
            left[i] =left[i-1] + nums[i-1]; 
        }
        for(int i = nums.length - 2;i>=0;i--){
            right[i] = right[i+1] + nums[i+1];
        }
        
        for(int i=0;i<ans.length;i++){
            ans[i] = Math.abs(left[i] - right[i]);
        }
        
        return ans;
    }
}