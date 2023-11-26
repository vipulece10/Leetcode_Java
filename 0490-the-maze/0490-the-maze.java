class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int rows = maze.length;
        int cols = maze[0].length;
        boolean [][] vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        vis[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int [] currCell = q.poll();
            int x = currCell[0];
            int y = currCell[1];
            
            if(x == destination[0] && y == destination[1])
                return true;
            
            for(int [] dir : dirs){
                int newX = x ;
                int newY = y ;
                // if(newX < 0 || newX >= rows || newY < 0 || newY >= cols || maze[newX][newY] == 1 || vis[newX][newY] == true){
                //     continue;
                // }
                while(newX>=0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == 0){
                    newX += dir[0];
                    newY += dir[1];
                }
                newX = newX - dir[0];
                newY = newY - dir[1];
                if(vis[newX][newY] != true){
                    q.add(new int[]{newX,newY});
                    vis[newX][newY] = true;
                }
                
                
            }
        }
        return false;
    }
}