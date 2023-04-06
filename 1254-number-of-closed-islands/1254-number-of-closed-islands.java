class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 0 && dfs(rows,cols,i,j,grid)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int rows,int cols,int i,int j,int[][] grid){
        if(i >= rows || i < 0 || j >= cols || j < 0)
            return false;
        if(grid[i][j] == 1) return true;
        grid[i][j] = 1;
        
        boolean down = dfs(rows,cols,i+1,j,grid);
        boolean up = dfs(rows,cols,i-1,j,grid);
        boolean right = dfs(rows,cols,i,j+1,grid);
        boolean left = dfs(rows,cols,i,j-1,grid);
        return down && up && right && left;
    }
}