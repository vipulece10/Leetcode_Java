class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean [][] pacific = new boolean[rows][cols];
        boolean [][] atlantic = new boolean[rows][cols];
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<rows;i++){
            dfs(i,0,rows,cols,Integer.MIN_VALUE,heights,pacific);
            dfs(i,cols-1,rows,cols,Integer.MIN_VALUE,heights,atlantic);
        }
      
        for(int i=0;i<cols;i++){
            dfs(0,i,rows,cols,Integer.MIN_VALUE,heights,pacific);
            dfs(rows-1,i,rows,cols,Integer.MIN_VALUE,heights,atlantic);
        }
        
      //  for(List<Integer> lst : pacific){
      //      System.out.println(lst.get(0) + " " + lst.get(1)); 
      //  }
       
        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }
    
    
    public void dfs(int i,int j,int rows,int cols,int prev,int[][]heights,boolean [][]visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || (prev > heights[i][j]) || visited[i][j] == true){
            return;
        }
        
        //System.out.println(i + " " + j); 
         visited[i][j] = true;
        
        
           dfs(i+1,j,rows,cols,heights[i][j],heights,visited);
           dfs(i-1,j,rows,cols,heights[i][j],heights,visited);
           dfs(i,j+1,rows,cols,heights[i][j],heights,visited);
           dfs(i,j-1,rows,cols,heights[i][j],heights,visited);
        
    }
    
    
}