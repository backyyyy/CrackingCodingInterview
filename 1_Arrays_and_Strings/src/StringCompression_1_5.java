
// May 5, 2015
// Interview Question 1.5 page 73
/**
 * Implement a method to perform basic string compression using the 
 * counts of repeated characters. For example, the string aabcccccaaa 
 * would become a2blc5a3. If the "compressed" string would not become 
 * smaller than the original string, your method should return the 
 * original string.
 */

public class StringCompression_1_5 {
	public String stringCompression (String input) {
		
		// Time Complexity: O(N) ???????
		// Space Complexity: O(N)
		int[] count = new int[input.length()];
		int cur = 0;
		int next = 1;	
		count[0] = 1;
		
		for (int i=0; i<input.length() - 1; i++){		
			if(input.charAt(cur) == input.charAt(next)) {
				count[cur] ++;
				next ++;
			} else {
				count[next] = 1;
				cur = next;
				next ++;
			}
		}

		StringBuilder str = new StringBuilder();
		for (int i=0; i<count.length; i++) {
			if(count[i] != 0) {
				str.append(input.charAt(i));
				str.append(count[i]);
			} 
		}
		
		if (str.length() >= input.length()) return input;
		else return str.toString();		
	}
	
	public String stringCompression2 (String input) {
		
		// Time Complexity: O(N^2)
		// Space Complexity: O(N)
		String myStr = "";
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if(input.charAt(i) == last) {
				count ++;
			} else {
				myStr += last + "" + count;
				last = input.charAt(i);
				count = 1;
			}
		}
		return myStr + last + count;
	}
	
	public String stringCompression3 (String input) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(N)
		int size = countCompression(input);
		if (size >= input.length()) {
			return input;
		}
		
		StringBuffer myStr = new StringBuffer();
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count ++;
			} else {
				myStr.append(last);
				myStr.append(count);
				last = input.charAt(i);
				count = 1;
			}
		}
		myStr.append(last);
		myStr.append(count);
		return myStr.toString();
	}
	
	int countCompression(String str) {
		if (str == null || str.isEmpty()) return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count ++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;			
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public static void main(String[] args) {
		String input = "aabcccccaaa";
		StringCompression_1_5 test = new StringCompression_1_5();
		System.out.println(test.stringCompression(input));
		System.out.println(test.stringCompression2(input)); 
		System.out.println(test.stringCompression3(input)); 
	}
}
