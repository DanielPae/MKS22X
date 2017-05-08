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
	pushUp(size);
    }

    public String remove(){
	String ans = heap[1];
	heap[1] = heap[size];
	size--;
	pushDown(1);
	return ans;
    }

    public String peak(){
	return heap[1];
    }
    
    private void reSize(){
	String[] ans = new String[size * 2];
	for(int i = 1; i <= size; i++){
	    ans[i] = heap[i];
	}heap = ans;
    }

    private int pushUp(int index){
	while(index != 1 && heap[index / 2].compareTo(heap[index]) * constant > 0){
	    String temp = heap[index];
	    heap[index] = heap[index / 2];
	    heap[index / 2] = temp;
	    index = index / 2;
	    for(String n : heap){
		System.out.print(n);
	    }System.out.println("");
	}return index;
    }

    private int pushDown(int index){
	String temp = heap[index];
	if(size > index * 2 
	   && heap[index].compareTo(heap[index * 2]) * constant > 0
	   && (size < index * 2 + 1 ||
	       heap[index * 2].compareTo(heap[index * 2 + 1]) * constant > 0)){
	    heap[index] = heap[index * 2];
	    heap[index * 2] = temp;
	    return pushDown(index * 2);
	}else if(size > index * 2 + 1
		 && heap[index].compareTo(heap[index * 2 + 1]) * constant > 0){
	    heap[index] = heap[index * 2 + 1];
	    heap[index * 2 + 1] = temp;
	    return pushDown(index * 2 + 1);
	}return index;
    }

    public static void main(String args[]){
	MyHeap a = new MyHeap();
	String b = "abcdefghijkmlnop";
	for(int i = 11; i >= 0; i--){
	    a.add(" " + b.charAt(i) + i + " ");
	}System.out.println("");
        for(int i = 11; i >= 0; i--){
	    System.out.print(a.remove() + " ");
	}
    }
}
