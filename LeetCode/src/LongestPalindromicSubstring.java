// Feb 22, 2015

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 */

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		
		// Time Complexity: O(n * (2n-1)) = O(N)
		// Space Complexity: O(1)
		
		if (s == null || s.length() == 0) 	return "";
		if (s.length() == 1) return s;

		int maxLen = 0;
		String res = "";
		
		for (int i = 0; i < 2 * s.length() - 1; i++) {
			int left = i / 2;
			int right = i / 2;
			if (i % 2 == 1)	right++;
			
			System.out.print("Round " + i + ": ");
			String str = lengthOfPalindrome(s, left, right);
			if (maxLen < str.length()) {
				maxLen = str.length();
				res = str;
				System.out.println("maxLen: " + maxLen);
			}
		}
		return res;
	}

	private String lengthOfPalindrome(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		System.out.println("L: " + left + "; R: " + right+ "; Result: " + s.substring(left + 1, right));
		return s.substring(left + 1, right);
	}
	
	public String longestPalindrome2(String s) {  // Cannot understand why i starts from the back and j is from i to the end
	    if(s == null || s.length()==0)  
	        return "";  
	    boolean[][] palin = new boolean[s.length()][s.length()];  
	    String res = "";  
	    int maxLen = 0;  
	    for(int i=s.length()-1;i>=0;i--)  
	    {  
	        for(int j=i;j<s.length();j++)  
	        {  
	            if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))  
	            {  
	                palin[i][j] = true;  
	                if(maxLen<j-i+1)  
	                {  
	                    maxLen=j-i+1;  
	                    res = s.substring(i,j+1);  
	                    System.out.println("Round " + i + " " + j + ": maxLen: " + maxLen + "; res: " + res);
	                }  
	            }  
	        }  
	    }  
	    return res;  
	}  
	
	public static void main(String[] args) {
		
		// 1. null or empty string;
		// 2. very long string;
		// 3. symmetric around a letter: ababa
		// 4. symmetric around a mid-point: abba
		
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		String input = "ababa";
//		System.out.println(test.longestPalindrome(input));
		System.out.println(test.longestPalindrome2(input));
	}
}
