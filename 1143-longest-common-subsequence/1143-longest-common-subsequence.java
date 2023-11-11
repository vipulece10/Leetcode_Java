class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       // Approach 1 
//         int m = text1.length()-1;
//         int n = text2.length()-1;
        
//         return lcsHelper(m,n,text1,text2);   
        
        // Approach 2
        int m = text1.length()-1;
        int n = text2.length()-1;
        int [][] dp = new int[m+1][n+1];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        lcsHelper(m,n,text1,text2,dp); 
       // return lcsHelper(m,n,text1,text2); 
        return dp[m][n];
    }
    
    public int lcsHelper(int m,int n,String text1,String text2,int [][] dp){
        //base condition
        if(m < 0 || n < 0)
            return 0;
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(text1.charAt(m) == text2.charAt(n)){
           // return 1 + lcsHelper(m-1,n-1,text1,text2);
            dp[m][n] = 1 + lcsHelper(m-1,n-1,text1,text2,dp);
            return dp[m][n];
        }
        
        dp[m][n] = Math.max(lcsHelper(m,n-1,text1,text2,dp),lcsHelper(m-1,n,text1,text2,dp));
       // return Math.max(lcsHelper(m,n-1,text1,text2),lcsHelper(m-1,n,text1,text2));
        return dp[m][n];
    }
}