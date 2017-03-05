public class QueenBoard{
    public int[][] board;
    private int solutionCount;

    public QueenBoard(int n){
	board = new int[n][n];
	solutionCount = -1;
    }

    public void solve(){
	this.hSolve(0);
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

    public void countSolutions(){
	solutionCount = 0;
	this.hCountSolutions(0);
    }

    public boolean hCountSolutions(int col){
	if(col == board.length){
	    return true;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(hCountSolutions(col + 1)){
		    solutionCount++;
		}
		removeQueen(col,row);
	    }
	}return false;
    }

    public int getSolutionCount(){
	return solutionCount;
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
	char charTemp = 'q';
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if(board[c][r] == -1){
		    charTemp = 'Q';
		}else{
		    charTemp = '_';
		}
		temp = temp + charTemp + " ";
	    }temp = temp + "\n";
	}return temp;
    }

    public static void main(String[] args){
	QueensBoard a = new QueensBoard(2);
	a.addQueen(1,1);
	System.out.println(a);
	a.removeQueen(1,1);
	System.out.println(a);
	a.solve();
	System.out.println(a);
	QueensBoard b = new QueensBoard(16);
	b.addQueen(1,1);
	System.out.println(b);
	b.removeQueen(1,1);
	System.out.println(b);
        b.solve();
	System.out.println(b);
	QueensBoard c = new QueensBoard(6);
	c.countSolutions();
	System.out.println(c.getSolutionCount());
    }
}
