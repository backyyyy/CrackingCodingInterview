import java.util.Arrays;
import java.util.HashSet;

// May 4, 2015
// Interview Question 1.1 page 73
/**
 * Implement an algorithm to determine if a string has all 
 * unique characters. What if you cannot use additional data
 * structures?
 */

public class UniqueChar_1_1 {
	public boolean isUniqueChar(String input) {	
		
		// Time Complexity: O(N)
		// Space Complexity: O(N)		
		if(input == null || input.length() == 0) return false;
		if(input.length() == 1) return true;
		
		char[] charArray = input.toCharArray();
		HashSet<Character> map = new HashSet<Character>();
		for(char c : charArray) {
			if(map.contains(c)) return false;
			else map.add(c);
		}
		return true;
	}
	
	public boolean isUniqueChar2(String input) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(N)
		if(input == null || input.length() == 0) return false;
		if(input.length() == 1) return true;
		
		char[] charArray = input.toCharArray();
		Arrays.sort(charArray);
		String sorted = String.valueOf(charArray);
		char[] sortedArray = sorted.toCharArray();
		for (int i=1;i<sortedArray.length;i++) {
			if (sortedArray[i] == sortedArray[i-1]) return false;
		}
		return true;
	}
	
	public boolean isUniqueChar3(String input) {
		
		// Assume all char are ASCII code ==> at most 256 char values
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		if (input.length() > 256) return false;
		
		boolean[] char_set = new boolean[256];
		for (int i=0;i<input.length(); i++) {
			int val = input.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public boolean isUniqueChar4(String input) {
		
		// Assume all char are lower case ==> at most 26 char values
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		int checker = 0; // because now only 26 values, 4 bytes are enough
		for (int i=0;i<input.length(); i++) {
			int val = input.charAt(i) - 'a';
			
			if((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String input = "abuingoenawi";
		UniqueChar_1_1 test = new UniqueChar_1_1();
		System.out.println(test.isUniqueChar(input));
		System.out.println(test.isUniqueChar2(input));
		System.out.println(test.isUniqueChar3(input));
		System.out.println(test.isUniqueChar4(input));
	}
}
