import java.util.ArrayList;

// May 4, 2015
// Page 72

public class BuildArrayList {
	public ArrayList<String> merge(String[] words, String[] more) {
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}
}
