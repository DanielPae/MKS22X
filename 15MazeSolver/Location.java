public class Location{
    
    private Location prev;
    private int row, col;
    private int disToStart, disToEnd;
    private boolean aStar;
    
    
    public Location(int r, int c, Location p, int dis, boolean a){
	row = r;
	col = c;
	prev = p;
	disToStart = dis;
	aStar = a;
    }

    public Location(int r, int c, Location a, int b, int d, boolean aS){
	row = r;
	col = c;
	disToStart = 0;
	prev = a;
	disToStart = b;
	disToEnd = d;
	aStar = aS;
    }

    public int row(){
	return row;
    }

    public int col(){
	return col;
    }

    public Location prev(){
	return prev;
    }

    public int disToStart(){
	return disToStart;
    }

    public int disToEnd(){
	return disToEnd;
    }

    public int compareTo(Location other){
	if(!aStar){
	    if(disToEnd() > other.disToEnd()){
		return -1;
	    }else if(other.disToEnd() > disToEnd()){
		return 1;
	    }else{
		return 0;
	    }
	}else{
	    if(disToEnd() + disToStart() > other.disToEnd()+ other.disToStart()){
		return -1;
	    }else if(other.disToEnd() + disToStart() > disToEnd() + disToStart()){
		return 1;
	    }else{
		return 0;
	    }
	}
    }

    public String toString(){
	return "(" + row() + ", " + col() + ") ";
    }
}
