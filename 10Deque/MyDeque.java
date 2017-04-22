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
	for(int i = 0; i < deque.length; i++){
	    bigger[i] = deque[i];
	}deque = bigger;
    }

    public void addLast(String toAdd){
	back++;
	if(back >= deque.length){
	    back = 0;
	}if(size - 1 == deque.length){
	    doubleSize();
	}deque[back] = toAdd;
	size++;
    }

    public void addFirst(String toAdd){
	front--;
	if(front < 0){
	    front = deque.length - 1;
	}if(size - 1 == deque.length){
	    doubleSize();
	}deque[front] = toAdd;
	size++;
    }

    public String toString(){
	String ans = "";
	for(int i = front; i != back + 1; i++){
	    if(i >= deque.length){
		i = 0;
	    }
	    ans = ans + deque[i] + " ";
	}return ans + "\n  Front: " + front + " Back: " + back;
    }

    public static void main(String[] args){
	MyDeque test = new MyDeque();
	for(int i = 0; i < 15; i++){
	    test.addLast(i + "");
	}
	//for(String a : test.deque){
	//   System.out.print(a + " ");
	//}System.out.print("\n");
	for(int i = 1; i < 15; i++){
	    test.addFirst(-i + "");
	}System.out.println(test);
	//for(String a : test.deque){
	//    System.out.print(a + " ");
	//}
    }
}
