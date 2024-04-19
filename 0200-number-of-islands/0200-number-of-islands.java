class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                dfsToVisitIsland(i,j,rows,cols,grid);
                count++;
                }
            }
        }
        return count;
        
    }
    
    public void dfsToVisitIsland(int i,int j,int rows,int cols,char[][]grid){
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j]!='1'){
            return;
        }
    
        grid[i][j]='2';
        
        dfsToVisitIsland(i+1,j,rows,cols,grid);
        dfsToVisitIsland(i-1,j,rows,cols,grid);
        dfsToVisitIsland(i,j-1,rows,cols,grid);
        dfsToVisitIsland(i,j+1,rows,cols,grid);
    }
}