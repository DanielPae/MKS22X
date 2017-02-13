public class QueensBoard{
    public int[][] board;

    public QueensBoard(int n){
	board = new int[n][n];
    }

    public boolean solve(){
	return hSolve(0);
    }

    private boolean hSolve(int col){
	if(col == board.length){
	    return true;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(hSolve(col + 1)){
		    return true;
		}removeQueen(col,row);
	    }
	}return false;
    }

    public void addQueen(int col, int row){
       	for(int i = 0; i < board.length; i++){
	    board[col][i]++;
	    board[i][row]++;
	    if(row - col + i < board.length && row - col + i >= 0){
		board[i][row - col + i]++;
	    }
	    if(row + col - i < board.length && row + col - i >= 0){
		board[i][row + col - i]++;
	    }
	    board[col][row] = -1;
	}
    }

    public void removeQueen(int col, int row){
       	for(int i = 0; i < board.length; i++){
	    board[col][i]--;
	    board[i][row]--;
	    if(row - col + i < board.length && row - col + i >= 0){
		board[i][row - col + i]--;
	    }
	    if(row + col - i < board.length && row + col - i >= 0){
		board[i][row + col - i]--;
	    }
	    board[col][row] = 0;
	}
    }

    public String toString(){
	String temp = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		temp = temp + board[c][r] + " ";
	    }temp = temp + "\n";
	}return temp;
    }

    public static void main(String[] args){
	QueensBoard a = new QueensBoard(2);
	a.addQueen(1,1);
	System.out.println(a);
	a.removeQueen(1,1);
	System.out.println(a);
	System.out.println(a.solve());
	System.out.println(a);
	QueensBoard b = new QueensBoard(8);
	b.addQueen(1,1);
	System.out.println(b);
	b.removeQueen(1,1);
	System.out.println(b);
	System.out.println(b.solve());
	System.out.println(b);
    }
}
