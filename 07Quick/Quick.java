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

    public static void quicksort(int[] data){
	partition(data,0,data.length - 1);
    }

    public static int quickselect(int[] ary, int k){
        return quickselectH(ary,k,0,ary.length - 1);
    } 

    private static int quickselectH(int[] data, int k, int start, int end){
	Random rn = new Random();
	int piviot = rn.nextInt(end - start) + start;
	swap(data,start,piviot);
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
	System.out.println(lowest - 1 + " " + mid + " " + highest + " " + piviot);
	for(int a : data){
	    System.out.print(a + " ");
	}System.out.print("\n");
	if(k >= lowest && k < mid){
	    return data[k];
	}if(k < lowest){
	    return quickselectH(data,k,start,lowest - 1);
	}else{
	    return quickselectH(data,k,lowest, end);
	}
    }



    private static void swap(int[] data, int low, int high){
	int temp = data[low];
	data[low] = data[high];
	data[high] = temp;
    }
    public static void main(String[] args){
	/*for(int i = 0; i < 100; i++){
	    Random rm = new Random();
	    int[] temp = new int[15];
	    for(int x = 0; x < 15; x++){
		temp[x] = rm.nextInt(15);
		}*/
	int[] temp = {9,8,7,6,5,4,3,2,1,0};
	for(int a : temp){
	    System.out.print(a + " ");
	}System.out.print("\n");
	quickselect(temp, 4);
	for(int a : temp){
	    System.out.print(a + " ");
	}System.out.print("\n" + "\n");
    }

}
