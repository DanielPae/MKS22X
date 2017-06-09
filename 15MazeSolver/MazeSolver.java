public class MazeSolver{
    private Maze maze;
    private int endCol, endRow;
    private boolean aStar, animate;
    private Frontier frontier;

    public MazeSolver(String filename){
	maze = new Maze(filename);
	endCol = maze.getEnd().col();
	endRow = maze.getEnd().row();
	animate = false;
    }

    public MazeSolver(String filename, boolean animate){
	maze = new Maze(filename);
	endCol = maze.getEnd().col();
	endRow = maze.getEnd().row();
	this.animate = animate; 
    }

    public String toString(){
	return "" + maze;
    }

    public String toString(int a){
	return maze.toString(a);
    }

    public void solve(){
	solve(1);
    }
    public void solve(int solveMethod){
	if(solveMethod == 0){
	    frontier = new FrontierStack();
	    aStar = false;
	}else if(solveMethod == 1){
	    frontier = new FrontierQueue();
	    aStar = false;
	}else if(solveMethod == 2){
	    frontier = new FrontierPriorityQueue();
	    aStar = false;
	}else{
	    frontier = new FrontierPriorityQueue();
	    aStar = true;
	}
	//put in other data structures
        Location endLocation = endFinder(maze.getStart());

	Location temp = endLocation;
	while(temp.prev() != null){
	    temp = temp.prev();
	    maze.set(temp.row(), temp.col(), '&');
	}
	maze.set(maze.getStart().row(), maze.getStart().col(), '&');
    }

    public Location endFinder(Location start){
	frontier.add(start);
	Location next = start;
	boolean foundEnd = false;
	while(frontier.hasNext() && !foundEnd){
	    next = frontier.next();
	    maze.set(next.row(), next.col(), '.');
	    if(addLocations(next, next.row() + 1, next.col())) foundEnd = true; 
	    else if(addLocations(next, next.row() - 1, next.col())) foundEnd = true;
	    else if(addLocations(next, next.row(), next.col() + 1)) foundEnd = true;
	    else if(addLocations(next, next.row(), next.col() - 1)) foundEnd = true;
	    if(animate){
		System.out.println(maze.toString(200));
	    }
	}
	if(foundEnd) return frontier.next();
	else{
	    System.out.println("No Possible Path");
	    return maze.getStart();
	}
    }

    public boolean addLocations(Location prev, int row, int col){
	if(col == endCol && row == endRow){
	    frontier.add(new Location(row, col, prev, prev.disToStart() + 1, aStar));
	    return true;
	}else if(maze.get(row,col) == ' '){
	    frontier.add(new Location(row, col, prev, prev.disToStart() + 1, disToEnd(endRow,endCol,row,col),aStar));
	    maze.set(row, col, '?');
	}return false;
    }
    
    public int disToEnd(int er, int ec, int r, int c){
	return (er - r) + (ec - c);
    }
    

    public static void main(String[] args){

    }
}

