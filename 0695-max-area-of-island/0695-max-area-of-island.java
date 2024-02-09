class Solution {
    //int count = 0;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
       int max = Integer.MIN_VALUE;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 1){
                    count=0;
                    dfs(grid,rows,cols,i,j);
                     
                    max = Math.max(max,count);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
    
    public void dfs(int[][] grid,int rows,int cols,int i,int j){
        if(i < 0 || i>=rows || j < 0 || j >=cols || grid[i][j] != 1){
            return;
        }
        
        grid[i][j] = 2;
        count++;
        dfs(grid,rows,cols,i-1,j);
        dfs(grid,rows,cols,i+1,j);
        dfs(grid,rows,cols,i,j+1);
        dfs(grid,rows,cols,i,j-1); 
        
    }
    
}