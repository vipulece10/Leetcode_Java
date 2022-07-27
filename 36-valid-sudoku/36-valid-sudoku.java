class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set <String> set = new HashSet<>();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(set.contains(board[i][j] + "row" + i) ||
                      set.contains(board[i][j] + "col" + j) ||
                       set.contains(board[i][j] + "box" + i/3 +" " +j/3)
                      )
                        return false;
                    else{
                        set.add(board[i][j] + "row" + i);
                        set.add(board[i][j] + "col" + j);
                        set.add(board[i][j] + "box" + i/3 +" " +j/3);
                    }
                }
            }
           
        }
        return true; 
    }
}