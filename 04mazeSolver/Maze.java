import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;
    private int startr, startc;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	String temp = "";
	int numRow = 1;
	int numCol = 0;
	try{
	    Scanner fileReader = new Scanner(new File(filename));
	    temp = fileReader.nextLine();
	    numCol = temp.length();
	    while(fileReader.hasNextLine()){
		temp = temp + fileReader.nextLine();
		numRow++;
	    }
	    char[][] moze = new char[numRow][numCol];
	    boolean founds = false;
	    boolean founde = false;
	    for(int r = 0; r < numRow; r++){
		for(int c = 0; c < numCol; c++){
		    moze[r][c] = temp.charAt(r * numCol + c);
		    if(temp.charAt(r * numCol + c) == 'E'){
			founde = true;	
		    }
		    if(temp.charAt(r * numCol + c) == 'S'){
			founds = true;
			startr = r;
			startc = c;
		    }
		}
	    }if(!(founde && founds)){
		System.exit(0);
	    }
	    maze = moze;
	}
	catch(FileNotFoundException e){
	    System.out.print("file not found");
	    System.exit(0);
	}
    }
    
    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }


    /*
    Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
      */
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    private boolean solve(int row, int col){
	if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(60);
        }
	
        //COMPLETE SOLVE

	if(maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row][col] == '#' || maze[row][col] == '.'){
	    return false;
	}
	if(maze[row][col] == ' '){
	    maze[row][col] = '@';
	}
	else if(maze[row][col] == '@'){
	    maze[row][col] = '.';
	}
	ValidMove[] q = new ValidMove[4];
	q[0] = new ValidMove(1, 0, maze[row + 1][col]);
	q[1] = new ValidMove(0, 1, maze[row][col + 1]);
	q[2] = new ValidMove(-1, 0, maze[row - 1][col]);
	q[3] = new ValidMove(0, -1, maze[row][col - 1]);
	Arrays.sort(q);
	if( solve(row + q[0].rowC, col + q[0].colC) ||
	    solve(row + q[1].rowC, col + q[1].colC) ||
	    solve(row + q[2].rowC, col + q[2].colC) ||
	    solve(row + q[3].rowC, col + q[3].colC)){
	    return true;
	}else{
	    maze[row][col] = '.';
	    return false;
	}
    }

    public String toString(){
	String temp = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		temp = temp + maze[r][c];
	    }
	    temp = temp + "\n";
	}return temp;
    }

    public static void main(String[] args){
	Maze a = new Maze("data1.dat");
	a.animate = true;
	a.solve();
	System.out.println(a);
    }
}

class ValidMove implements Comparable<ValidMove>{
    public int rowC, colC, sortN;

    public ValidMove(int row, int col, char c){
	rowC = row;
	colC = col;
	if(c == ' ' || c == 'E'){
	    sortN = 0;
	}else if(c == '@'){
	    sortN= 1;
	}else{
	    sortN = 2;
	}
    }

    public int compareTo(ValidMove o){
	if(sortN < o.sortN){
	    return -1;
	}if(sortN > o.sortN){
	    return 1;
	}else{
	    return 0;
	}
	
    }
}
