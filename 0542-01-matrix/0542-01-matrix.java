class Solution {
    public class tuple{
        int x;
        int y;
        int dist;
        public tuple(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int [][] distance = new int[r][c];
        boolean [][] vis = new boolean[r][c];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<tuple> q = new LinkedList<>();
        
        for(int i=0;i<r;i++){
            for( int j =0;j<c;j++){
                if(mat[i][j] == 0){
                    q.add(new tuple(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            tuple t = q.poll();
            distance[t.x][t.y] = t.dist; 
            for(int i =0;i<dir.length;i++){
                int rows = t.x + dir[i][0];
                int cols = t.y + dir[i][1];
                int step = t.dist + 1;
                if(rows < 0 || cols < 0 || rows >= r || cols >= c || vis[rows][cols] == true)
                    continue;
                q.add(new tuple(rows,cols,step));
                vis[rows][cols] = true;
            }
            
        }
    return distance;        
    }
}