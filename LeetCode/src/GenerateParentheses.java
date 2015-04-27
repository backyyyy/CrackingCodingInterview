import java.util.ArrayList;
import java.util.List;

// Jan 25, 2014

/**
 * Given n pairs of parentheses, write a function to 
 * generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(N) -->???????????????
		
		ArrayList<String> list = new ArrayList<String>();
		if(n==0){
			list.add("");
			return list;
		}
		
		helper(n,0,0,list,"");
		return list;
    }
	
	public void helper(int n, int left, int right, ArrayList<String> arrList, String temp){
		if(left == n){
			for(int i=0;i<n-right;i++){
				temp = temp + ")";
			}
			arrList.add(temp);
			return;
		}
		
		if(left > right){
			helper(n,left+1,right,arrList,temp+"(");
			helper(n,left,right+1,arrList,temp+")");
		} else {
			helper(n,left+1,right,arrList,temp+"(");
		}
	}
	
	public static void main(String[] args){
		
		// 1. n = 0
		// 2. very large n
		// 3. Gaga can you think about more test cases?
		
		GenerateParentheses test = new GenerateParentheses();
		System.out.println(test.generateParenthesis(2));
	}
}
