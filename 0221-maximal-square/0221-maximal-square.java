class Solution {
    public int maximalSquare(char[][] matrix) {
        //https://leetcode.com/problems/maximal-square/discuss/3976772/Java-Recursion-greater-DP-Memoization-Easy-to-Understand
        //https://youtu.be/6X7Ha2PrDmM
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][]dp = new int[rows][cols];
        for(int [] rowCells : dp){
            Arrays.fill(rowCells,-1);
        }
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                max = Math.max(max,count(i,j,matrix,dp));
            }
        }
        return max*max;
    }
    
    private int count(int i,int j,char[][] matrix,int[][]dp){
        if(i >= matrix.length || j>= matrix[0].length || matrix[i][j] == '0')
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int down = count(i+1,j,matrix,dp);
        int right = count(i,j+1,matrix,dp);
        int diagonal = count(i+1,j+1,matrix,dp);
        
        dp[i][j] = 1 + Math.min(Math.min(down,right),diagonal);
        
        return dp[i][j];
    }
}