public class PriorityLocation extends Location{

    private int disToStart;

    public PriorityLocation(int row, int col, int dis, Location p){
	super(row,col, p);
	disToStart = dis;
    }

    public int pDisToStart(){
	return disToStart;
    }

    public int disToEnd(Location end){
	return (end.row() - this.row()) + (end.col() - this.col());
    }
}
