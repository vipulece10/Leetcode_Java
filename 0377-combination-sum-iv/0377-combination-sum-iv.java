class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[][] dp = new int[nums.length][target+1];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,nums,target,dp);
    }
    
    public int solve(int index,int[]nums,int target,int[][]dp){
        if(target == 0)
            return 1;
        if(index >= nums.length || target < 0)
            return 0;
        if(dp[index][target] != -1)
            return dp[index][target];
        
        int take = solve(0,nums,target -nums[index],dp);
        int not_take = solve(index+1,nums,target,dp);
        
        return dp[index][target] = take + not_take;
    } 
    
}