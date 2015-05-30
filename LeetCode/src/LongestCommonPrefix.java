// May 16, 2015

/**
 * Write a function to find the longest common prefix string amongst 
 * an array of strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length == 0) return "";
		if(strs.length == 1) return strs[0];
		
		int length = 0;
		int strNo = strs.length;
		int minLen = Integer.MAX_VALUE;
		
		for(String s:strs) {
			minLen = Math.min(minLen, s.length());
		}
		
		while(length < minLen) {
			for(int i = 1; i < strNo; i ++) {
				if(strs[0].charAt(length) != strs[i].charAt(length)) {
					return strs[0].substring(0,length);
				} 
			}
			length ++;
		}
		return strs[0].substring(0,length);		 
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
		String str1 = "";
		String str2 = "";
		String str3 = "";
		
		String[] strs = {str1,str2,str3};
		
		LongestCommonPrefix test = new LongestCommonPrefix();
		System.out.println(test.longestCommonPrefix(strs));
		// System.out.println(test.longestCommonPrefix2(strs));

	}
}
