class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        boolean [][] visited = new boolean[rows][cols];
        dfs_helper(sr,sc,rows,cols,image,color,image[sr][sc],visited);
        return image;
    }
    public void dfs_helper(int i,int j,int rows,int cols,int[][]image,int color,int value,boolean [][] visited){
        if(i< 0 || j < 0 || i>=rows || j >= cols || image[i][j] != value || visited[i][j] == true)
            return;
        visited[i][j] = true;
        image[i][j] = color;
        dfs_helper(i+1,j,rows,cols,image,color,value,visited);
        dfs_helper(i-1,j,rows,cols,image,color,value,visited);
        dfs_helper(i,j+1,rows,cols,image,color,value,visited);
        dfs_helper(i,j-1,rows,cols,image,color,value,visited);
    }
}