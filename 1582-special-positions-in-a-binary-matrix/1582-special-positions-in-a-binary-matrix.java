class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(mat[i][j] == 1 && isSpecial(mat,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isSpecial(int [][] mat,int i,int j){
        int numOnes = 0;
        for(int col = 0;col< mat[0].length;col++){
            if(mat[i][col] == 1){
                numOnes++;
            }
        }
        
        for(int row = 0;row< mat.length;row++){
            if(mat[row][j] == 1){
                numOnes++;
            }
        }
        
        return numOnes == 2;
        
    }
}