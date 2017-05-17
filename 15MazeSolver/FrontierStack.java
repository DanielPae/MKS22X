import java.util.Stack;
public class FrontierStack implements Frontier{
    
    private Stack<Location> locations;

    public FrontierStack(){
	locations = new Stack();
    }

    public void add(Location toAdd){
	locations.push(toAdd);
    }
    
    public Location next(){
	return locations.pop();
    }

    public boolean hasNext(){
	return !locations.empty();
    }
}
