public interface Frontier{
    public void add(Location toAdd);
    public Location next();
    public boolean hasNext();
}
