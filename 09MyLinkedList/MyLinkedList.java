public class MyLinkedList{
    private int size;
    private LNode first, last;


    public MyLinkedList(){

    }
    
    public boolean add(int value){
	if(size == 0){
	    first = new LNode(value);
	    last = first;
	    size++;
	}else{
	LNode newLast = new LNode(value);
        last.setNext(newLast);
	last = newLast;
	size++;
	}
	return true;
    }

    public LNode get(int index){
	if(index < size / 2){
	    LNode current = first;
	    for(int i = 0; i < index; i++){
		current = current.next;
	    }return current;
	}else{
	    LNode current = last;
	    for(int i = size - 1; i >= index; i--){
		current = current.prev;
	    }return current;
	}
    }

    public int set(int index, int newValue){
        LNode current = first;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}int ans = current.value;
	current.value = newValue;
	return ans;
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < size - 1; i++){
	    ans = ans + get(i).value + ", ";
	}ans = ans + get(size - 1).value;
	return ans;
    }
    
    public int indexOf(int value){
	LNode current = first;
	int ans = -1;
	for(int i = 0; i < size; i++){
	    if(current.value == value){
		ans = i;
		i = size + 1;
	    }current = current.next;
	}return ans;
    }

    public void add(int index, int value){
	if(index == size){
	    add(value);
	}else{
	    LNode current = first;
	    LNode goingToAdd = new LNode(value);
	    for(int i = 0; i < index; i++){
		current = current.next;
	    }LNode TBA = new LNode(value);
	    current.next.prev = current;
	    current.setNext(current);
	}
    }
    
    class LNode{
	private int value;
	private LNode next, prev;
    
	public LNode(){
	
	}
	
	public LNode(int val){
	    value = val;
	}
    
	public LNode(int val, LNode n){
	    value = val;
	    next = n;
	}

	public LNode(int val, LNode n, LNode p){
	    value = val;
	    next = n;
	    prev = p;
	}
	
	public void setNext(LNode n){
	    next = n;
	    n.prev = this;
	}
    }
    
    public static void main(String[] args){
	int len = 15;
	MyLinkedList test = new MyLinkedList();
	for(int i = 0; i < len; i++){
	    test.add(i);
	}System.out.println(test.get(14).value);
	test.add(0,9999999);
	System.out.println(test);
    }
}


