public class QueensBoard{
    public int[][] board;

    public QueensBoard(int n){
	board = new int[n][n];
    }

    public boolean solve(){
	return hSolve(0);
    }

    private boolean hSolve(int col){
	if(col == 0){
	    return true;
	}
	for(int row; row < board.length; row++){
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(solveH(col + 1)){
		    return true;
		}removeQueen(col,row);
	    }
	}return false;
    }

    public void addQueen(int col, int row){
	board[col][row] == -1;
	for(int i = 0; i < board.length; i++){
	    board[col][i]++;
	    board[i][row]++;
	    if(i < board.length){
		board[i][row + col]
	    }
	}
    }
}
