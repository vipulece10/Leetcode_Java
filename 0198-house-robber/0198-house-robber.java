class Solution {
    // Dynamic Programming
    // public int rob(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     dp[0]=nums[0];
    //     for(int i = 1;i< nums.length;i++){
    //         int take = nums[i];
    //         if(i > 1){
    //             take += dp[i - 2];
    //         }
    //         int nonTake = 0 + dp[i -1];
    //         dp[i] = Math.max(take,nonTake);
    //     }
    //     return dp[nums.length - 1];
    // }
    
    // Recursion (TLE)
    
//     public int rob(int[] nums){
//         int n = nums.length -1;
//         return f(n,nums);
//     }
    
//     public int f(int ind,int[] nums){
//         if(ind ==0)
//             return nums[ind];
//         if(ind < 0)
//             return 0;
        
//         int pick = nums[ind] + f(ind-2,nums);
//         int notPick = 0 + f(ind-1,nums);
        
//         return Math.max(pick,notPick);
//     }
    
    // Memoization from Recursion
    
    public int rob(int[] nums){
        int [] dp = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }
    
    public int f(int ind,int[] nums,int[] dp){
        if(ind ==0)
            return nums[ind];
        if(ind < 0)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        int pick = nums[ind] + f(ind-2,nums,dp);
        int notPick = 0 + f(ind-1,nums,dp);
        
        return dp[ind] = Math.max(pick,notPick);
    }
    
    
}