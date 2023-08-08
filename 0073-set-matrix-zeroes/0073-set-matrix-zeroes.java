class Solution {
    public void setZeroes(int[][] matrix) {
        
        /*
         0     0 
        [0,1,2,0],
        [3,4,5,2],
        [1,3,1,5]
        
        */
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isFirstCol = false;
         boolean isFirstRow = false;
        
        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(matrix[i][j] == 0){
                    if( i==0) isFirstRow = true;
                    if( j==0) isFirstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    
                }
            }
        }
        
        
        
    for(int i = 1; i < rows; i++) {
        for(int j = 1; j < cols; j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
        }}
    }
    if(isFirstRow) {
        for(int j = 0; j < cols; j++) {
            matrix[0][j] = 0;
        }
    }
    if(isFirstCol) {
        for(int i = 0; i < rows; i++) {
            matrix[i][0] = 0;
        }
    }

    }
}