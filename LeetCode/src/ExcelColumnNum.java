// Jan 14, 2014
// Reviewed: Feb 3, 2015

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 */

public class ExcelColumnNum {

	// Time Complexity: O(N)
	// Space Complexity: O(N)
	
	public int titleToNumber(String s) {
		int num = 0;
		int colNum = 0;
		for(int i=0;i<s.length();i++){
			 num = (int)s.charAt(i) - 64;
			 //colNum += (int) (Math.pow(26, (s.length()-i-1)) * num);
			 colNum = colNum * 26 + num;
		}
		return colNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "AS";
		ExcelColumnNum test = new ExcelColumnNum();
		System.out.println(test.titleToNumber(input));
	}

}
