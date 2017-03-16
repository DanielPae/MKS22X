import java.util.Random;
public class Quick{
    
    public static int[] partition(int[] data, int start, int end){
	Random rn = new Random();
	int piviot = rn.nextInt(end - start) + start;
	int highest = end;
	int temp = 0;
	System.out.println(piviot + "");
	for(int i = start; i < end; i++){
	    if(i == highest) i = end;
	    if(i == piviot) i++;
	    if(highest == piviot) highest--;
	    while(i < highest && data[i] < data[piviot]){
		i++;
	    }while(i < highest && data[i] > data[piviot]){
		highest--;
	    }temp = data[highest];
	    data[highest] = data[i];
	    data[i] = temp;
	}temp = data[highest];
	data[highest] = data[piviot];
	data[piviot] = temp;
	return data;
    }

    public static int quickSelect(int[] data, int k){
	data = partition(data,0,data.length - 1);
	return data[k];
    }

    public static void main(String[] args){
	int[] a = {4,2,1,3,5};
	int[] b = partition(a,0,a.length - 1);
	for(int c : b){
	    System.out.print(c + " ");
	}
    }

}
