class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    dfs(i,j,grid,rows,cols,2);
                   // count++;
                }
            }
        }
        int minutes = 2;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //System.out.println(grid[i][j]);
                if(grid[i][j] == 1)
                    return -1;
            minutes=Math.max(minutes,grid[i][j]);
            }
        }
        
        return minutes - 2;
    }
    
    public void dfs(int i, int j, int[][]grid,int rows,int cols,int mins){
        if(i < 0 || j < 0 || i>=rows || j >= cols || grid[i][j]==0 || (grid[i][j] > 1 && grid[i][j] < mins))
            return;
        
        grid[i][j] = mins;
        
        dfs(i,j+1,grid,rows,cols,mins+1);
        dfs(i,j-1,grid,rows,cols,mins+1);
        dfs(i+1,j,grid,rows,cols,mins+1);
        dfs(i-1,j,grid,rows,cols,mins+1);
    }
}