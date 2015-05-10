// May 10, 2015

/**
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good 
 * question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid 
 * palindrome.
 */

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        String newStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (newStr.length() == 0 || newStr.length() == 1) return true;
        
		char[] fH = newStr.substring(0, newStr.length()/2).toCharArray();
		char[] sH = newStr.substring(newStr.length()/2 + newStr.length() % 2,newStr.length()).toCharArray();
		
		int i = 0;
		for (i=0;i<fH.length;i++) {
			if(fH[i] != sH[sH.length-1-i]) return false;
		}

		return i == fH.length;
    }
	
	public boolean isPalindrome2(String s) {
		s=s.replaceAll("\\W","").toLowerCase();
		for (int i=0;i<s.length()/2;i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
	public boolean isPalindrome3(String s) {
		String ss=s.toLowerCase().replaceAll("[^a-z0-9]","");
		return ss.equals(new StringBuilder(ss).reverse().toString());
	}
	
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		ValidPalindrome test = new ValidPalindrome();
		System.out.println(test.isPalindrome(str)); 
		System.out.println(test.isPalindrome2(str));     
		System.out.println(test.isPalindrome3(str));     

	}
}
