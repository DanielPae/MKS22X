import java.util.Scanner;
import java.io.*;
public class USACO{

    public static int silver(String fileName){

	Scanner sc = null;
	try{
	    sc = new Scanner(new File(fileName));
	}catch(FileNotFoundException e){
	    System.out.println("file not found");
	    System.exit(1);
	}
	
	int[][] field = new int[sc.nextInt()][sc.nextInt()];
	int finalStep = sc.nextInt();

	String temp = sc.nextLine();
	for(int r = 0; r < field.length; r++){
	    temp = sc.nextLine();
	    for(int c = 0; c < field[0].length; c++){
		if(temp.charAt(c) == '.'){
		    field[r][c] = 0;
		}else{
		    field[r][c] = -1;
		}
	    }
	}
	int startX = sc.nextInt() - 1;
	int startY = sc.nextInt() - 1;

	field[startX][startY] = 1;

	for(int i = 1; i < finalStep + 2; i++){
	    silverH(field, startY + i);
	}

	return field[sc.nextInt() - 1][sc.nextInt() - 1];
    }

    private static int[][] silverH(int[][] field, int eOo){
	for(int r = 0; r < field.length; r++){
	    int add = (eOo + r) % 2;
	    for(int c = add; c < field[0].length; c += 2){
		if(field[r][c] != -1){
		    isValid(r + 1,c,field,field[r][c]);
		    isValid(r - 1,c,field,field[r][c]);
		    isValid(r,c + 1,field,field[r][c]);
		    isValid(r,c - 1,field,field[r][c]);
		    field[r][c] = 0;
		}
	    }
	}
	return field;
    }

    private static void isValid(int r, int c, int[][] field, int change){
	if(r >= 0 && r < field.length && c >= 0 && c < field[0].length && field[r][c] != -1){
	    field[r][c] += change;
	}
    }



    public static int bronze(String fileName){
	Scanner sc = null;
	try{
	    sc = new Scanner(new File(fileName));
	}catch(FileNotFoundException e){
	    System.out.println("file not found");
	    System.exit(1);
	}

	int[][] lake = new int[sc.nextInt()][sc.nextInt()];
	int elevation = sc.nextInt();
	int inst = sc.nextInt();

	for(int r = 0; r < lake.length; r++){
	    for(int c = 0; c < lake[0].length; c++){
		lake[r][c] = sc.nextInt();
	    }
	}
	for(int i = 0; i < inst; i++){
	    stomp(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), lake);
	}
	
	return total(lake, elevation) * 72 * 72;
    }

    public static void stomp(int r, int c, int digAmount, int[][] lake){
	int highest = 0;
	for(int row = r; row < r + 3; row++){
	    for(int col = c; col < c + 3; col++){
		if(lake[row][col] > highest){
		    highest = lake[row][col];
		}
	    }
	}int newTop = highest - digAmount;
	for(int row = r; row < r + 3; row++){
	    for(int col = c; col < c + 3; col++){
		if(lake[row][col] > newTop){
		    lake[row][col] = newTop;
		}
	    }
	}
    }

    public static int total(int[][] lake, int top){
	int t = 0;
        for(int r = 0; r < lake.length; r++){
	    for(int c = 0; c < lake[0].length; c++){
		if(top - lake[r][c] > 0){
		    t += top - lake[r][c];
		}
	    }
	}return t;
    }
    
    public static void main(String args[]){

    }
}
