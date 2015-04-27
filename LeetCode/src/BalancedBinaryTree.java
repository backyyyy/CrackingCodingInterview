// Jan 24, 2015
// Reviewed: Feb 1, 2015

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 */

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		
		// Time Complexity: O(N) ?????
		// Space Complexity: O(N)?????
		
        if(root == null) return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    } 
	
	public static void main(String[] args){
		// 1. null or empty tree;
	}
}
