class Solution {
    int cache[][];
    public int uniquePaths(int m, int n) {
        int mat[][] = new int[m][n];
        cache = new int[m + 1][n + 1];
        for (int arr[] : cache) {
            Arrays.fill(arr, -1);
        }
        return paths(mat, 0, 0);
    }
    
    int paths(int mat[][], int row, int col) {
        if (row > mat.length - 1 || col > mat[0].length - 1) return 0;

        if (row == mat.length - 1 && col == mat[0].length - 1) return 1;

        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        return cache[row][col] = paths(mat, row + 1, col) + paths(mat, row, col + 1);
    }

    
}