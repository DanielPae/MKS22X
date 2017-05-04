public class MyHeap{
    public int size, constant;
    public String[] heap;

    public MyHeap(){
	heap = new String[15];
	constant = 1;
    }

    public MyHeap(boolean isMax){
	heap = new String[15];
	constant = -1;
    }

    public void add(String s){
	size++;
	if(size == heap.length){
	    reSize();
	}heap[size] = s;
    }

    private void reSize(){
	String[] ans = new String[size * 2];
	for(int i = 1; i <= size; i++){
	    ans[i] = heap[i];
	}heap = ans;
    }

    private int pushUp(int index){
	String temp = heap[index];
	heap[index] = heap[index / 2];
	heap[index / 2] = temp;
	index = index / 2;
	System.out.println(heap[index / 2]);
	if(index != 1 && heap[index / 2].compareTo(heap[index]) * constant > 0){
	    return pushUp(index);
	}return index;
    }

    private int pushDown(int index){
	String temp = heap[index];
	if(heap[index * 2].compareTo(heap[index * 2 + 1]) * constant < 0){
	    heap[index] = heap[index * 2 + 1];
	    heap[index * 2 + 1] = temp;
	    return index * 2 + 1;
	}else{
	    heap[index] = heap[index * 2];
	    heap[index * 2] = temp;
	    return index * 2;
	}
	if(index != size && 
	   heap[index * 2].compareTo
    }

    public static void main(String args[]){
	MyHeap a = new MyHeap();
	for(int i = 0; i < 10; i++){
	    a.add(i + " ");
	}a.pushUp(4);
	a.pushDown(1);
	for(String n : a.heap){
	    System.out.print(n);
	}
    }
}
