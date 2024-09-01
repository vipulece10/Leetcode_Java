class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][]matrix = new int[m][n];
        if(original.length != m*n)
            return new int[][]{};
        
        for(int i =0;i<original.length;i++){
        matrix[i/n][i%n] = original[i];
        }
        
        return matrix;
    }
}