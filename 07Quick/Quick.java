import java.util.Random;
public class Quick{
    
    public static int partition(int[] data, int start, int end){
	Random rn = new Random();
	int piviot = rn.nextInt(end - start) + start;
	int highest = end;
	int lowest = start + 1;
	int mid = start + 1;
	swap(data, start, piviot);
	System.out.print("\n");
	while(mid <= highest){
	    if(data[mid] < data[start]){
		swap(data, lowest, mid);
		lowest++;
		mid++;
	    }else if(data[mid] > data[start]){
		swap(data, highest, mid);
		highest--;
	    }else{
		mid++;
	    }
	    System.out.print("\nlowest: " + lowest + " highest: " + highest + " mid: " + mid + "\n");
	    for(int a : data){
		System.out.print(a + " ");
	    }System.out.print("\n");
	}swap(data, start, lowest - 1);
	System.out.print("\nlowest: " + lowest + " highest: " + highest + " mid: " + mid);
	return piviot;
        
    }

    public static int quickSelect(int[] data, int k){
	return partition(data,0,data.length - 1);
    }

    private static void swap(int[] data, int low, int high){
	int temp = data[low];
	data[low] = data[high];
	data[high] = temp;
    }
    public static void main(String[] args){
	for(int i = 0; i < 1; i++){
	    Random rm = new Random();
	    int[] temp = new int[15];
	    for(int x = 0; x < 15; x++){
		temp[x] = rm.nextInt(5);
	    }
	    for(int a : temp){
		System.out.print(a + " ");
	    }
	    System.out.print("\n" + partition(temp,0,temp.length - 1) + "\n");
	    for(int a : temp){
		System.out.print(a + " ");
	    }System.out.print("\n" + "\n");
	}
    }

}
