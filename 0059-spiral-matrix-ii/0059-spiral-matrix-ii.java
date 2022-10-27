class Solution {
    public int[][] generateMatrix(int n) {
        int [][] ans = new int [n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n - 1;
        int counter = 1;
        
        while(left <= right && top <= bottom && counter <= n*n ){
            for(int i = left;i<=right;i++){
                ans[top][i] = counter;
                counter++;
            }
            top++;
            for(int i = top;i<=bottom;i++){
                ans[i][right] = counter;
                counter++;
            }
            right--;
            for(int i = right;i>=left;i--){
                ans[bottom][i] = counter;
                counter++;
            }
            bottom--;
            for(int i = bottom;i>=top;i--){
                ans[i][left] = counter;
                counter++;
            }
            left++;
        }
        return ans;
    }
}