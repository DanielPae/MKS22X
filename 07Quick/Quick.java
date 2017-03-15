import java.util.Random;
public class Quick{
    
    public static int[] partition(int[] data, int start, int end){
	Random rn = new Random();
	int piviot = rn.nextInt(end - start) + start;
	int lowest = start;
	int highest = end;
	int temp = 0;
	System.out.println(piviot + "");
	for(int i = start; i < end; i++){
	    if(piviot != i){
		if(data[i] < data[piviot]){
		    temp = data[lowest];
		    data[lowest] = data[i];
		    data[i] = temp;
		    lowest++;
		    i--;
		}else if(data[i] > data[piviot]){
		    temp = data[highest];
		    data[highest] = data[i];
		    data[i] = temp;
		    highest--;
		    i--;
		}
	    }
	    for(int a : data){
		System.out.print(a + " ");
	    }System.out.print("\n");
	}return data;
    }

    public static void main(String[] args){
	int[] a = {2,10,15,23,0,1};
	System.out.println(a.length);
	int[] b = partition(a,0,a.length - 1);
	for(int c : b){
	    System.out.print(c + " ");
	}
    }

}
