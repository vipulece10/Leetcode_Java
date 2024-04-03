class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == word.charAt(0)){
                   if(dfs(board,i,j,word,rows,cols,0))
                       return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board ,int i,int j,String word,int rows,int cols,int count){

        if(count == word.length())
            return true;
        
        if(i < 0 || i >=rows || j >= cols || j < 0 || board[i][j] != word.charAt(count))
            return false;
        
        
        char temp = board[i][j];
        board[i][j]=' ';
        
        if(dfs(board,i,j+1,word,rows,cols,count+1) ||
        dfs(board,i,j-1,word,rows,cols,count+1) ||
        dfs(board,i+1,j,word,rows,cols,count+1) ||
        dfs(board,i-1,j,word,rows,cols,count+1))
            return true;
        
        board[i][j] = temp;
        
        return false;
    }
}