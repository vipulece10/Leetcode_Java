class Solution {
    public int maximumWealth(int[][] accounts) {
        int rows = accounts.length;
        int cols = accounts[0].length;
        int maxWealth = Integer.MIN_VALUE;
        int total = 0;
        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                total += accounts[i][j];
                if(j == cols -1){
                    maxWealth = Math.max(maxWealth,total);
                    total = 0;
                }
            }
        }
        return maxWealth;
    }
}