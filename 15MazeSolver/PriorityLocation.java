public class PriorityLocation extends Location{

    private int disToStart;

    public PriorityLocation(int row, int col, int dis, Location p){
	super(row,col, p);
	disToStart = dis;
    }

    public int disToStart(){
	return disToStart;
    }

    public int disToEnd(Location end){
	return (end.row() - this.row()) + (end.col() - this.col());
    }

    public int compareTo(PriorityLocation other){
	if(disToStart > other.disToStart()){
	    return -1;
	}else if(other.disToStart() > disToStart()){
	    return 1;
	}else{
	    return 0;
	}
    }

    public String toString(){
	return "(" + row() + ", " + col() + ") ";
    }
}
