public class MyHeap{
    public int size, constant;
    public int[] heap;

    public MyHeap(){
	heap = new int[15];
	constant = 1;
    }

    public MyHeap(boolean isMax){
	heap = new int[15];
	if(!isMax){
	    constant = -1;
	}else{
	    constant = 1;
	}
    }

    public void add(int s){
	size++;
	if(size == heap.length){
	    reSize();
	}heap[size] = s;
	pushUp(size);
    }

    public int remove(){
	int ans = heap[1];
	heap[1] = heap[size];
	size--;
	pushDown(1);
	return ans;
    }

    public int peak(){
	return heap[1];
    }
    
    private void reSize(){
	int[] ans = new int[size * 2];
	for(int i = 1; i <= size; i++){
	    ans[i] = heap[i];
	}heap = ans;
    }

    private int pushUp(int index){
	while(index != 1 && (heap[index / 2] * constant) < (heap[index] * constant)){
	    int temp = heap[index];
	    heap[index] = heap[index / 2];
	    heap[index / 2] = temp;
	    index = index / 2;
	}return index;
    }

    private int pushDown(int index){
	int temp = heap[index];
	int swap = 0;
	if(size < index * 2) return index;
	if(size < index * 2 + 1 
	   || heap[index * 2] * constant > heap[index * 2 + 1] * constant){
	    swap = index * 2;
	}else{
	    swap = index * 2 + 1;
	}
	if(heap[index] * constant  < heap[swap] * constant){
	    heap[index] = heap[swap];
	    heap[swap] = temp;
	    return pushDown(swap);
	}else return index;
    }

    public static void main(String args[]){
	MyHeap a = new MyHeap(false);
	String b = "qwertyuiopasdfghj";
	for(int i = 11; i >= 0; i--){
	    a.add(i);
	}System.out.println("");
        for(int i = 11; i >= 0; i--){
	    System.out.print(a.remove() + " ");
	}
    }
}
