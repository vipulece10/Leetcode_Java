class Solution {
    public void gameOfLife(int[][] board) {
         
        int r=board.length;
        int c= board[0].length;
        int [][] tempboard=new int[r][c];
        int liveneighbors=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                liveneighbors=countLiveNeighbors(i-1,j-1,board) + countLiveNeighbors(i-1,j,board) +countLiveNeighbors(i-1,j+1,board)+countLiveNeighbors(i,j-1,board)+countLiveNeighbors(i,j+1,board)+countLiveNeighbors(i+1,j-1,board)+countLiveNeighbors(i+1,j,board) +countLiveNeighbors(i+1,j+1,board);
                if(board[i][j]==1){
                tempboard[i][j] = (liveneighbors ==2 || liveneighbors == 3) ? 1 :0;
                }
                else{
                 tempboard[i][j] = (liveneighbors == 3) ? 1 :0;   
                }
            }
        }
        
        for(int i =0;i<r;i++){
            board[i]=tempboard[i].clone();
        }
        
    }
    
    public int countLiveNeighbors(int r,int c,int[][]board){
        if(r<0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0 ){
            return 0;
        }
        return 1;
    }
    
}