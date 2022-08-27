class TicTacToe {
       int [] sum_rows;
       int [] sum_cols ;
       int diag;
       int adiag;
    public TicTacToe(int n) {
       sum_rows = new int[n];
       sum_cols = new int [n];   
    }
    
    public int move(int row, int col, int player) {
        int incr = 1;
        int size = sum_rows.length;
        if(player == 2){
            incr = -1;
        }
        
        sum_rows[row] += incr;
        sum_cols[col] += incr;
        
        if(row == col){
            diag+=incr;
        }
        if(row+col == size-1){
            adiag+=incr;
        }
        
        if(sum_rows[row] == size || sum_rows[row] == -size || sum_cols[col] ==size || sum_cols[col] ==-size
          || diag ==size ||diag == -size || adiag ==size || adiag ==-size)
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */