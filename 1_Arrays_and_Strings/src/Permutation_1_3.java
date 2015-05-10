import java.util.Arrays;

// May 4, 2015
// Interview Question 1.3 page 73
/**
 * Given two strings, write a method to decide if one is a permutation 
 * of the other.
 */

public class Permutation_1_3 {
	public boolean isPermutation(String a, String b) {
		
		// Time Complexity: O(Nlog N)
		// Space Complexity: O(N)
		if(a == null && b == null) return true;
		if(!(a !=null && b != null)) return false;
		if(a.length() != b.length()) return false;
		
		return sort(a).equals(sort(b));		
	}
	
	public String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public boolean isPermutation2(String a, String b) {
		
		// Assume all chars are in ASCII code
		// Time Complexity: O(N)
		// Space Complexity: O(N)
		if(a.length() != b.length()) return false;
		
		int[] letters = new int[256];
		char[] aArray = a.toCharArray();
		for(char c : aArray) letters[c]++;
		
		for(int i=0; i<b.length();i++){
			int ascii = (int) b.charAt(i);
			if(--letters[ascii] < 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String a = "abugieange";
		String b = "uengiabgea";
		Permutation_1_3 test = new Permutation_1_3();
		System.out.println(test.isPermutation(a, b));
		System.out.println(test.isPermutation2(a, b));		
	}
}
