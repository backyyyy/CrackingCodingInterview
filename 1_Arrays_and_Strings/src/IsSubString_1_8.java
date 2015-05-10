// May 7, 2015
// Interview Question 1.8 page 74

/**
 * Assume you have a method isSubstring which checks if 
 * one word is a substring of another. Given two strings,
 * s1 and s2, write code to check Ifs2 is a rotation of 
 * s1 using only onecalltoisSubstring (e.g., "waterbottLe"
 * is a rotation of "erbottLewat").
 */

public class IsSubString_1_8 {
	public boolean isRotation(String s1, String s2) {
		
		if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;
		
		String myStr = s1 + s1;
		System.out.println("myStr = " + myStr);
		return isSubstring(myStr, s2);
	}
	
	public boolean isSubstring(String s1, String s2) {
		return false;
		// check if a string is the substring of another string
	}
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		IsSubString_1_8 test = new IsSubString_1_8();
		System.out.print(test.isRotation(s1, s2));
	}
}
