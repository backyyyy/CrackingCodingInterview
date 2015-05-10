import java.util.Stack;

// May 4, 2015
// Interview Question 1.2 page 73
/**
 * Implement a function void reverse(char* str) in C or C++ which reverses
 * a null-terminated string.
 */

public class ReverseString_1_2 {
	public String reverse(String input) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(N)
		if(input == null || input.length() == 0) return null;
		char[] charArray = input.toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		for (int i=charArray.length-1; i>=0; i--) {
			strBuilder.append(charArray[i]);
		}
		return strBuilder.toString();
	}
	
	public String reverse2(String input) {
		String reverse = "";
		for (int i=input.length()-1; i>=0; i--) {
			reverse += input.charAt(i);
		}
		return reverse;
	}
	
	public String reverse3(String input) {
		StringBuilder reverse = new StringBuilder();
		for (int i=input.length()-1; i>=0; i--) {
			reverse.append(input.charAt(i));
		}
		return reverse.toString();
	}
	
	public String reverse4(String input) {
		StringBuilder reverse = new StringBuilder(input);
		return reverse.reverse().toString();
	}
	
	public String reverse5(String input) {
		StringBuffer reverse = new StringBuffer(input);
		return reverse.reverse().toString();
	}
	
	public String reverse6(String input) {
		Stack<Character> stack = new Stack<Character>();
		String reverse = "";
		for(int i=0;i<input.length(); i++) {
			stack.push(input.charAt(i));
		}
		while(!stack.isEmpty()){
			reverse += stack.pop();
		}
		return reverse;
	}
	
	public static void main(String[] args) {
		String input = "Happy Birthday";
		ReverseString_1_2 test = new ReverseString_1_2();
		System.out.println("1. " + test.reverse(input));
		System.out.println("2. " + test.reverse2(input));
		System.out.println("3. " + test.reverse3(input));
		System.out.println("4. " + test.reverse4(input));
		System.out.println("5. " + test.reverse5(input));
		System.out.println("6. " + test.reverse6(input));
	}
}
