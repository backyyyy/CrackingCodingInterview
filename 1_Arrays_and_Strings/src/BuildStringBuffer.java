// May 4, 2015
// Page 72

/** Chapter Keynotes:
 * Difference between String, StringBuffer and StringBuilder:
 * String is immutable. So thread safe and fast.
 * StringBuffer is mutable and thread safe inherently. But much slower.
 * StringBuilder is the same as StringBuffer except not thread safe. But faster.
 * StringBuilder and StringBuffer objects can be converted to String using .toString();
 * 
 * 
 * @author Backy
 *
 */
public class BuildStringBuffer {
	public String joinWords(String[] words) {
		String sentence = "";
		for (String w : words) {
			sentence = sentence + w ;
		}
		return sentence;
	}
	
	public String joinWords2(String[] words) {
		StringBuffer sentence = new StringBuffer();
		for (String w : words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
	
	public String joinWords3(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for (String w : words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
	
	public static void main(String[] args) {
		String[] input = {"This ","is ","a ","test","."};
		BuildStringBuffer test = new BuildStringBuffer();
		System.out.println("1. " + test.joinWords(input));
		System.out.println("2. " + test.joinWords2(input));
		System.out.println("3. " + test.joinWords3(input));
	}
}
