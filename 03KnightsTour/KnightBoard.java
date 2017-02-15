public class KnightBoard{
    private int[][] board;

    public KnightBoard(int r, int c){
	board = new int[r][c];
    }

    public void solve(){
	hSolve(0,0,1);
    }
    public boolean hSolve(int row, int col, int kN){
	if(kN > board.length * board[0].length){
	    return true;
	}
	int[] changes = {1,2,1,-2,-1,2,-1,-2,2,1,2,-1,-2,1,-2,-2};
	if(row < board.length && row >= 0 && col < board[0].length && col >= 0 && board[row][col] == 0){
	    board[row][col] = kN;
	    for(int i = 0; i < changes.length; i+=2){
		if(hSolve(row + changes[i], col + changes[i+1], kN + 1)){
		    return true;
		}
	    }
	    board[row][col] = 0;
	}
	return false;
    }

    public String toString(){
	String temp = "";
	String num = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if(board[r][c] < 10){
		    num = " " + board[r][c];
		}else{
		    num = "" + board[r][c];
		}
		temp = temp + num + " ";
	    }temp = temp + "\n";
	}return temp;
    }

    public static void main(String[] args){
	KnightBoard a = new KnightBoard(7,7);
	a.solve();
	System.out.println(a);
    }
}
