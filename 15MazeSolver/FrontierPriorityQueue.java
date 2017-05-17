
public class FrontierPriorityQueue implements Frontier{
    public int size, constant;
    public PriorityLocation[] heap;

    public FrontierPriorityQueue(){
	heap = new PriorityLocation[15];
	constant = 1;
    }

    public FrontierPriorityQueue(boolean isMax){
	heap = new PriorityLocation[15];
	if(!isMax){
	    constant = -1;
	}else{
	    constant = 1;
	}
    }

    public void add(Location l){
	PriorityLocation = null;
	try{
	    PriorityLocation s = (PriorityLocation)l
	}catch
	size++;
	if(size == heap.length){
	    reSize();
	}heap[size] = s;
	pushUp(size);
    }

    public boolean hasNext(){
	return size > 0;
    }

    public PriorityLocation next(){
	PriorityLocation ans = heap[1];
	heap[1] = heap[size];
	size--;
	pushDown(1);
	return ans;
    }

    public PriorityLocation remove(){
	PriorityLocation ans = heap[1];
	heap[1] = heap[size];
	size--;
	pushDown(1);
	return ans;
    }

    public PriorityLocation peak(){
	return heap[1];
    }
    
    private void reSize(){
	PriorityLocation[] ans = new PriorityLocation[size * 2];
	for(int i = 1; i <= size; i++){
	    ans[i] = heap[i];
	}heap = ans;
    }

    private int pushUp(int index){
	while(index != 1 && heap[index / 2].compareTo(heap[index]) * constant < 0){
	    PriorityLocation temp = heap[index];
	    heap[index] = heap[index / 2];
	    heap[index / 2] = temp;
	    index = index / 2;
	}return index;
    }

    private int pushDown(int index){
	PriorityLocation temp = heap[index];
	int swap = 0;
	if(size < index * 2) return index;
	if(size < index * 2 + 1 
	   || heap[index * 2].compareTo(heap[index * 2 + 1]) * constant > 0){
	    swap = index * 2;
	}else{
	    swap = index * 2 + 1;
	}
	if(heap[index].compareTo(heap[swap]) * constant < 0){
	    heap[index] = heap[swap];
	    heap[swap] = temp;
	    return pushDown(swap);
	}else return index;
    }

    public static void main(String args[]){
	FrontierPriorityQueue a = new FrontierPriorityQueue();
	String b = "qwertyuiopasdfghj";
	for(int i = 11; i >= 0; i--){
	    a.add(new PriorityLocation(i,i,i,a.peak()));
	}System.out.println("");
        for(int i = 11; i >= 0; i--){
	    System.out.print(a.remove() + " ");
	}
    }
}
