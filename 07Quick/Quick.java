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
	if(k >= lowest - 1 && k < mid){
	    return data[k];
	}if(k < lowest){
	    return quickselectH(data,k,start,lowest - 1);
	}else{
	    return quickselectH(data,k,mid, end);
	}
    }


    private static void swap(int[] data, int low, int high){
	int temp = data[low];
	data[low] = data[high];
	data[high] = temp;
    }
    
    public static void main(String[] args){
	for(int i = 0; i < 1; i++){
	    Random rm = new Random();
	    int[] temp = new int[1000000];
	    for(int x = 0; x < 1000000; x++){
		temp[x] = rm.nextInt(1000000000);
	    }
	    boolean worked = true;
	    System.out.println(quickselect(temp, 2));
	    quicksort(temp);
	    System.out.println(temp[2] + "\n");
	    for(int a = 0; a < 15; a++){
		System.out.print(temp[a] + " ");
	    }/*
	    for(int i = 1; i < temp.length; i++){
		if(temp[i] < temp[i - 1]){
		    worked = false;
		    i = temp.length + 1;
		}
		}System.out.print(worked + "\n");*/
	}
    }
}
