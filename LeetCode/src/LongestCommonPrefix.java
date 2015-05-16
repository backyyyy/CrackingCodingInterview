// May 16, 2015

/**
 * Write a function to find the longest common prefix string amongst 
 * an array of strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		
		// This method seems to work in my PC but cannot pass the test cases in Leetcode
		if(strs == null || strs.length == 0) return "";
		if(strs.length == 1) return strs[0];
		
		int length = 0;
		int strNo = strs.length;
		int maxLen = Integer.MAX_VALUE;
		
		for(String s:strs) {
			maxLen = Math.min(maxLen, s.length());
		}
		
		while(length < maxLen) {
			for(int i = 1; i < strNo; i ++) {
				if(strs[0].charAt(length) != strs[i].charAt(length)) {
					return strs[0].substring(0,length);
				} 
			}
			length ++;
		}
		return strs[0].substring(0,length+1);
		 
	}
	
	public String longestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		if(strs.length == 1)  return strs[0];
		
		String str = strs[0];
		for(int i=0;i<str.length(); i++) {
			char c = str.charAt(i);
			for(int j=1;j<strs.length; j++) {
				if(strs[j].length() == i || strs[j].charAt(i) != c) {
					return str.substring(0,i);
				}
			}
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str1 = "asfewage";
		String str2 = "aabsdsfewwagnejnljgle";
		String str3 = "aafgesdsfewwage";
		
		String[] strs = {str1,str2,str3};
		
		LongestCommonPrefix test = new LongestCommonPrefix();
		System.out.println(test.longestCommonPrefix(strs));
		System.out.println(test.longestCommonPrefix2(strs));

	}
}
