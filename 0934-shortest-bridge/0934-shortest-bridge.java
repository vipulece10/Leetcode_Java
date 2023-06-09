class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row ,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int shortestBridge(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        boolean[][]vis = new boolean[n][n];
        boolean flag = false;
        for(int i =0;i<n && !flag;i++){
            for(int j =0;j< n && !flag;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid,q,n,vis);
                    flag = true;
                }
            }
        }
        int [][]dir ={{0,1},{0,-1},{1,0},{-1,0}};
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                Pair rem = q.poll();
                
                for(int j =0;j<dir.length;j++){
                    int row = rem.row + dir[j][0];
                    int col = rem.col + dir[j][1];
                    if(row < 0 || col < 0 || row >=n || col >=n || vis[row][col] == true)
                        continue;
                    if(grid[row][col] == 1)
                        return level;
                    q.add(new Pair(row,col));
                    vis[row][col] = true;
                }
            }
            level++;
        }
        return level;
    }
    
    public void dfs(int i,int j,int[][]grid,Queue<Pair> q,int n,boolean[][]vis){
        if(i < 0 || i>= n || j < 0 || j>=n || grid[i][j] == 0 || vis[i][j] == true)
            return;
        vis[i][j] = true;
        q.add(new Pair(i,j));
        dfs(i+1,j,grid,q,n,vis);
        dfs(i-1,j,grid,q,n,vis);
        dfs(i,j+1,grid,q,n,vis);
        dfs(i,j-1,grid,q,n,vis);
        
    }
}