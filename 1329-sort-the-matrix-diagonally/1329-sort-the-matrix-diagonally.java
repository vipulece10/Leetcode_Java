class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        // to iterate on cols
        for(int i =0;i<cols;i++){
            sort(mat,0,i,rows,cols);
        }
        
         // to iterate on rows
        for(int i =1;i<rows;i++){
            sort(mat,i,0,rows,cols);
        }
        
        return mat;
    }
    
    public void sort(int[][]mat,int r,int c,int rows,int cols){
        List<Integer> list = new ArrayList<>();
        int m = r;
        int n = c;
        while(r <  rows && c < cols){
            list.add(mat[r][c]);
            r++;
            c++;
        }
        
       // Collections.sort(list);
        Collections.sort(list);
        int index = 0;
        
        while(m <  rows && n < cols){
            mat[m][n] = list.get(index);
            m++;
            n++;
            index++;
        }
        
    }
}