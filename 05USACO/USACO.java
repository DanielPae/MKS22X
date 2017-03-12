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

    public static void main(String args[]){
	System.out.println(silver("test.txt"));
    }
}
