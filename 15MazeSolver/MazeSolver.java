public class MazeSolver{
    private Maze maze;
    private int endCol, endRow;
    private boolean aStar;
    private Frontier frontier;

    public MazeSolver(String filename){
	maze = new Maze(filename);
	endCol = maze.getEnd().col();
	endRow = maze.getEnd().row();
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
    }

    public Location endFinder(Location start){
	
    }

    public boolean addLocations(Location prev, int row, int col){
	if(col == endCol && row == endRow){
	    return true;
	}else if(maze.get(row,col) == ' '){
	    if(aStar){
		frontier.add(new PriorityLocation(row, col, prev.disToStart() + 1, prev));
	    }else{
		frontier.add(new Location(row, col, prev));
	    }
	}
	return false;
    }
}

