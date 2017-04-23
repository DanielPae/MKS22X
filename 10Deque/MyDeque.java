import java.util.NoSuchElementException;
public class MyDeque{
    private int front, back, size;
    private String[] deque;
    
    public MyDeque(){
	deque = new String[15];
	front = 0;
	back = -1;
    }

    public void doubleSize(){
	String[] bigger = new String[deque.length * 2];
	for(int i = 0; i < size; i++){
	    if(i + front >= deque.length){
		bigger[i] = deque[i + front - deque.length];
	    }else{
		bigger[i] = deque[i + front];
	    }
	}front = 0;
	back = size - 1;
	deque = bigger;
    }

    public void addLast(String toAdd){
	if(toAdd == null){
	    throw new NullPointerException();
	}
	back++;
	size++;
	if(size >= deque.length){
	    doubleSize();
	}
	if(back >= deque.length){
	    back = 0;
	}deque[back] = toAdd;
    }

    public void addFirst(String toAdd){
	if(toAdd == null){
	    throw new NullPointerException();
	}
	front--;
	size++;
	if(size >= deque.length){
	    doubleSize();
	}
	if(front < 0){
	    front = deque.length - 1;
	}deque[front] = toAdd;
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}String ans = deque[front];
	front++;
	size--;
	if(front >= deque.length){
	    front = 0;
	}return ans;
    }

    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}String ans = deque[back];
	back--;
	size--;
	if(back < 0){
	    back = deque.length - 1;
	}return ans;
    }

    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}return deque[front];
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}return deque[back];
    }

    public String toString(){
	String ans = "";
	for(int i = front; i != back + 1; i++){
	    if(i >= deque.length){
		i = 0;
	    }
	    ans = ans + deque[i] + " ";
	}return ans + "\n  Front: " + front + " Back: " + back + " Length:" + deque.length;
    }

    public static void main(String[] args){
	MyDeque test = new MyDeque();
	for(int i = 0; i < 25; i++){
	    test.addLast(i + "");
	}//System.out.println(test);
	//for(String a : test.deque){
	//   System.out.print(a + " ");
	//}System.out.print("\n");
	for(int i = 1; i < 25; i++){
	    test.addFirst(-i + "");
	}for(int i = 0; i < 25; i++){
	    test.removeFirst();
	}//System.out.println(test);
	System.out.println(test);
	//for(String a : test.deque){
	//    System.out.print(a + " ");
	//}
    }
}
