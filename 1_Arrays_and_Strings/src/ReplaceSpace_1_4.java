// May 5, 2015
// Interview Question 1.4 page 73

/**
 * Write a method to replace all spaces in a string with'%20'. You may 
 * assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true" 
 * length of the string. (Note: if implementing in Java, please use a 
 * character array so that you can perform this operation in place.)
 * 
 * EXAMPLE
 * Input: "Mr John Smith"
 * Output: "Mr%20Dohn%20Smith"
 */

public class ReplaceSpace_1_4 {
	public void replaceSpaces(char[] input, int length) {
		int numOfSpace = 0;
		for (int i=0; i<length; i++) {
			if(input[i] == ' ') numOfSpace ++;
		}
		
		int newLength = length + (numOfSpace*2);
		input[newLength] = '\0';
		for(int j=length-1; j>=0; j--) {
			if(input[j] == ' ') {
				input[newLength - 1] = '0';
				input[newLength - 2] = '2';
				input[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				input[newLength - 1] = input[j];
				newLength = newLength - 1;
			}
		}
		
		System.out.print("1: ");
		for(char c : input) {
			System.out.print(c);
		}
	}
	
	public void replaceSpaces2(char[] input, int length) {
		String str = String.valueOf(input);
		str = str.replaceAll(" ", "20%");
		input = str.toCharArray();
		
		System.out.print("2: ");
		for(char c : input) {
			System.out.print(c);
		}
	}
	
	public void replaceSpaces3(char[] input, int length) {
		StringBuffer after = new StringBuffer();
		for(char c : input){
			if(c != ' ') after.append(c);
			else after.append("20%");
		}
		System.out.println("3: " + after.toString());
	}
	
	public static void main(String[] args) {
		ReplaceSpace_1_4 test = new ReplaceSpace_1_4();
		String str = "Happy Birth Day to You.";
		char[] input = new char[200];
		str.getChars(0, str.length(), input, 0);
	
		test.replaceSpaces(input, str.length());
//		test.replaceSpaces2(input, str.length());
//		test.replaceSpaces3(input, str.length());
	}
}
