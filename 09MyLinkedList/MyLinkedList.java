import java.lang.Iterable;
import java.util.Iterator;
import java.lang.UnsupportedOperationException;
public class MyLinkedList implements Iterable<Integer>{
    private int size;
    private LNode first, last;


    public MyLinkedList(){

    }
    

    //Adds a int value to the end of the list
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

<<<<<<< HEAD
    public LNode get(int index){
=======
    //Adds a LNode to the end of the value
    public boolean add(LNode TBA){
	if(size == 0){
	    first = TBA;
	    last = first;
	    size++;
	}else{
        last.setNext(TBA);
	last = TBA;
	size++;
	}
	return true;
    }

    //returns the LNode at index index
    private LNode getNthNode(int index){
>>>>>>> 2a792a86f16af2ed828b626d286f2bbaaf28bed7
	if(index < size / 2){
	    LNode current = first;
	    for(int i = 0; i < index; i++){
		current = current.next;
	    }return current;
	}else{
	    LNode current = last;
<<<<<<< HEAD
	    for(int i = size - 1; i >= index; i--){
		current = current.prev;
	    }return current;
	}
=======
	    for(int i = size - 1; i > index; i--){
		current = current.prev;
	    }return current;
	}
    }

    public int get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException(); 
	}
	return getNthNode(index).value;
>>>>>>> 2a792a86f16af2ed828b626d286f2bbaaf28bed7
    }

    //sets the value of LNode at index to newValue
    public int set(int index, int newValue){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException(); 
	}
        LNode current = getNthNode(index);
	int ans = current.value;
	current.value = newValue;
	return ans;
    }

    //currently prints out with debuging stuff
    public String toString(){
	String ans = "";
	for(int i = 0; i < size - 1; i++){
<<<<<<< HEAD
	    ans = ans + get(i).value + ", ";
	}ans = ans + get(size - 1).value;
=======
	    ans = ans + getNthNode(i) + ", ";
	}ans = ans + getNthNode(size - 1);
>>>>>>> 2a792a86f16af2ed828b626d286f2bbaaf28bed7
	return ans;
    }
    
    //returns the index of the LNode with value value
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

    //private methods for helping other public methods
    private void remove(LNode target){
	target.prev.next = target.next;
	target.next.prev = target.prev;
	size--;
    }

    private void addAfter(LNode location, LNode TBA){
	if(location == last){
	    add(TBA);
	}else{
	    TBA.setNext(location.next);
	    location.setNext(TBA);
	}
	size++;
    }

    //pubilc useable add
    public void add(int index, int value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException(); 
	}
	LNode TBA = new LNode(value);
	if(index == 0){
	    TBA.setNext(first);
	    first = TBA;
	    size++;
	}else{
	    addAfter(getNthNode(index - 1), TBA);
	}
    }

    //public useable remove
    public int remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException(); 
	}
	LNode toBeRemoved = getNthNode(index);
	toBeRemoved.prev.setNext(toBeRemoved.next);
	return toBeRemoved.value;
    }

    public MyLinkedListIterator iterator(){
	return new MyLinkedListIterator(this);
    }

    /*       FINISH LATER

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
    */
    
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
	
	public String toString(){
	    String preValue = "";
	    String nextValue = "";
	    if(prev == null){
		preValue = null;
	    }else{
		preValue = prev.value + "";
	    }if(next == null){
		nextValue = null;
	    }else{
		nextValue = next.value + "";
	    }
	    return "(" + preValue + ") " + value + " (" + nextValue + ")";
	}
    }

    class MyLinkedListIterator implements Iterator<Integer>{
	public LNode current;
	

	public MyLinkedListIterator(MyLinkedList i){
	    current = i.first;
	}
	
	public boolean hasNext(){
	    return current.next != null;
	}

	public Integer next(){
	    current = current.next;
	    return current.value;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    public static void main(String[] args){

    }
}


