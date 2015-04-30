// Apr 30, 2015

/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 *    return "blue is sky the".
 *
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 *
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading 
 * or trailing spaces.
 *
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */

public class ReverseWordsInString {
	public String reverseWords(String s) {
		if(s == null || s.length() == 0) 	return "";
		
		String[] array = s.split(" ");
		StringBuilder temp = new StringBuilder();
		
		for(int i=array.length-1; i>=0; i--) {
			if(!array[i].equals("")) {
				temp.append(array[i]).append(" ");
			}
		}
		return temp.length() == 0 ? "" : temp.substring(0,temp.length() - 1);      
    }
	
	public static void main(String[] args) {
		String input = "Happy Birthday                       To You";
		ReverseWordsInString test = new ReverseWordsInString();
		System.out.println(test.reverseWords(input));
	}
}
