public class Location{
    
    private Location prev;
    private int row, col;
    
    public Location(int r, int c, Location p){
	row = r;
	col = c;
	prev = p;
    }

    public int row(){
	return row;
    }

    public int col(){
	return col;
    }
}
