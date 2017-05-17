import java.util.LinkedList;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> locations;

    public FrontierQueue(){
	locations = new LinkedList();
    }

    public void add(Location toAdd){
	locations.addLast(toAdd);
    }

    public boolean hasNext(){
	return locations.size() > 0;
    }

    public Location next(){
	return locations.remove();
    }
}
