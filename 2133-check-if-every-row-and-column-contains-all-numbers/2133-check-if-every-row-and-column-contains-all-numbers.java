class Solution {
    public boolean checkValid(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0;i< rows;i++){
            for(int j = 0;j< cols;j++){
                if(!set.add("Row" + i + "value" + matrix[i][j]) || !set.add("Col" + j + "value" + matrix[i][j]))
                return false;
            }
        }
       return true; 
    }
}