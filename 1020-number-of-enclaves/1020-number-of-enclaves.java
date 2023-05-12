class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = 0;i<cols;i++){
            if(grid[0][i] == 1){
                dfs(0,i,rows,cols,grid);
            }
            if(grid[rows-1][i] == 1){
                dfs(rows-1,i,rows,cols,grid);
            }
        }
        
        for(int j = 0;j<rows;j++){
            if(grid[j][0] == 1){
                dfs(j,0,rows,cols,grid);
            }
            if(grid[j][cols- 1] == 1){
                dfs(j,cols-1,rows,cols,grid);
            }
        }
        int count = 0;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int i,int j,int rows,int cols,int[][] grid){
        if(i<0 || i>=rows || j < 0 || j>= cols || grid[i][j] != 1)
            return;
        
        grid[i][j] = 2;
        
        dfs(i+1,j,rows,cols,grid);
        dfs(i-1,j,rows,cols,grid);
        dfs(i,j+1,rows,cols,grid);
        dfs(i,j-1,rows,cols,grid);
    }
}