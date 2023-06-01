class Solution {
    class tuple{
        int x;
        int y;
        int length;
        public tuple(int x,int y,int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int [][] direct = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        boolean [][] vis = new boolean[rows][cols];
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,0,1));
        vis[0][0] = true;
        
        while(!q.isEmpty()){
            tuple curr = q.poll();
            int curr_row = curr.x;
            int curr_col = curr.y;
            int path = curr.length;
            if(Math.min(curr_row,curr_col) < 0 || Math.max(curr_row,curr_col) >= rows || grid[curr_row][curr_col]==1)
                continue;
            
            if(curr_row == rows-1 && curr_col == cols-1){
                return path;
            }
                
            
            for(int[] direction : direct){
                int i = curr_row + direction[0];
                int j = curr_col + direction[1];
                if(i >=0 && i < rows && j>=0 && j < cols && vis[i][j] != true){
                q.add(new tuple(i,j,path+1));
                vis[i][j] = true;
                }
            }
            
        }
        return -1;
    }
}