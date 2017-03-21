import java.util.Random;
public class Quick{
    
    public static void partition(int[] data, int start, int end){
	if(start < end){
	    int highest = end;
	    int lowest = start + 1;
	    int mid = start + 1;
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
	    }swap(data, start, lowest - 1);
	    partition(data,start,lowest - 1);
	    partition(data,mid,end);
        }
    }


    private static void swap(int[] data, int low, int high){
	int temp = data[low];
	data[low] = data[high];
	data[high] = temp;
    }
    public static void main(String[] args){
	for(int i = 0; i < 100; i++){
	    Random rm = new Random();
	    int[] temp = new int[15];
	    for(int x = 0; x < 15; x++){
		temp[x] = rm.nextInt(5);
	    }
	    for(int a : temp){
		System.out.print(a + " ");
	    }System.out.print("\n");
	    partition(temp, 0, temp.length - 1);
	    for(int a : temp){
		System.out.print(a + " ");
	    }System.out.print("\n" + "\n");
	}
    }

}
