class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int row=mat.length;
        int col=mat[0].length;
        if(row==0 && col==0)
            return new int[0];
        int r=0;
        int c=0;
     //   System.out.print("row "+row+"col "+col);
        int[]res=new int[row*col];
         for(int i=0;i<res.length;i++){
           // System.out.print("row "+r+"col "+c+"//"); 
             res[i]=mat[r][c];
             if((r+c)%2==0){
                 if(c==col-1){
                     r++;
                 }
                 else if(r==0){
                     c++;
                 }
                 else{
                     r--;
                     c++;
                 }
                 
             }
             else{
                 if(r==row-1){
                     c++;
                 }
                 else if(c==0){
                     r++;
                 }
                 else{
                     r++;
                     c--;
                 }
                 
                 
             }
             
         }   
        return res;
    }
}