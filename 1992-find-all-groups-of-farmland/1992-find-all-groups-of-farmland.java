class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        int rows = land.length;
        int cols = land[0].length;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(land[i][j] == 1){
                    int [] farmLand = new int[4];
                    farmLand[0] = i;
                    farmLand[1] = j;
                    farmLand[2] = i;
                    farmLand[3] = j;
                    dfs(i,j,rows,cols,land,farmLand);
                    result.add(farmLand);
                }
            }
        }
        return result.toArray(new int[result.size()][4]);
    }
    
    public void dfs(int i,int j,int rows,int cols,int[][]land,int[]farmLand){
        if(i < 0 ||i>= rows || j< 0 || j>=cols || land[i][j] != 1)
            return;
        
        
        farmLand[2] = Math.max(farmLand[2],i);
        farmLand[3] = Math.max(farmLand[3],j);
        land[i][j] = 0;
        
        dfs(i+1,j,rows,cols,land,farmLand);
        dfs(i-1,j,rows,cols,land,farmLand);
        dfs(i,j+1,rows,cols,land,farmLand);
        dfs(i,j-1,rows,cols,land,farmLand);
    }
}