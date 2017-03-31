import java.util.Random;
public class Merge{
    
    public static void mergesort(int[] ary){
	mergeSortH(ary);
    }

    public static int[] mergeSortH(int[] ary){
	if(ary.length == 1){
	    return ary;
	}else{
	    int[] left = new int[ary.length / 2];
	    int[] right = new int[ary.length - left.length];
	    for(int i = 0; i < left.length; i++){
		left[i] = ary[i];
	    }for(int i = left.length; i < ary.length; i++){
		right[i - left.length] = ary[i];
	    }
	    left = mergeSortH(left);
	    right = mergeSortH(right);
	    int[] c = merge(left,right);
	    for(int i = 0; i < c.length; i++){
		ary[i] = c[i];
	    }
	}return ary;
    }

    public static int[] merge(int[] ary1, int[] ary2){
	int[] ans = new int[ary1.length + ary2.length];
	int aryCounter1 = 0;
	int aryCounter2 = 0;
	int newAryCounter = 0;
	while(aryCounter1 < ary1.length && aryCounter2 < ary2.length){
	    if(ary1[aryCounter1] > ary2[aryCounter2]){
		ans[newAryCounter] = ary2[aryCounter2];
		aryCounter2++;
	    }else{
		ans[newAryCounter] = ary1[aryCounter1];
		aryCounter1++;
	    }
	    newAryCounter++;
	}if(aryCounter1 >= ary1.length){
	    for(int i = newAryCounter; i < ans.length; i++){
		ans[i] = ary2[aryCounter2];
	    }
	}else{
	    for(int i = newAryCounter; i < ans.length; i++){
		ans[i] = ary1[aryCounter1];
	    }
	}return ans;
    }

    public static void main(String[] args){
	Random rm = new Random();
	for(int k = 0; k < 100; k++){
	    int[] temp = new int[10000000];
	    for(int x = 0; x < 10000000; x++){
		temp[x] = rm.nextInt(100);
	    }
	    boolean worked = true;
	    mergesort(temp);
	    for(int i = 1; i < temp.length; i++){
		if(temp[i] < temp[i - 1]){
		    worked = false;
		    i = temp.length + 1;
		}
	    }System.out.print(worked + "\n");
	}
    }
}

