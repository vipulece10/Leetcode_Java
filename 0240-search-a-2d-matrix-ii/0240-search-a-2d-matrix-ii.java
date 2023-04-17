class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = 0;
        int cols = matrix[0].length - 1;
        
        while( cols >= 0 && rows <= matrix.length - 1){
            if(matrix[rows][cols] == target)
                return true;
            else if (matrix[rows][cols] < target){
                rows++;
            }
            else if (matrix[rows][cols] > target){
                cols--;
            }
        }
        return false;
        
    }
}