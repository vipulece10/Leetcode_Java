class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int [][]dp = new int[4001][1001];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return dfs(startPos,endPos,k,dp);
    }
    
    private int dfs(int pos, int endPos,int k,int[][]dp){
        if(k < 0)
            return 0;
        if(k == 0){
            if(pos == endPos)
                return 1;
            else{
                return 0;
            }
        }
        if(dp[pos+1000][k] != -1){
            return dp[pos + 1000][k];
        }
        int left = dfs(pos - 1,endPos,k-1,dp);
        int right = dfs( pos + 1,endPos,k-1,dp);
        
        dp[pos + 1000][k] = (left + right) % 1000000007; 
        return dp[pos+1000][k];
        
    }
}