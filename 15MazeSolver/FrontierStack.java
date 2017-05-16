import java.util.Stack;
public class FrontierStack implements Frontier{
    
    private Stack<Location> Locations;

    public void add(Location toAdd){

    }
    
    public Location next(){
	return new Location(0,0,null);
    }

    public boolean hasNext(){
	return true;
    }
}
