import java.util.ArrayList;
public class QuizRedux{

    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	String m = "";
	words.add("");
	combinationH( s, words, 0, m);
	return words;
    }

    public static void combinationH(String s, ArrayList<String> words, int index, String word){
	if(index < s.length()){
	    combinationH(s,words,index + 1, word + s.charAt(index));
	    combinationH(s,words,index + 1, word);
	    words.add(word + s.charAt(index));
	}
    }

    public static void main(String[] args){
	System.out.println(combinations("wxof"));
    }
}
