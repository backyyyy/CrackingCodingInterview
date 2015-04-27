// Jan 20, 2015

/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * } 
 */

public class SortedArray2BST {
    public TreeNode sortedArrayToBST(int[] num) {
    	
    	// Time Complexity: O(N);
    	// Space Complexity: O(N)
    	
        if(num == null || num.length == 0) return null;
        return array2BST(num,0,num.length - 1);
    }
    
    public TreeNode array2BST(int[] input, int start, int end){
    	if(start > end) return null;
    	
    	int mid = (start + end)/2;
    	TreeNode root = new TreeNode(input[mid]);
    	root.left = array2BST(input,start,mid-1);
    	root.right = array2BST(input,mid+1,end);
    	
    	return root;
    }
    
    public static void main(String[] args){
    	
    	// 1. Null or Empty array
    	// 2. {1,1,1,1,1}
    	// 3. very long string;
    	// 4. {0}
    	
    	int[] input = {};
    	SortedArray2BST test = new SortedArray2BST();
    	System.out.println(test.sortedArrayToBST(input));
    }
}
