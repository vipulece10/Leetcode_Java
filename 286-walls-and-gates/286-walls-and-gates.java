class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i= 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rooms[i][j] ==0){
                   q.add(new int[]{i,j}); 
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] coordinates = q.poll();
           int row = coordinates[0];
           int col = coordinates[1];
            
            if(row + 1 < rows && rooms[row+1][col] == Integer.MAX_VALUE){
                rooms[row+1][col] = rooms[row][col] +1;
                q.add(new int[]{row+1,col});
            }
            
            if(row - 1 >= 0 && rooms[row-1][col] == Integer.MAX_VALUE){
                rooms[row-1][col] = rooms[row][col] +1;
                q.add(new int[]{row-1,col});
            }
            
            if(col + 1 < cols && rooms[row][col+1] == Integer.MAX_VALUE){
                rooms[row][col+1] = rooms[row][col] +1;
                q.add(new int[]{row,col+1});
            }
            if(col - 1 >= 0 && rooms[row][col-1] == Integer.MAX_VALUE){
                rooms[row][col-1] = rooms[row][col] +1;
                q.add(new int[]{row,col-1});
            }
            
                
        }
        
    }
    
   
}